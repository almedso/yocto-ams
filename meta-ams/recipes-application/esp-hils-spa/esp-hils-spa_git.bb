require esp-hils-spa.inc

PV = "0.1+git${SRCPV}"
PKGV = "0.1+git${GITPKGV}"
PR = "${INC_PR}.1"

ESP_HILS_SPA_BRANCH ?= "master"
SRC_URI = "git://gitlab.com/almedso/esp-hils-spa.git;protocol=http;branch=${ESP_HILS_SPA_BRANCH}"

SRCREV = "${AUTOREV}"
S = "${WORKDIR}/git"