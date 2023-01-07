LICENSE = "MIT"
PR_INC = "r1"

inherit core-image
require rootfs-post-install.inc

KERNEL_DEVICETREE += " \
    ${@bb.utils.contains('MACHINE_FEATURES', 'ads7846-touch', 'overlays/ads7846.dtbo', '', d)} \
"


IMAGE_INSTALL:append = " \
    packagegroup-base-ams \
    "

IMAGE_INSTALL:remove = " \
    netkit-telnet \
    "

IMAGE_FEATURES:append= " \
    package-management \
    ssh-server-openssh \
    "

IMAGE_FEATURES:remove = " \
    splash \
    "
