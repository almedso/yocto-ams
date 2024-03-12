DESCRIPTION = "Wifi tooling software"
LICENSE = "MIT"
PR = "r2"


PACKAGE_ARCH = "${MACHINE_ARCH}"

inherit packagegroup

# iw - to show information about wireless devices
# hostapd - WPA and radius authenticator

RDEPENDS:${PN} = " \
     ${@bb.utils.contains('MACHINE_FEATURES','wifi','wpa-supplicant iw hostapd ','',d)} \
"


RDEPENDS_SPECIFIC_PHYTEC_BSP_LAYER = " \
    laird-sterling-firmware \
"

