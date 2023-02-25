DESCRIPTION = "Patches of media and video for bootloader for RIoTboard"

FILESEXTRAPATHS_prepend := "${THISDIR}:"

SRC_URI_append = ";branch=${SRCBRANCH} \
           file://0001-Modify-default-for-video-device-to-LCD.patch \
           file://0002-Set-device-tree-file-name.patch \
           "
COMPATIBLE_MACHINE = "(rigoletto)"
# UBOOT_SYMLINK = "${SPL_BINARY}-${MACHINE}.${UBOOT_SUFFIX}"

