SUMMMARY = "Packagegroup GUI applications"
LICENSE = "MIT"
PR = "r2"

inherit packagegroup

RDEPENDS:${PN} = " \
    weston-init \
    weston \
    chromium-ozone-wayland \
"

RDEPENDS:${PN}-dev = " \
    ${GUI_SAMPLES} \
"

GUI_SAMPLES = " \
    gtk+3-demo \
    weston-examples \
"

# Saparate QT staff
QT_GUI_SAMPLES = " \
    qt5-simple \
    qt5-opengles2-test \
    qt5ledscreen \
    qtsmarthome \
    qt5everywheredemo \
    qt5nmapper \
"

QT_RDEPENDS:${PN} = " \
    qt-env \
    qt5-browser \
"

EXCLUDED_STUFF = " \
    clutter-1.0-examples \
    iced-word-clock \
    emb-spa \
"

