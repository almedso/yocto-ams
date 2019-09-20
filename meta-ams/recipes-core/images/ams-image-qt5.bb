SUMMARY = "AMS qt5 image"
DESCRIPTION = "A-l M-ed S-o qt5 image"
LICENSE = "MIT"

require include/ams-image.inc

PR = "1.0.${PR_INC}"

# overwrite image name - to find it in tmp* tree
export IMAGE_BASENAME = "ams-image-qt5"

IMAGE_FEATURES_append = " debug-tweaks"

IMAGE_INSTALL_append += " \
    qt5-opengles2-test \
"