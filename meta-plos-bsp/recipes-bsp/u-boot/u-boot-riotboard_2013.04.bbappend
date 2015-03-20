DESCRIPTION = "Patches of media and video for bootloader for RIoTboard"

FILESEXTRAPATHS_prepend := "${THISDIR}:"

SRC_URI_append = ";branch=${SRCBRANCH} \
           file://0001-Modify-default-for-video-device-to-LCD.patch \
           file://0002-Change-default-rootfs-device-to-mmcblk1p2-uSD-slot.patch \
           "
