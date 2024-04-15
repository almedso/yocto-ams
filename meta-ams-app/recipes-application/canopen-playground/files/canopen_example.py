#!/usr/bin/env python3
"""
canopen_test.py

This module contains code to run tests
on CANopen devices including a PDO jitter analysis test.


Modification History

AUTHOR    DATE          REASON FOR CHANGE
--------  --------      ----------------------------------
JPS       12-01-2020    Initial code.
CMR       12-14-2020    Added SDO reading and PDO RT tests
"""

import argparse
import can
import canopen
from dataclasses import dataclass
from enum import Enum
import logging
from queue import Queue
import time


class CANopenCOBIds(Enum):
    """
    Types of CANopen base COB-IDs.
    """
    # NMT service
    nmt_service = 0x0000
    # SYNC object
    sync = 0x0080
    # EMERGENCY object
    emergency = 0x0080
    # PDO1 transmit object
    pdo1_tx = 0x0180
    # PDO1 receive object
    pdo1_rx = 0x0200
    # PDO2 transmit object
    pdo2_tx = 0x0280
    # PDO2 receive object
    pdo2_rx = 0x0300
    # PDO3 transmit object
    pdo3_tx = 0x0380
    # PDO3 receive object
    pdo3_rx = 0x0400
    # PDO4 transmit object
    pdo4_tx = 0x0480
    # PDO4 receive object
    pdo4_rx = 0x0500
    # SDO transmit object
    sdo_tx = 0x0580
    # SDO receive object
    sdo_rx = 0x0600
    # NMT error object
    nmt_error = 0x0700

    @classmethod
    def has_value(cls, value):
        """
        Method to determine if a particular value matches one of the values of
        the enumerations of this class.

        :param value: Value to check.
        :return: True if the value is one of the enumerated value,
        otherwise False.
        """
        return any(value == item.value for item in cls)


class CANopenComObjectTypes(Enum):
    """
    Types of CANopen communication objects.
    """
    # NMT service
    nmt_service = 0
    # SYNC object
    sync = 1
    # EMERGENCY object
    emergency = 2
    # PDO1 transmit object
    pdo1_tx = 3
    # PDO1 receive object
    pdo1_rx = 4
    # PDO2 transmit object
    pdo2_tx = 5
    # PDO2 receive object
    pdo2_rx = 6
    # PDO3 transmit object
    pdo3_tx = 7
    # PDO3 receive object
    pdo3_rx = 8
    # PDO4 transmit object
    pdo4_tx = 9
    # PDO4 receive object
    pdo4_rx = 10
    # SDO transmit object
    sdo_tx = 9
    # SDO receive object
    sdo_rx = 10
    # NMT error object
    nmt_error = 10

    @classmethod
    def has_value(cls, value):
        """
        Method to determine if a particular value matches one of the values of
        the enumerations of this class.

        :param value: Value to check.
        :return: True if the value is one of the enumerated value,
        otherwise False.
        """
        return any(value == item.value for item in cls)


class CANopenNMTFunctionCodes(Enum):
    """
    CANopen NMT function codes for placing nodes into specified states.
    """
    # enter operational state
    operational = 0x01
    # enter stop state
    stop = 0x02
    # enter pre-operational state
    preoperational = 0x80
    # reset node
    reset_node = 0x81
    # reset communications
    reset_comms = 0x82

    @classmethod
    def has_value(cls, value):
        """
        Method to determine if a particular value matches one of the values of
        the enumerations of this class.

        :param value: Value to check.
        :return: True if the value is one of the enumerated value, otherwise
        False.
        """
        return any(value == item.value for item in cls)


@dataclass
class CANOpenComObject:
    """
    Dataclass for saving information for a received message
    """
    cob_id: CANopenCOBIds               # CANopen COB-ID for the message
    object_type: CANopenComObjectTypes  # COM object type
    type_str: str                       # descriptive string of message type


