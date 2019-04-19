SUMMARY = "AMS Image Basics"
DESCRIPTION = "AMS Image Basics"
LICENSE = "MIT"
PR_INC = "r1"

inherit core-image

export IMAGE_BASE_NAME = "iot-image"

IMAGE_INSTALL_append = " \
    packagegroup-iot-base \
    connman \
    "

IMAGE_INSTALL_remove = " \
    netkit-telnet \
    "

IMAGE_FEATURES_append= " \
    package-management \
    ssh-server-openssh \
    "

IMAGE_FEATURES_remove = " \
    splash \
    "
