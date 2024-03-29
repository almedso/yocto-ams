SUMMARY = "AMS minimal image"
DESCRIPTION = "A-l M-ed S-o minimal image for proof of concept"
LICENSE = "MIT"

require include/ams-image.inc

PR = "1.0"

# overwrite image name - to find it in tmp* tree
export IMAGE_BASENAME = "ams-image-minimal"

IMAGE_FEATURES:append = " debug-tweaks"

IMAGE_EXTRA_RDEPENDS += "kernel-module-morse-mod"