class CANopenTesterListener(can.Listener):
    """
    This class is a CAN listener that is passed received CAN messages from the
    lower level python-can library code and queues the messages from later
    processing.  The class also contains routines to parse the received
    messages.
    """
    # different types of CANopen com objects
    canopen_com_objects = {CANopenCOBIds.nmt_service:
                           CANOpenComObject(CANopenCOBIds.nmt_service,
                                            CANopenComObjectTypes.nmt_service,
                                            'NMT Service'),

                           CANopenCOBIds.sync:
                           CANOpenComObject(CANopenCOBIds.sync,
                                            CANopenComObjectTypes.sync,
                                            'SYNC'),

                           CANopenCOBIds.emergency:
                           CANOpenComObject(CANopenCOBIds.emergency,
                                            CANopenComObjectTypes.emergency,
                                            'EMERGENCY'),

                           CANopenCOBIds.pdo1_tx:
                           CANOpenComObject(CANopenCOBIds.pdo1_tx,
                                            CANopenComObjectTypes.pdo1_tx,
                                            'PDO1 TX'),

                           CANopenCOBIds.pdo1_rx:
                           CANOpenComObject(CANopenCOBIds.pdo1_rx,
                                            CANopenComObjectTypes.pdo1_rx,
                                            'PDO1 RX'),

                           CANopenCOBIds.pdo2_tx:
                           CANOpenComObject(CANopenCOBIds.pdo2_tx,
                                            CANopenComObjectTypes.pdo2_tx,
                                            'PDO2 TX'),

                           CANopenCOBIds.pdo2_rx:
                           CANOpenComObject(CANopenCOBIds.pdo2_rx,
                                            CANopenComObjectTypes.pdo2_rx,
                                            'PDO2 RX'),

                           CANopenCOBIds.pdo3_tx:
                           CANOpenComObject(CANopenCOBIds.pdo3_tx,
                                            CANopenComObjectTypes.pdo3_tx,
                                            'PDO3 TX'),

                           CANopenCOBIds.pdo3_rx:
                           CANOpenComObject(CANopenCOBIds.pdo3_rx,
                                            CANopenComObjectTypes.pdo3_rx,
                                            'PDO3 RX'),

                           CANopenCOBIds.pdo4_tx:
                           CANOpenComObject(CANopenCOBIds.pdo4_tx,
                                            CANopenComObjectTypes.pdo4_tx,
                                            'PDO4 TX'),

                           CANopenCOBIds.pdo4_rx:
                           CANOpenComObject(CANopenCOBIds.pdo4_rx,
                                            CANopenComObjectTypes.pdo4_rx,
                                            'PDO4 RX'),

                           CANopenCOBIds.sdo_tx:
                           CANOpenComObject(CANopenCOBIds.sdo_tx,
                                            CANopenComObjectTypes.sdo_tx,
                                            'SDO TX'),

                           CANopenCOBIds.sdo_rx:
                           CANOpenComObject(CANopenCOBIds.sdo_rx,
                                            CANopenComObjectTypes.sdo_rx,
                                            'SDO RX'),

                           CANopenCOBIds.nmt_error:
                           CANOpenComObject(CANopenCOBIds.nmt_error,
                                            CANopenComObjectTypes.nmt_error,
                                            'NMT Error Control')}

    # queue for receiving CANopen messages
    message_queue: "Queue[can.Message]" = Queue()

    def __init__(self, log_handle: logging.Logger):
        """
        Class initializer.
        """
        # Python logging object to use for any log messages that need
        # to be generated
        self.log = log_handle

    def message_parser(self,
                       msg: can.Message,
                       log_msg: bool) -> CANOpenComObject:
        """
        This routine parses a received message and creates the equivalent
        CANOpenComObject.

        :param msg: CAN message to be parsed
        :param log_msg: True if the results of the message parsing should be
        outputted to the log.
        :return: A CANOpenComObject for the parsed message
        """
        com_object = None

        # determine the type of message that has been received
        if msg.arbitration_id == CANopenCOBIds.nmt_service.value:
            # this is a NMT service message
            com_object = CANopenTesterListener.canopen_com_objects[CANopenCOBIds.nmt_service]

        elif msg.arbitration_id == CANopenCOBIds.sync.value:
            # this is a SYNC message
            com_object = CANopenTesterListener.canopen_com_objects[CANopenCOBIds.sync]

        elif (CANopenCOBIds.emergency.value + 1) <= msg.arbitration_id <= (CANopenCOBIds.emergency.value + 127):
            # this is an EMERGENCY message
            com_object = CANopenTesterListener.canopen_com_objects[CANopenCOBIds.emergency]

        else:
            # this is some other type of message
            base_cob_id = msg.arbitration_id & 0xff80
            if CANopenCOBIds.has_value(base_cob_id):
                cob_id = CANopenCOBIds(base_cob_id)
                com_object = CANopenTesterListener.canopen_com_objects[cob_id]

        msg_data_str = (''.join('{:02x} '.format(x) for x in msg.data[:msg.dlc]))

        if log_msg:
            if com_object:
                self.log.debug('Timestamp: {0}, ID: 0x{1:04x}, Type: {2}, Length: {3}, Data: {4}'.format(
                               msg.timestamp, msg.arbitration_id, com_object.type_str, msg.dlc, msg_data_str))
            else:
                # unknown message type
                self.log.debug('Timestamp: {0}, ID: 0x{1:04x}, Type: Unknown, Length: {2}, Data: {3}'.format(
                               msg.timestamp, msg.arbitration_id, msg.dlc, msg_data_str))
        return com_object

    def on_message_received(self, msg: can.Message):
        """
        This routine is a callback that is executed when a CAN message is received.  This method overrides the
        on_message_received routine in the can.Listener base class.

        :param msg:  CAN message that has been received
        :return: None
        """
        # queue the received message
        self.message_queue.put(msg)
        # if the log level is set to debug, parse the message to display details on the message that has
        # just been received
        if self.log.level == logging.DEBUG:
            self.message_parser(msg, True)


