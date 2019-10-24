SUMMARY = "AMS minimal image"
DESCRIPTION = "A-l M-ed S-o minimal image for proof of concept"
LICENSE = "MIT"

require include/ams-image.inc

PR = "1.0.${PR_INC}"

# overwrite image name - to find it in tmp* tree
export IMAGE_BASENAME = "ams-image-minimal"

IMAGE_FEATURES_append = " debug-tweaks"
