SUMMMARY = "PLOS Base System"
LICENSE = "MIT"
PR = "r1"

inherit packagegroup

# For backwards compatibility after rename
RPROVIDES_packagegroup-base-plos = "packagegroup-plos-base"
RREPLACES_packagegroup-base-plos = "packagegroup-plos-base"
RCONFLICTS_packagegroup-base-plos = "packagegroup-plos-base"

RDEPENDS_${PN} = " \
    formfactor \
    timestamp-service \
    emba \
"

