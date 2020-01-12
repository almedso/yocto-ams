require brick-daemon.inc

PR = "${INC_PR}.4"

SRC_URI = " \
   git://github.com/Tinkerforge/brickd;protocol=http;tag=v${PV};name=brickd;nobranch=1 \
   git://github.com/Tinkerforge/daemonlib;protocol=http;tag=brickd-${PV};destsuffix=git/src/daemonlib;name=daemonlib;nobranch=1 \
"
SRCREV_FORMAT = "brickd_daemonlib"
# SRCREV_brickd = "d3d74820ab00a6cf516af62ecd38b6075d975556"
# SRCREV_daemonlib = "24ae39e828a98925a595256c28aedc4fe7f32c65"

S = "${WORKDIR}/git/src/brickd"