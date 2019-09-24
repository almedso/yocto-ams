
FILESEXTRAPATHS_prepend := "${THISDIR}/files:"

SRC_URI += "file://config.cfg"

KERNEL_DEVICETREE += " \
    ${@bb.utils.contains('MACHINE_FEATURES', 'ads7846-touch', 'overlays/ads7846.dtbo', '', d)} \
"

KERNEL_MODULE_AUTOLOAD += " \
       ${@bb.utils.contains('MACHINE_FEATURES', 'ads7846-touch', 'ads7846', '', d)} \
"

