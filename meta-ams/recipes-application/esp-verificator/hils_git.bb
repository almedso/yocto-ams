require hils.inc

PV = "0.1+git${SRCPV}"
PKGV = "0.1+git${GITPKGV}"
PR = "${INC_PR}.1"


SRC_URI = "git://gitlab.com/almedso/esp-verificator.git;protocol=http;branch=master"
SRC_URI[sha256sum] = "9cdeded70a6b2f1c09e14c904e7cb4d9ea83a8c2f89099f657eed003e64cb9c9"

SRCREV = "${AUTOREV}"
S = "${WORKDIR}/git"