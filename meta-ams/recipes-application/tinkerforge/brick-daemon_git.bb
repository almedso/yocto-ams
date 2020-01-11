require brick-daemon.inc

# PV = "0.1+git${SRCPV}"
PV = "0.1"
PKGV = "0.1+git${GITPKGV}"
PR = "${INC_PR}.1"


SRC_URI = " \
   git://github.com/Tinkerforge/brickd;protocol=http;branch=master;name=brickd \
   git://github.com/Tinkerforge/daemonlib;protocol=http;branch=master;destsuffix=git/src/daemonlib;name=daemonlib \
"

SRCREV_FORMAT = "brickd_daemonlib"

SRCREV = "${AUTOREV}"
SRCREV_daemonlib = "${AUTOREV}"
S = "${WORKDIR}/git/brickd"