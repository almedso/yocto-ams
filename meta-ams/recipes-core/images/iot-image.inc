SUMMARY = "AMS Image Basics"
DESCRIPTION = "AMS Image Basics"
LICENSE = "MIT"
PR_INC = "r1"

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

# this should ideally go to machine definition
# so qemu does not really require an sd card image
IMAGE_FSTYPES += "wic"
WKS_FILE ?= "sdimage-bootpart.wks"