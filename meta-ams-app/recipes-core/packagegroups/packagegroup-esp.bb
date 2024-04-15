SUMMMARY = "Packagegroup ESP - embedded software production"
LICENSE = "MIT"
PR = "r1"

inherit packagegroup

RDEPENDS:${PN} = " \
    hils \
    emb-spa \
"

RDEPENDS:${PN}-dev = " \
"
