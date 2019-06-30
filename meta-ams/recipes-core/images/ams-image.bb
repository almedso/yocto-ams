SUMMARY = "AMS product-grade image"
DESCRIPTION = "A-l M-ed S-o product-grade image"
LICENSE = "MIT"

require include/ams-image.inc

PR = "1.0.${PR_INC}"

# overwrite image name - to find it in tmp* tree
export IMAGE_BASENAME = "ams-image"

IMAGE_FEATURES_append = " \
"
IMAGE_INSTALL_append = " \
    "