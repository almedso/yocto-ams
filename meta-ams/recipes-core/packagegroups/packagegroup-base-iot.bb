SUMMMARY = "IOT Base System"
LICENSE = "MIT"
PR = "r1"

inherit packagegroup

# For backwards compatibility after rename
RPROVIDES_packagegroup-base-iot = "packagegroup-iot-base"
RREPLACES_packagegroup-base-iot = "packagegroup-iot-base"
RCONFLICTS_packagegroup-base-iot = "packagegroup-iot-base"

RDEPENDS_${PN} = " \
    formfactor \
    timestamp-service \
    mosquitto \
    ams-ref-pwa \
    trsa \
"

