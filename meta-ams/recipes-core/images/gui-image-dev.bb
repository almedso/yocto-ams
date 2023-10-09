UMMARY = "AMS gui image"
DESCRIPTION = "A-l M-ed S-o weston image"
LICENSE = "MIT"

require include/ams-image-dev.inc

PR = "1.2"

# overwrite image name - to find it in tmp* tree
export IMAGE_BASENAME = "gui-image-dev"


IMAGE_INSTALL += " \
    packagegroup-ams-tools \
    packagegroup-gui \
"
