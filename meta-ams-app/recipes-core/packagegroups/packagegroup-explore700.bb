SUMMMARY = "Packagegroup RaspberryPi - Explorer 700"
LICENSE = "MIT"
PR = "r1"

# https://joy-it.net/de/products/RB-Explorer700

inherit packagegroup

RDEPENDS:${PN} = " \
    rpi-hwctl \
    influxdb \ 
"

RDEPENDS:${PN}-dev = " \
"
