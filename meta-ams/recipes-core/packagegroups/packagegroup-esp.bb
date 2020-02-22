SUMMMARY = "Packagegroup ESP - embedded software production"
LICENSE = "MIT"
PR = "r1"

inherit packagegroup

RDEPENDS_${PN} = " \
    hils \
    emb-spa \
"

RDEPENDS_${PN}-dev = " \
"
