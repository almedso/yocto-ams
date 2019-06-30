SUMMARY = "Add ams application user"
DESCRIPTION = "This recipe adds the ams user"
SECTION = "roche"
PR = "r3"
LICENSE = "CLOSED"

SRC_URI = ""
S = "${WORKDIR}"

EXCLUDE_FROM_WORLD = "1"

inherit useradd

USERADD_PACKAGES = "${PN}"

USERADD_PARAM_${PN} = " \
    --system \
    --no-create-home \
    --shell /bin/false \
    --user-group \
    ams \
    "

INHIBIT_PACKAGE_DEBUG_SPLIT = "1"
ALLOW_EMPTY_${PN} = "1"
