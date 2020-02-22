SUMMARY = "AMS gui image"
DESCRIPTION = "A-l M-ed S-o weston image"
LICENSE = "MIT"

require include/ams-image-dev.inc

PR = "1.2.${PR_INC}"

# overwrite image name - to find it in tmp* tree
export IMAGE_BASENAME = "ams-image-gui-dev"


IMAGE_INSTALL_append += " \
    packagegroup-ams-tools \
    packagegroup-gui \
"
