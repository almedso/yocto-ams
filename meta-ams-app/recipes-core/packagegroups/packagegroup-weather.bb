SUMMMARY = "Packagegroup Imaging"
LICENSE = "MIT"
PR = "r1"

inherit packagegroup

RDEPENDS:${PN} = " \
    mosquitto \
    rtl-433 \
    influxdb \
"

RDEPENDS:${PN}-dev = " \
    mosquitto-clients \
"

