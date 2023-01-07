SUMMMARY = "Packagegroup RaspberryPi - Explorer 700"
LICENSE = "MIT"
PR = "r1"

inherit packagegroup

RDEPENDS:${PN} = " \
    rpi-hwctl \
"

RDEPENDS:${PN}-dev = " \
"
