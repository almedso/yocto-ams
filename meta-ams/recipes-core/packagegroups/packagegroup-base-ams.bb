SUMMMARY = "AMS Base System"
LICENSE = "MIT"
PR = "r2"

inherit packagegroup

RDEPENDS_${PN} = " \
    formfactor \
    timestamp-service \
    useradd-operator \
"

