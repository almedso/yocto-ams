PR_INC_append = ".dev.1"

require ams-image.inc

IMAGE_FEATURES_append= " \
    debug-tweaks \
    tools-debug \
    tools-profile \
    post-install-logging \
    "

# debug and profile image blow up the time needed
# to create rootfs dramatically
OTHER_IMAGE_FEATURE_CANDIDATES = "\
    dev-pkgs \
    dbg-pkgs \
    ptest-pkgs \
    "
