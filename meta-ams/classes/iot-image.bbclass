# Common code for generating iot reference images
#
# Copyright (C) 2015-2018 Volker Kempert
# Copyright (C) 2015 Stephan Linz

LIC_FILES_CHKSUM = "file://${COREBASE}/LICENSE;md5=4d92cd373abda3937c2bc47fbc49d690"

# IMAGE_FEATURES control content of the iot reference images
#
# By default we install packagegroup-base-iot packages - this gives us a
# working (console only) iot rootfs.
#

# IMAGE_FEATURES_REPLACES_foo = 'bar1 bar2'
# Including image feature foo would replace the image features bar1 and bar2

# IMAGE_FEATURES_CONFLICTS_foo = 'bar1 bar2'
# An error exception would be raised if both image features foo and bar1(or bar2) are included

IOT_IMAGE_BASE_INSTALL = '\
    packagegroup-base-iot \
    \
    ${@bb.utils.contains("IMAGE_FEATURES", "tools-debug", "packagegroup-iot-tools-debug", "",d)} \
    ${@bb.utils.contains("IMAGE_FEATURES", "tools-profile", "packagegroup-iot-tools-profile", "",d)} \
    ${@bb.utils.contains("IMAGE_FEATURES", "tools-testapps", "packagegroup-iot-tools-testapps", "",d)} \
    ${@bb.utils.contains("IMAGE_FEATURES", "tools-sdk", "packagegroup-iot-sdk", "",d)} \
    \
    ${IOT_IMAGE_EXTRA_INSTALL} \
    '

IOT_IMAGE_EXTRA_INSTALL ?= ""

CORE_IMAGE_EXTRA_INSTALL += "${IOT_IMAGE_BASE_INSTALL}"

inherit core-image
#
# prepare the image for versioning
#
IOT_VERSION_FILE = "${IMAGE_ROOTFS}${sysconfdir}/iot_version"

write_iot_version() {
        cat > ${IOT_VERSION_FILE} <<EOF
[build information]
vendor-id: VENDOR.ID
manufacturer-name: Full name
device-variant: ${MACHINE}
purpose: ${IMAGE_BASENAME}
feature: ${IMAGE_FEATURES}
build-number: ${BUILD_NUMBER}
EOF
}

ROOTFS_POSTPROCESS_COMMAND += "write_iot_version ; "


#
# prepare the image for Python Indexing Project
#
IOT_PIP_CONF = "${IMAGE_ROOTFS}${ROOT_HOME}/.pip/pip.conf"

write_iot_pip_conf() {
    mkdir -p $(dirname '${IOT_PIP_CONF}')
    cat > ${IOT_PIP_CONF} << EOF
[global]
pre = true
default-timeout = 60
respect-virtualenv = true
download-cache = ~/.pip/cache/
log-file = ~/.pip/pip.log
index-url = http://pypi.almedso.de/simple/
extra-index-url = http://pypi.python.org/simple/
EOF
}

ROOTFS_POSTPROCESS_COMMAND += "write_iot_pip_conf ; "

