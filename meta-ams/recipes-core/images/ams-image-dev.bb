SUMMARY = "AMS development image"
DESCRIPTION = "A-l M-ed S-o development image"
LICENSE = "MIT"

require include/ams-image-dev.inc

PR = "1.2.${PR_INC}"

# overwrite image name - to find it in tmp* tree
export IMAGE_BASENAME = "ams-image-dev"

IMAGE_INSTALL_append = " \
    packagegroup-ams-tools \
    packagegroup-explore700 \
    "


OTHER_PACKAGES_IMAGE_INSTALL_append = " \
    rpi-hwctl \
    winterling \
    "