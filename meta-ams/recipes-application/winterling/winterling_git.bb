# PV = "0.1.0"
PV = "0.1+git${SRCPV}"
PKGV = "0.1.0+git${GITPKGV}"
PR = "${INC_PR}.1"

inherit gitpkgv

SRC_URI = "git://gitlab.com/almedso/winterling.git;protocol=http;branch=master"


SRCREV = "${AUTOREV}"

S = "${WORKDIR}/git"

include winterling.inc
