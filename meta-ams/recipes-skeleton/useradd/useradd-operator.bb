SUMMARY = "Add operator user"
DESCRIPTION = "This recipe adds the operator user intended for support and maintenance"
SECTION = "ams"
PR = "r7"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://${COREBASE}/meta/COPYING.MIT;md5=3da9cfbcb788c80a0384361b4de20420"

S = "${WORKDIR}"

# Operator user for service and maintenance
USER = "operator"
BASE_DIR = "home"

inherit useradd

USERADD_PACKAGES = "${PN}"
GROUPADD_PARAM_${PN} = "${USER}"
# password optained from calling: openssl passwd ${USER}
# so password is operator
USERADD_PARAM_${PN} = " \
    --create-home \
    --gid ${USER} \
    --shell /bin/bash \
    --password '.G0vnmsRB9DJY' \
    ${USER} \
    "

ALLOW_EMPTY_${PN} = "1"
INHIBIT_PACKAGE_DEBUG_SPLIT = "1"

