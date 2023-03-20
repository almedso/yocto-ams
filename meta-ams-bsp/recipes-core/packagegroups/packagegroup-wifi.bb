DESCRIPTION = "Wifi tooling software"
LICENSE = "MIT"
PR = "r1"


PACKAGE_ARCH = "${MACHINE_ARCH}"

inherit packagegroup

# wpa_supplicant and wireless-tools are already install in packagegroup-base-wifi
RDEPENDS:${PN} = " \
    wpa-supplicant \
    iw \
    hostapd \
    laird-sterling-firmware \
"
