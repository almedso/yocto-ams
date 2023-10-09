SUMMARY = "EPS development image"
DESCRIPTION = "Embedded Software Production - HIL Simulator imaage"
LICENSE = "MIT"

require include/ams-image-dev.inc

PR = "1.0"

# overwrite image name - to find it in tmp* tree
export IMAGE_BASENAME = "esp-image-dev"

IMAGE_INSTALL:append = " \
  packagegroup-esp \
"
