SUMMARY = "A console-only image that fully supports the target device \
hardware provided by ams."

inherit iot-image

LICENSE = "MIT"

CORE_IMAGE_EXTRA_INSTALL += " \
    dhcp-client \
    resolvconf \
    connman \
"
