require iot-image-base.bb

SUMMARY = "A product image capable of allowing an iot \
device to boot. It also provides full feature support."

DESCRIPTION = "A product image capable of allowing an iot \
device to boot. It also provides full feature support."

LICENSE = "MIT"

IMAGE_FEATURES += " \
    package-management \
    ssh-server-openssh \
    "
