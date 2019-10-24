require brick-daemon.inc

PR = "${INC_PR}.1"

SRC_URI = " \
   git://github.com/Tinkerforge/brickd;protocol=http;branch=master;name=brickd \
   git://github.com/Tinkerforge/daemonlib;protocol=http;branch=master;destsuffix=git/src/daemonlib;name=daemonlib \
"
SRCREV_FORMAT = "brickd_daemonlib"

SRCREV_brickd = "${AUTOREV}"
SRCREV_daemonlib = "${AUTOREV}"
S = "${WORKDIR}/git/src/brickd"