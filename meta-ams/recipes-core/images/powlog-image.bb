SUMMARY = "EPS product-grade image"
DESCRIPTION = "Embedded Software Production - HIL Simulator imaage"
LICENSE = "MIT"

require include/ams-image.inc

PR = "1.0.${PR_INC}"

# overwrite image name - to find it in tmp* tree
export IMAGE_BASENAME = "sollog-image"

IMAGE_INSTALL_append = " \
    power-logger \
    openssh \
    useradd-operator \
    sudo \
    nginx \
"
