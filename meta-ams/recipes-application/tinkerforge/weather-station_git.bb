PV = "0.1+git${SRCPV}"
PKGV = "0.1+git${GITPKGV}"
PR = "${INC_PR}.1"

SRC_URI += "git://git@gitlab.com/volker-kempert/tinkerforge-weatherstation;protocol=ssh;branch=master"

SRCREV = "${AUTOREV}"
S = "${WORKDIR}/git"

include weather-station.inc
