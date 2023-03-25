SUMMMARY = "AMS Base System"
LICENSE = "MIT"
PR = "r3"

inherit packagegroup

OPERATOR_FEATURE = "\
    openssh \
    useradd-operator \
    sudo \
"

NETWORK_FEATURE = "\
    bridge-utils \
    dhcpcd \
    hostapd \
    init-ifupdown \
    iptables \
    wpa-supplicant \
"

RDEPENDS:${PN} = " \
    ${OPERATOR_FEATURE} \
    ${NETWORK_FEATURE} \
    bash \
    formfactor \
    i2c-tools \
    python3-smbus \
    timestamp-service \
"

