SUMMMARY = "AMS Base System"
LICENSE = "MIT"
PR = "r1"

inherit packagegroup

RDEPENDS_${PN} = " \
    formfactor \
    timestamp-service \
    mosquitto \
    ams-ref-pwa \
    hils \
    useradd-ams \
"