class CANopenTester:
    """
    This class contains a number of methods to communicate on a CANopen network, configure devices on the network,
    and run tests such as a PDO receive jitter test.
    """
    def __init__(self, can_type: str, channel: str, bit_rate: int, log_level=logging.INFO) -> None:
        """
        Class initializer.

        :param can_type: Type of CAN interface for the tester ('socketcan" or 'canalystii')
        :param channel: Channel of the interface (in case there are more than 1 channels on the interface)
        :param bit_rate: Bit rate to run the interface at (i.e. 1000000 for 1 Mbps)
        :param log_level: Logging level for the tester
        """

        # initialize the logging for the class
        self.logger = logging.getLogger('CANopenTester')
        self.logger.setLevel(log_level)
        # create console handler for the logger
        console_handler = logging.StreamHandler()
        console_handler.setLevel(log_level)
        # create formatter and add it to the handlers
        formatter = logging.Formatter('%(asctime)s: %(levelname)s: %(message)s', '%H:%M:%S')
        console_handler.setFormatter(formatter)
        # add the handlers to the logger
        self.logger.addHandler(console_handler)

        self.interface_type = can_type

        if can_type == 'canalystii':
            self.interface_channel = int(channel)
        else:
            self.interface_channel = channel
        self.interface_bit_rate = bit_rate
        self.network = canopen.Network()

        # create a CAN message listener and add it to the list of existing listeners
        self.can_listener = CANopenTesterListener(self.logger)
        self.network.listeners.append(self.can_listener)

        self.nodes = {}

    def add_node(self, test_node_id: int, test_eds_file: str) -> None:
        """
        This routine adds a CANopen node to the network that's being monitored/tested.

        :param test_node_id: CANopen node ID
        :param test_eds_file: Electronic data sheet for the node
        :return: None
        """
        node = canopen.RemoteNode(test_node_id, test_eds_file)
        self.nodes[test_node_id] = {'id': test_node_id, 'eds': test_eds_file, 'remoteNode': node}
        self.network.add_node(node)

        self.logger.info('Added CANopen node (ID:{0}, EDS File:{1})'.format(test_node_id, test_eds_file))

    def analyze_received_pdos(self, expected_time_difference: int) -> dict:
        """
        This routine pulls any received CANopen PDO from the receive queue for each node on the network and
        calculates the time difference in milliseconds between each received PDO.

        :param expected_time_difference: expected time difference between the received PDOs in milliseconds
        :return: Dictionary with the results of the analysis of the received PDOs.
        """
        received_pdos = {}
        pdo_results = {}

        # pull all of the received PDOs out of the queue
        while not self.can_listener.message_queue.empty():
            msg = self.can_listener.message_queue.get()
            com_object = self.can_listener.message_parser(msg, False)
            if com_object.object_type == CANopenComObjectTypes.pdo1_tx:
                if msg.arbitration_id in received_pdos:
                    received_pdos[msg.arbitration_id].append(msg.timestamp)
                else:
                    received_pdos[msg.arbitration_id] = [msg.timestamp]

        # for each node, step through all the received PDOs starting with the last received PDO and calculate the
        # time difference between the received values in milliseconds
        for pdo_index in sorted(received_pdos):
            num_pdos = len(received_pdos[pdo_index])
            pdo_val_diff_ms = []
            while num_pdos > 1:
                # calculate the difference between the two received PDOs in milliseconds
                val_diff_ms = self.calculate_received_pdo_timestamp_difference(received_pdos[pdo_index][num_pdos - 1],
                                                                               received_pdos[pdo_index][num_pdos - 2])
                pdo_val_diff_ms.append(val_diff_ms)
                num_pdos -= 1

            node_id = pdo_index & 0x00f
            num_received_pdos = len(pdo_val_diff_ms)
            average_pdo_difference = sum(pdo_val_diff_ms) / len(pdo_val_diff_ms)
            maximum_pdo_difference = max(pdo_val_diff_ms)
            minimum_pdo_difference = min(pdo_val_diff_ms)

            pdo_results[node_id] = {'numReceivedPdos': num_received_pdos,
                                    'averagePdoRxTimeDiff': average_pdo_difference,
                                    'expectedTimeDifference': expected_time_difference,
                                    'maximumPdoRxTimeDiff': maximum_pdo_difference,
                                    'minimumPdoRxTimeDiff': minimum_pdo_difference}

            self.logger.info(('Node {0}: num received PDOs: {1}, expected difference: {2:3.1f} mS, '
                              'average difference: {3:3.1f} mS, max difference: {4:3.1f} mS, '
                              'min difference: {5:3.1f} mS'.format(
                               node_id, num_received_pdos, expected_time_difference,
                               sum(pdo_val_diff_ms) / num_received_pdos,
                               maximum_pdo_difference, minimum_pdo_difference)))
        # return the results of the analysis
        return pdo_results

    @staticmethod
    def calculate_received_pdo_timestamp_difference(pdo_timestamp_1, pdo_timestamp_2) -> float:
        """
        This routine calculates the difference in milliseconds between two timestamps of
        received PDO messages.

        :param pdo_timestamp_1: first timestamp (depending on the OS, this may be an int or a float)
        :param pdo_timestamp_2: second timestamp (depending on the OS, this may be an int or a float)
        :return: Difference in milliseconds between pdo_timestamp_1 and pdo_timestamp_2.
        """
        if isinstance(pdo_timestamp_1, int) and isinstance(pdo_timestamp_2, int):
            # Windows timestamping - convert to milliseconds
            value_difference_milliseconds = (pdo_timestamp_1 - pdo_timestamp_2) / 10.0
        elif isinstance(pdo_timestamp_1, float) and isinstance(pdo_timestamp_2, float):
            # Linux timestamping - convert to milliseconds
            value_difference_milliseconds = (pdo_timestamp_1 - pdo_timestamp_2) * 1000.0
        else:
            # unknown timestamping - return 0.0 to indicate a problem
            value_difference_milliseconds = 0.0
        # return the time difference in milliseconds
        return value_difference_milliseconds

    def configure_node_transmit_pdo(self, node_id: int, pdo_index: int, transmit_value_name: str,
                                    event_time_ms: int, inhibit_time_ms: int) -> None:
        """
        This routine configures a node to transmit a PDO value at the specified rate.

        IMPORTANT: It is assumed that the node has been placed into pre-operational state before this routine
                   is called

        :param node_id: CANopen node ID
        :param pdo_index: index of the PDO to transmit
        :param transmit_value_name: name of the value to transmit (must match a value in the node's EDS)
        :param event_time_ms: rate in milliseconds at which to transmit the PDO
        :param inhibit_time_ms:
        :return: None
        """
        node = self.nodes[node_id]['remoteNode']

        # read the current TPDO mapping
        node.tpdo.read()

        # map the specified TPDO index to transmit the specified value (transmit_value_name) at the specified
        # rate (event_time_ms)
        node.tpdo[pdo_index].clear()
        node.tpdo[pdo_index].add_variable(transmit_value_name)
        node.tpdo[pdo_index].trans_type = 254
        node.tpdo[pdo_index].event_timer = event_time_ms
        # the inhibit time setting is in units of 100 uS so divide by 10
        node.tpdo[pdo_index].inhibit_time = inhibit_time_ms / 10
        node.tpdo[pdo_index].enabled = True

        # save the TPDO mapping
        node.tpdo.save()

        self.logger.info('Configured CANopen PDO transmission for node ID {0} '
                         '(value: {1}, rate: {2} mS, inhibit time: {3} mS)'.format(node_id, transmit_value_name,
                                                                                   event_time_ms, inhibit_time_ms))

    def disable_node(self, node_id: int) -> bool:
        """
        Disable a node by placing it into pre-operational state.

        :param node_id: ID of node to disable or 0 if all nodes on the bus should be disabled
        :return: True if the node(s) were successfully disabled, otherwise False
        """

        # set the node(s) to the pre-operational state
        if node_id == 0:
            # disable ALL nodes on the bus by placing them into pre-operational state
            self.network.send_message(0x0, [CANopenNMTFunctionCodes.preoperational.value, 0])
            self.logger.info('All nodes placed into pre-operational state')
            operation_result = True
        else:
            # an individual node is being placed into pre-operational state
            try:
                node = self.nodes[node_id]['remoteNode']
                node.nmt.state = 'PRE-OPERATIONAL'
                self.logger.info('Node ID {0} placed into pre-operational state'.format(node_id))
                operation_result = True
            except KeyError:
                self.logger.error('Node ID {0} does not exist!'.format(node_id))
                operation_result = False

        return operation_result

    def display_node_eds(self, node_id: int) -> None:
        """
        This routine displays the contents of the electronic data sheet for a node.

        :return: None
        """
        node = self.nodes[node_id]['remoteNode']
        self.logger.info('Displaying EDS file contents for node ID {0}'.format(node_id))

        for obj in node.object_dictionary.values():
            print('  0x%X: %s' % (obj.index, obj.name))
            if isinstance(obj, canopen.objectdictionary.Record):
                for sub_object in obj.values():
                    print('     %d: %s' % (sub_object.subindex, sub_object.name))

    def enable_node(self, node_id: int) -> None:
        """
        Enable a node by placing it into operational state.

        :param node_id: ID of node to enable or 0 if all nodes on the bus should be enabled
        :return: True if the node(s) were successfully enabled, otherwise False
        """
        # set the node(s) to the operational state
        if node_id == 0:
            # enable ALL nodes on the bus
            self.network.send_message(0x0, [CANopenNMTFunctionCodes.operational.value, 0])
            self.logger.info('All nodes placed into operational state')
        else:
            # an individual node is being placed into operational state
            try:
                node = self.nodes[node_id]['remoteNode']
                node.nmt.state = 'OPERATIONAL'
                self.logger.info('Node ID {0} placed into operational state'.format(node_id))
            except KeyError:
                self.logger.error('Node ID {0} does not exist!'.format(node_id))

    def network_disconnect(self) -> None:
        """
        This routine disconnects from the CAN interface and cleans up any used resources.
        """
        self.network.disconnect()

    def open_interface(self) -> bool:
        """
        This routine opens the CAN interface for use.

        :return: True if the interface was successfully opened, otherwise False
        """
        interface_open = False
        # try to open the interface
        try:
            self.network.connect(bustype=self.interface_type, channel=self.interface_channel,
                                 bitrate=self.interface_bit_rate, can_filters=None)

            self.logger.info('CAN interface opened successfully (type:{0}, channel:{1}, bit rate:{2})'.format(
                self.interface_type, self.interface_channel, self.interface_bit_rate))

            # indicate that the interface was opened successfully
            interface_open = True
        except ValueError:
            self.logger.error('Problem opening CAN interface (type:{0}, channel:{1}, bit rate:{2})'.format(
                self.interface_type, self.interface_channel, self.interface_bit_rate))
        return interface_open

    def receive_pdos(self, receive_time_seconds: int) -> None:
        """
        This routine will pend for the specified time receiving PDOs from the configured devices on the network.

        :param receive_time_seconds:  time in seconds to wait and receive PDOs for the nodes on the network
        :return: None
        """
        self.logger.info('Receiving PDOs for {0} seconds ...'.format(receive_time_seconds))
        time.sleep(receive_time_seconds)

    def run_sdo_read_test(self, starting_node_id: int, num_nodes: int,
                          receive_time_seconds: int, pdo_transmit_time: int,
                          pdo_transmit_inhibit: int):

        self.logger.info('Running CANopen SDO read test ...')
        self.logger.info('Starting node ID: {0}, Num nodes: {1}, test time: {2}'

                         ' seconds, ''PDO transmit time: {3} mS, PDO transmit '
                         'inhibit time: {4} mS'.format(starting_node_id,
                                                       num_nodes,
                                                       receive_time_seconds,
                                                       pdo_transmit_time,
                                                       pdo_transmit_inhibit))
        # add the CANopen nodes
        for node_index in range(0, num_nodes):
            can_id = starting_node_id + node_index
            can_test.add_node(can_id, args.eds_file)

        # make sure all the nodes are in pre-operational state before continuing
        can_test.disable_node(0)

        # wait a short period of time before continuing
        time.sleep(1)

        # configure all the nodes to transmit PDOs
        for node_index in range(0, num_nodes):
            can_id = starting_node_id + node_index
            try:
                # enable PDO transmission of the 'Button press counter'
                # value specified in the node(s) EDS
                can_test.configure_node_transmit_pdo(can_id, 1,
                                                     'Button press counter',
                                                     pdo_transmit_time,
                                                     pdo_transmit_inhibit)

            except canopen.sdo.exceptions.SdoCommunicationError:
                self.logger.error('Node {0} could not be configured for PDO '
                                  'transmission (no SDO response'
                                  'received)'.format(can_id))

        # Grab the Button press counter from *starting* node so we can read it
        # repeatedly. We only stress this node, the other ones just transmit
        # periodically
        node = self.nodes[starting_node_id]['remoteNode']
        counter = node.sdo['Button press counter']

        sdo_read_count = 0
        min_time = 0xffffffff
        max_time = 0
        accum = 0

        # place all the nodes back into the operational state
        can_test.enable_node(0)

        # wait a short period of time before continuing
        time.sleep(1)

        begin = time.monotonic()
        # Threading.Timer would be better, but adding deps to Yocto image
        # is not worth the hassle
        while (time.monotonic() - begin) < receive_time_seconds:
            read_start = time.monotonic()
            dummy_var = counter.raw     # force the read with an assignment
            elapsed = time.monotonic() - read_start
            accum += elapsed
            sdo_read_count += 1
            if elapsed >= max_time:
                max_time = elapsed
            if elapsed < min_time:
                min_time = elapsed
            # The node cannot handle CANopen events any faster than this, as
            # per the zephyr implementation.
            time.sleep(0.001)

        avg = accum/sdo_read_count

        self.logger.info('min time was {0} ms'.format(min_time * 1000))
        self.logger.info('max time was {0} ms'.format(max_time * 1000))
        self.logger.info('Average time was {0} ms'.format(avg * 1000))

        # Disable twice for good measure (according to JPS)
        can_test.disable_node(0)
        can_test.disable_node(0)

    def run_pdo_roundtrip_test(self, starting_node_id: int, num_nodes: int,
                               receive_time_seconds: int,
                               pdo_transmit_time: int,
                               pdo_transmit_inhibit: int):

        self.logger.info('Running CANopen PDO roundtrip test ...')
        # num_nodes = 1

        self.logger.info('Starting node ID: {0}, Num nodes: {1}, test time: {2}'
                         ' seconds, ''PDO transmit time: {3} mS, PDO transmit '
                         'inhibit time: {4} mS'.format(starting_node_id, num_nodes,
                                                       receive_time_seconds,
                                                       pdo_transmit_time,
                                                       pdo_transmit_inhibit))

        # add the CANopen nodes
        for node_index in range(0, num_nodes):
            can_id = starting_node_id + node_index
            can_test.add_node(can_id, args.eds_file)

        node = self.nodes[starting_node_id]['remoteNode']

        can_test.disable_node(0)
        time.sleep(1)

        # Grab the CalcRoundTrip upfront so we can write it out repeatedly
        counter = node.sdo['CalcRoundTrip']

        # configure all the nodes to transmit PDOs
        for node_index in range(0, num_nodes):
            can_id = starting_node_id + node_index

            try:
                # enable PDO transmission of the 'UpTime' value specified in the
                # node EDS
                can_test.configure_node_transmit_pdo(can_id, 1, 'UpTime',
                                                     pdo_transmit_time,
                                                     pdo_transmit_inhibit)

            except canopen.sdo.exceptions.SdoCommunicationError:
                self.logger.error('Node {0} could not be configured for PDO '
                                  'transmission (no SDO response received)'.
                                  format(starting_node_id))

        # enable everyone
        can_test.enable_node(0)

        # After configuring the node(s) to send out PDOs with uptimes,
        # wait for the PDOs and echo the values back to the node using the
        # CalcRoundTrip object, so that the node can calculate the time elapsed
        # since it sent the PDO
        # TODO do this with an async listener
        begin = time.monotonic()
        pdo_count = 0
        while (time.monotonic() - begin) < receive_time_seconds:
            node.tpdo[1].wait_for_reception()

            # TODO double check that this idiom for writing the SDO is correct
            counter.raw = node.tpdo['UpTime'].phys
            pdo_count += 1

        # send a zero so that the node knows no more SDO writes to the
        # CalcRoundTrip object are coming, and it should perform its
        # calculations and reset.
        counter.raw = 0
        self.logger.info('Finished receiving and replying to {0} PDOs from node'
                         ' ID: {1}'.format(pdo_count, starting_node_id))

        # Disable twice for good measure (according to JPS)
        can_test.disable_node(0)
        can_test.disable_node(0)

    def run_pdo_jitter_test(self, starting_node_id: int, num_nodes: int, receive_time_seconds: int,
                            pdo_transmit_time: int, pdo_transmit_inhibit: int) -> dict:
        """
        This routine runs a jitter test on a CANopen network, configuring the specified nodes to transmit PDOs at the
        specified rate, receiving the PDOs, and calculating the time difference between each PDO for each node.

        :param starting_node_id: node ID of the first device on the network to receive PDOs from
        :param num_nodes: number of nodes on the network to receive PDOs from (must be consecutive node IDs
        :param receive_time_seconds: total time in seconds to receive PDOs
        :param pdo_transmit_time: rate (in milliseconds) at which the devices will transmit their PDOs
        :param pdo_transmit_inhibit: time (in milliseconds) that the devices on the network will hold off before
                                     sending their next PDO
        :return: Dictionary with results of the PDO jitter test
        """
        self.logger.info('Running CANopen PDO jitter test ...')
        self.logger.info('Starting node ID: {0}, Num nodes: {1}, test time: {2} seconds, '
                         'PDO transmit time: {3} mS, PDO transmit inhibit time: {4} mS'.format(
                          starting_node_id, num_nodes, receive_time_seconds, pdo_transmit_time, pdo_transmit_inhibit))

        # add the CANopen nodes
        for node_index in range(0, num_nodes):
            can_id = starting_node_id + node_index
            can_test.add_node(can_id, args.eds_file)

        # make sure all the nodes are in pre-operational state before continuing
        can_test.disable_node(0)

        # wait a short period of time before continuing
        time.sleep(1)

        # configure all the nodes to transmit PDO's
        for node_index in range(0, num_nodes):
            can_id = starting_node_id + node_index
            try:
                # enable PDO transmission of the 'Button press counter' value specified in the node(s) EDS
                can_test.configure_node_transmit_pdo(can_id, 1, 'Button press counter',
                                                     pdo_transmit_time, pdo_transmit_inhibit)
            except canopen.sdo.exceptions.SdoCommunicationError:
                self.logger.error('Node {0} could not be configured for PDO '
                                  'transmission (no SDO response received)'.format(can_id))

        # wait a short period of time before continuing
        time.sleep(1)

        # place all the nodes back into the operational state
        can_test.enable_node(0)

        # accumulate PDOS for the specified time
        can_test.receive_pdos(receive_time_seconds)

        # make sure all the nodes are placed back into pre-operational state before exiting
        can_test.disable_node(0)

        # TODO: JPS - 12/1/20 - this shouldn't be necessary but it seems that occasionally the first message
        # to disable the nodes doesn't reach all the nodes (especially if they are transmitting their PDOs at
        # a fast rate) so send it a second time - the underlying cause of this should be determined and properly
        # fixed!
        can_test.disable_node(0)

        # analyze the received PDOs
        pdo_results = can_test.analyze_received_pdos(pdo_transmit_time)
        return pdo_results


