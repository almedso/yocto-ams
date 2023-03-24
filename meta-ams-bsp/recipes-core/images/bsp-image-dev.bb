SUMMARY = "BSP development image"
DESCRIPTION = "Image that contains tooling to establish a new BSP"
LICENSE = "MIT"

inherit core-image

IMAGE_ROOTFS_SIZE ?= "2048"

IMAGE_INSTALL = " \
    packagegroup-base \
    packagegroup-core-boot \
    packagegroup-hwtools \
    packagegroup-benchmark \
    packagegroup-userland \
    packagegroup-rt \
    ${@bb.utils.contains("COMBINED_FEATURES", "alsa", "packagegroup-audio", "", d)} \
    ${@bb.utils.contains("COMBINED_FEATURES", "wifi", "packagegroup-wifi", "", d)} \
    ${@bb.utils.contains("COMBINED_FEATURES", "bluetooth", "packagegroup-bluetooth", "", d)} \
    ${@bb.utils.contains("COMBINED_FEATURES", "3g", "packagegroup-3g", "", d)} \
    tzdata \
"

IMAGE_INSTALL:append:mx8m = " firmwared"

IMAGE_FEATURES:append = " \
    debug-tweaks \
    tools-debug \
    tools-profile \
"
