require power-logger.inc
inherit gitpkgv

PV = "0.1+git${SRCPV}"
PKGV = "0.1+git${GITPKGV}"
PR = "${INC_PR}.1"

SRC_URI = "git://github.com/volker-kempert/power-logger.git;protocol=http;branch=master"

SRCREV = "${AUTOREV}"
S = "${WORKDIR}/git"