if __name__ == '__main__':
    """
    Main entry point for script.

    Optional parameters:
        --interface=                CAN interface to use for the test (i.e. 'socketcan", 'canalystii')
        --bitrate=                  interface bit rate
        --channel=                  channel to use on the CAN interface (i.e. "0", "1", "can0")
        --display-eds               if included, display the contents of the node's EDS file
        --eds-file=                 Electronic data sheet for the node(s).
        --jitter-test               if included, run the jitter test
        --jitter-test-time=         time to run jitter test
        --pdo-rt-test               if included, run the PDO roundtrip test.
        --pdo-rt-test-time=         time to run PDO roundtrip test
        --sdo-read-test             if included, run the SDO read test.
        --sdo-read-test-time=       time in seconds to run the SDO read test
        --node-id-start=            starting CANopen node ID for the group of devices being communicated with
        --num-nodes=                number of CANopen nodes in the group of devices being communicated with
        --pdo-transmit-rate         PDO transmit rate of the device in milliseconds
        --pdo-transmit-inhibit      PDO transmit inhibit time of the device in milliseconds

    """
    # construct an argument parser
    p = argparse.ArgumentParser(formatter_class=argparse.ArgumentDefaultsHelpFormatter)
    p.add_argument('--interface', dest='interface', nargs='?', type=str, default='socketcan',
                   help="USB to CAN interface (i.e. socketcan, canalystii).")
    p.add_argument('--channel', dest='channel', nargs='?', type=str, default='can0',
                   help="interface channel (i.e. 0, 1, 'can0'")
    p.add_argument('--bitrate', dest='bit_rate', nargs='?', type=int, default=1000000,
                   help="interface bit rate")
    p.add_argument('--display-eds', dest='display_eds', action='store_true',
                   help="include to parse and display electronic data sheet for nodes")
    p.set_defaults(display_eds=False)
    p.add_argument('--eds-file', dest='eds_file', nargs='?', type=str, default='objdict.eds',
                   help="electronic data sheet for the node")
    p.add_argument('--jitter-test', dest='jitter_test', action='store_true',
                   help="include to run the jitter test")
    p.set_defaults(jitter_test=True)
    p.add_argument('--jitter-test-time', dest='jitter_test_time', nargs='?', type=int, default=10,
                   help="time in seconds to run the jitter test")
    p.add_argument('--node-id-start', dest='node_id_start', nargs='?', type=int, default=10,
                   help="starting CANopen node ID of group of devices being communicated with")
    p.add_argument('--num-nodes', dest='num_nodes', nargs='?', type=int, default=1,
                   help="number of CANopen nodes being communicated with")
    p.add_argument('--pdo-transmit-rate', dest='pdo_transmit_rate', nargs='?', type=int, default=10,
                   help="PDO transmit time in milliseconds")
    p.add_argument('--pdo-transmit-inhibit', dest='pdo_transmit_inhibit', nargs='?', type=int, default=0,
                   help="PDO transmit inhibit time in milliseconds")
    p.add_argument('--pdo-rt-test', dest='pdo_rt_test', action='store_true',
                   help="include to run the PDO round trip test")
    p.add_argument('--pdo-rt-test-time', dest='pdo_rt_test_time', nargs='?', type=int, default=10,
                   help="time in seconds to run the PDO round trip test")
    p.add_argument('--sdo-read-test', dest='sdo_read_test', action='store_true',
                   help="include to run the continuous SDO read test")
    p.add_argument('--sdo-read-test-time', dest='sdo_read_test_time', nargs='?', type=int, default=10,
                   help="time in seconds to run the SDO read test")

    try:
        # parse the arguments passed to the script
        args = p.parse_args()
    except IOError as e:
        p.error(str(e))
    except Exception as e:
        # don't use a __log statement here as the logging is created with a (successful) instantiation of
        # a PocDevice which sets up the Twisted logging
        print('Unexpected error: {0}'.format(e))
        raise
    else:
        # attempt to open the specified interface
        can_test = CANopenTester(args.interface, args.channel, args.bit_rate)

        can_test.open_interface()

        # if enabled, display the contents of the EDS file
        if args.display_eds:
            can_test.display_node_eds(args.node_id)

        if args.pdo_rt_test:
            # run the PDO roundtrip test
            can_test.run_pdo_roundtrip_test(args.node_id_start, args.num_nodes,
                                            args.pdo_rt_test_time,
                                            args.pdo_transmit_rate,
                                            args.pdo_transmit_inhibit)
        elif args.sdo_read_test:
            # run the SDO read test
            can_test.run_sdo_read_test(args.node_id_start, args.num_nodes,
                                       args.sdo_read_test_time,
                                       args.pdo_transmit_rate,
                                       args.pdo_transmit_inhibit)
        else:
            # run the PDO jitter test
            can_test.run_pdo_jitter_test(args.node_id_start, args.num_nodes,
                                         args.jitter_test_time,
                                         args.pdo_transmit_rate,
                                         args.pdo_transmit_inhibit)

        # disconnect from the interface
        can_test.network_disconnect()
