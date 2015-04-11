require plos-image-base.bb

SUMMARY = "A product image capable of allowing an plos \
device to boot. It also provides full feature support."

DESCRIPTION = "A product image capable of allowing an plos \
device to boot. It also provides full feature support."

LICENSE = "MIT"

IMAGE_FEATURES += " \
    package-management \
    ssh-server-openssh \
    "

inherit plos-image
