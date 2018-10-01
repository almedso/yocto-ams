DESCRIPTION = "A small image just capable of allowing an device to \
boot and is suitable for development work. (on kernel and uboot)"

IMAGE_LINGUAS = " "

LICENSE = "MIT"

inherit plos-image

IMAGE_ROOTFS_SIZE ?= "8192"

IMAGE_FEATURES += "dev-pkgs"

