SUMMARY = "AMS weston image"
DESCRIPTION = "A-l M-ed S-o weston image"
LICENSE = "MIT"

require include/ams-image.inc

PR = "1.1.${PR_INC}"

# overwrite image name - to find it in tmp* tree
export IMAGE_BASENAME = "ams-image-weston"

IMAGE_FEATURES_append = " \
   debug-tweaks \
   splash \
   hwcodecs \
   "

IMAGE_INSTALL_append += " \
    libdrm-tests \
    weston \
    weston-init \
    weston-examples gtk+3-demo clutter-1.0-examples \
"

