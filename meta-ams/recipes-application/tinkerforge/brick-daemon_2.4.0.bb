require brick-daemon.inc

PR = "${INC_PR}.3"

SRC_URI = " \
   git://github.com/Tinkerforge/brickd;protocol=http;tag=v${PV};name=brickd \
   git://github.com/Tinkerforge/daemonlib;protocol=http;branch=master;destsuffix=git/src/daemonlib;name=daemonlib \
"
SRCREV_FORMAT = "brickd_daemonlib"

SRCREV = "d3d74820ab00a6cf516af62ecd38b6075d975556"
SRCREV_daemonlib = "d3d74820ab00a6cf516af62ecd38b6075d975556"
S = "${WORKDIR}/git/src/brickd"