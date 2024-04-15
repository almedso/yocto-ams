PR:append = ".dev.2"

require ams-image.inc

IMAGE_FEATURES:append= " \
    debug-tweaks \
    tools-debug \
    tools-profile \
    tools-sdk \
    package-management \
    post-install-logging \
    "

IMAGE_INSTALL:append = " \
    packagegroup-ams-tools \
    "

# debug and profile image blow up the time needed
# to create rootfs dramatically
OTHER_IMAGE_FEATURE_CANDIDATES = "\
    dev-pkgs \
    dbg-pkgs \
    ptest-pkgs \
    "
