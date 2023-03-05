DISTRO_VERSION ??= "UNASSIGNED"
DISTRO_VERSION ?= "hardknott"

VENDOR = "almedso"
TARGET_VENDOR = "-${VENDOR}"

SDK_VENDOR = "-${VENDOR}sdk"
SDK_VERSION := "${DISTRO_VERSION}"
SDK_NAME = "${VENDOR}-${DISTRO}-${TCLIBC}-${SDK_ARCH}-${IMAGE_BASENAME}-${TUNE_PKGARCH}"
SDKPATH = "/opt/${VENDOR}-${DISTRO}/${SDK_VERSION}"

# Prelink images
INHERIT += "image-prelink"

# optimize lib sizes with mklibs
INHERIT += "image-mklibs"

# Package handling
PACKAGE_CLASSES ?= "package_ipk"
OPKG_ARGS_remove = "--prefer-arch-to-version"

# It's a prebuild glibc designed to remove the differences between
# host distros, meaning that native sstate objects can be shared
# between host distros.
# Move listet checks from ERROR_QA to WARN_QA (defined in insane.bbclass)
ERROR_TO_WARN_QA = "version-going-backwards"
ERROR_QA_remove = "${ERROR_TO_WARN_QA}"
WARN_QA_append = " ${ERROR_TO_WARN_QA}"

# suppress meta-virtualization useless warning when building
# without virtualization distro feature
SKIP_META_VIRT_SANITY_CHECK = "1"

# Suppress meta-rauc warning when building without rauc distro feature. We only
# activate this distro feature when needed in distros tailored for this
# use-case.
SKIP_META_RAUC_FEATURE_CHECK = "1"

VIRTUAL-RUNTIME_dev_manager = "udev"
VIRTUAL-RUNTIME_init_manager = "systemd"
DISTRO_FEATURES_BACKFILL_CONSIDERED += "sysvinit"
VIRTUAL-RUNTIME_login_manager = "busybox"
VIRTUAL-RUNTIME_syslog = ""
VIRTUAL-RUNTIME_initscripts = ""

# some default locales
IMAGE_LINGUAS ?= "de-de en-us"
