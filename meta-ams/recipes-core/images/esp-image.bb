SUMMARY = "EPS product-grade image"
DESCRIPTION = "Embedded Software Production - HIL Simulator imaage"
LICENSE = "MIT"

require include/ams-image.inc

PR = "1.0.${PR_INC}"

CORE_IMAGE_EXTRA_INSTALL += " \
  hils \
"
