SUMMARY = "AMS Image Basics"
DESCRIPTION = "AMS Image Basics"
LICENSE = "MIT"
PR_INC = "r1"

inherit core-image
require rootfs-post-install.inc

KERNEL_DEVICETREE += " \
    ${@bb.utils.contains('MACHINE_FEATURES', 'ads7846-touch', 'overlays/ads7846.dtbo', '', d)} \
"


IMAGE_INSTALL_append = " \
    packagegroup-base-ams \
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
