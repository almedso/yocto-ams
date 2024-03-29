SUMMARY = "EPS product-grade image"
DESCRIPTION = "Embedded Software Production - HIL Simulator imaage"
LICENSE = "MIT"

require include/ams-image.inc

PR = "1.0"

# overwrite image name - to find it in tmp* tree
export IMAGE_BASENAME = "powlog-image"

IMAGE_INSTALL:append = " \
    power-logger \
    openssh \
    useradd-operator \
    sudo \
    nginx \
"
