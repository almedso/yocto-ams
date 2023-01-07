SUMMMARY = "Packagegroup GUI applications"
LICENSE = "MIT"
PR = "r1"

inherit packagegroup

RDEPENDS:${PN} = " \
    qt-env \
    qt5-browser \
    emb-spa \
    weston \
    weston-init \
"

RDEPENDS:${PN}-dev = " \
    ${GUI_SAMPLES} \
"

GUI_SAMPLES = " \
    clutter-1.0-examples \
    gtk+3-demo \
    qt5-simple \
    qt5-opengles2-test \
    qt5ledscreen \
    qtsmarthome \
    qt5everywheredemo \
    qt5nmapper \
    weston-examples \
"
