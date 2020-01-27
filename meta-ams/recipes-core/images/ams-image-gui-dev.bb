SUMMARY = "AMS gui image"
DESCRIPTION = "A-l M-ed S-o weston image"
LICENSE = "MIT"

require include/ams-image.inc

PR = "1.1.${PR_INC}"

# overwrite image name - to find it in tmp* tree
export IMAGE_BASENAME = "ams-image-gui-dev"

IMAGE_FEATURES_append = " \
    debug-tweaks \
    splash \
    hwcodecs \
    tools-debug \
    tools-profile \
    empty-root-password \
    allow-empty-password \
    post-install-logging \
   "

IMAGE_INSTALL_append += " \
    qt-env \
    qt5-browser \
    nginx \
"

