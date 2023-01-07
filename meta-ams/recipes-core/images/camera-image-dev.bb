SUMMARY = "AMS development image"
DESCRIPTION = "A-l M-ed S-o development image"
LICENSE = "MIT"

require include/ams-image-dev.inc

PR = "1.0.${PR_INC}"

# overwrite image name - to find it in tmp* tree
export IMAGE_BASENAME = "camera-image-dev"

IMAGE_INSTALL:append = " \
    packagegroup-ams-tools \
    packagegroup-imaging \
    jupyter \
    "


# will not be installed
OTHER_PACKAGES_IMAGE_INSTALL:append = " \
    "
