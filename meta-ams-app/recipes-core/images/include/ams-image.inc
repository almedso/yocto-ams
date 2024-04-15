LICENSE = "MIT"
PR:append = ".r2"

inherit core-image

# Build info configuration
#------------------------------------------------------------------------------
# BUILD_NUMBER is a subject to be injected from the outside environment during
# CI build (via BB_ENV_PASSTHROUGH_ADDITIONS)
inherit image-buildinfo
BUILD_NUMBER ?= "dirty"
BUILD_DATE = "${@time.strftime('%Y-%m-%d %H:%M',time.gmtime())}"
BUILD_HOST = "${@os.uname()[1]}"
IMAGE_BUILDINFO_VARS = " \
    DISTRO DISTRO_NAME DISTRO_VERSION \
    MACHINE IMAGE_BASENAME \
    BUILD_HOST BUILD_DATE BUILD_NUMBER \
"

require rootfs-post-install.inc

KERNEL_DEVICETREE += " \
    ${@bb.utils.contains('MACHINE_FEATURES', 'ads7846-touch', 'overlays/ads7846.dtbo', '', d)} \
"


IMAGE_INSTALL:append = " \
    packagegroup-base-ams \
    "

IMAGE_INSTALL:remove = " \
    netkit-telnet \
    "

IMAGE_FEATURES:append= " \
    package-management \
    ssh-server-openssh \
    "

IMAGE_FEATURES:remove = " \
    splash \
    "
