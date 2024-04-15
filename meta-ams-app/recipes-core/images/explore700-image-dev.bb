SUMMARY = "RPI + JOYIT Explore700 shield - development variant"
LICENSE = "MIT"

require include/ams-image-dev.inc

PR = "1"

# overwrite image name - to find it in tmp* tree
export IMAGE_BASENAME = "explore700-image-dev"

IMAGE_INSTALL:append = " \
    packagegroup-ams-tools \
    packagegroup-explore700 \
    "


# will not be installed
OTHER_PACKAGES_IMAGE_INSTALL:append = " \
    winterling \
    jupyter \
    "
