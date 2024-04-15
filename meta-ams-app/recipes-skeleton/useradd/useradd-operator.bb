SUMMARY = "Add operator user"
DESCRIPTION = "This recipe adds the operator user intended for support and maintenance"
SECTION = "ams"
PR = "r9"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://${COREBASE}/meta/COPYING.MIT;md5=3da9cfbcb788c80a0384361b4de20420"

S = "${WORKDIR}"

# Operator user for service and maintenance
USER = "operator"
BASE_DIR = "home"

inherit useradd

USERADD_PACKAGES = "${PN}"
GROUPADD_PARAM:${PN} = "${USER} sudo"
# password optained from calling: openssl passwd ${USER}
# so password is operator
USERADD_PARAM:${PN} = " \
    --create-home \
    --gid ${USER} \
    --groups sudo \
    --shell /bin/bash \
    --password '.G0vnmsRB9DJY' \
    ${USER} \
    "
# GROUPMEMS_PARAM:${PN} = "${PN}"
# GROUPADD_PARAM = "${USER} sudo"

ALLOW_EMPTY:${PN} = "1"
INHIBIT_PACKAGE_DEBUG_SPLIT = "1"

