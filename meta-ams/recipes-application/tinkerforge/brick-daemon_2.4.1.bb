require brick-daemon.inc

PR = "${INC_PR}.4"

SRC_URI = " \
   git://github.com/Tinkerforge/brickd;protocol=http;tag=v${PV};name=brickd;nobranch=1 \
   git://github.com/Tinkerforge/daemonlib;protocol=http;tag=brickd-${PV};destsuffix=git/src/daemonlib;name=daemonlib;nobranch=1 \
"
SRCREV_FORMAT = "brickd_daemonlib"

S = "${WORKDIR}/git/src/brickd"