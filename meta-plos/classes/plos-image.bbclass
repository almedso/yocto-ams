# Common code for generating plos reference images
#
# Copyright (C) 2015 Volker Kempert
# Copyright (C) 2015 Stephan Linz

LIC_FILES_CHKSUM = "file://${COREBASE}/LICENSE;md5=ec3a9a9bfa0a9cb7512518a7c2db7d1d"

# IMAGE_FEATURES control content of the plos reference images
#
# By default we install packagegroup-base-plos packages - this gives us a
# working (console only) plos rootfs.
#

# IMAGE_FEATURES_REPLACES_foo = 'bar1 bar2'
# Including image feature foo would replace the image features bar1 and bar2

# IMAGE_FEATURES_CONFLICTS_foo = 'bar1 bar2'
# An error exception would be raised if both image features foo and bar1(or bar2) are included

PLOS_IMAGE_BASE_INSTALL = '\
    packagegroup-base-plos \
    \
    ${@base_contains("IMAGE_FEATURES", "tools-debug", "packagegroup-plos-tools-debug", "",d)} \
    ${@base_contains("IMAGE_FEATURES", "tools-profile", "packagegroup-plos-tools-profile", "",d)} \
    ${@base_contains("IMAGE_FEATURES", "tools-testapps", "packagegroup-plos-tools-testapps", "",d)} \
    ${@base_contains("IMAGE_FEATURES", "tools-sdk", "packagegroup-plos-sdk", "",d)} \
    \
    ${PLOS_IMAGE_EXTRA_INSTALL} \
    '

PLOS_IMAGE_EXTRA_INSTALL ?= ""

CORE_IMAGE_EXTRA_INSTALL += "${PLOS_IMAGE_BASE_INSTALL}"

inherit core-image
#
# prepare the image for alinos versioning
#
PLOS_VERSION_FILE = "${IMAGE_ROOTFS}${sysconfdir}/plos_version"

write_plos_version() {
        cat > ${PLOS_VERSION_FILE} <<EOF
[build information]
vendor-id: VENDOR.ID
manufacturer-name: Full name
device-variant: ${MACHINE}
purpose: ${IMAGE_BASENAME}
feature: ${IMAGE_FEATURES}
build-number: ${BUILD_NUMBER}
EOF
}

ROOTFS_POSTPROCESS_COMMAND += "write_plos_version ; "


#
# prepare the image for Python Indexing Project
#
PLOS_PIP_CONF = "${IMAGE_ROOTFS}${ROOT_HOME}/.pip/pip.conf"

write_plos_pip_conf() {
    mkdir -p $(dirname '${PLOS_PIP_CONF}')
    cat > ${PLOS_PIP_CONF} << EOF
[global]
pre = true
default-timeout = 60
respect-virtualenv = true
download-cache = ~/.pip/cache/
log-file = ~/.pip/pip.log
index-url = http://pypi.pixmeter.com/simple/
extra-index-url = http://pypi.python.org/simple/
EOF
}

ROOTFS_POSTPROCESS_COMMAND += "write_plos_pip_conf ; "

