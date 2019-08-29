SUMMARY = "AMS development image"
DESCRIPTION = "A-l M-ed S-o development image"
LICENSE = "MIT"

require include/ams-image.inc

PR = "1.0.${PR_INC}"

# overwrite image name - to find it in tmp* tree
export IMAGE_BASENAME = "ams-image-dev"

IMAGE_FEATURES_append = " \
    ptest-pkgs \
    debug-tweaks \
    tools-debug \
    tools-profile \
    empty-root-password \
    allow-empty-password \
    post-install-logging \
"
IMAGE_INSTALL_append = " \
    packagegroup-ams-tools-testapps \
    e2fsprogs-ptest \
    zlib-ptest \
    "

# debug and profile image blow up the time needed
# to create rootfs dramatically
OTHER_IMAGE_FEATURE_CANDIDATES = "\
    dev-pkgs \
    dbg-pkgs \
    "

# Additional image linguas are required if ptest shall work
# for glib-2.0-ptest
IMAGE_LINGUAS += " tr-tr, lt-lt, ja-jp.euc-jp, fa-ir, ru-ru, de-de, hr-hr, el-gr, fr-fr, es-es, en-gb"
# for bash-ptest
IMAGE_LINGUAS += " fr-fr, de-de"