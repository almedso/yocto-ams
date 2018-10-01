require emba.inc

PV = "0.1+git${SRCPV}"
PKGV = "0.1+git${GITPKGV}"
PR = "${INC_PR}.1"

SRC_URI = "git://github.com/pixmeter/emba.git;protocol=http;branch=devel"
SRCREV = "${AUTOREV}"
S = "${WORKDIR}/git"

