SUMMARY = "IOT product-grade image"
DESCRIPTION = "A product image capable of allowing an iot \
device to boot. It also provides full feature support."
LICENSE = "MIT"

require iot-image.inc
PR = "1.0.${PR_INC}"

CORE_IMAGE_EXTRA_INSTALL += " \
"
