UMMARY = "AMS jupyter development image"
DESCRIPTION = "A-l M-ed S-o image with jupyter exposed image"
LICENSE = "MIT"

require include/ams-image-dev.inc

PR = "1.0.${PR_INC}"

# overwrite image name - to find it in tmp* tree
export IMAGE_BASENAME = "jupter-image-dev"


IMAGE_INSTALL:append += " \
    packagegroup-ams-tools \
    jupyter \
"
