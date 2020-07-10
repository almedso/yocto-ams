PV = "0.1.0"
# PV = "0.1+git${SRCPV}"
PKGV = "0.1.0+git${GITPKGV}"
PR = "${INC_PR}.1"

inherit gitpkgv

SRC_URI = "git://github.com/almedso/rpi-hwctl.git;branch=master"
# SRC_URI = "git://github.com/almedso/yocto-qt5-simple.git;branch=master"

SRCREV = "${AUTOREV}"

S = "${WORKDIR}/git"

include rpi-hwctl.inc
