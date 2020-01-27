SUMMMARY = "AMS Testing tools/applications"
LICENSE = "MIT"
PR = "r1"

inherit packagegroup

# Requires touchscreen in machine features to work
USE_TS = " \
    evtest \
"

# Different touchscreen tools
TSTOOLS = " \
    ${@bb.utils.contains('MACHINE_FEATURES', 'touchscreen', '${USE_TS}', '',d)} \
"

# Different simple serial bus tools
SERBUSTOOLS = " \
    i2c-tools \
"

GUI_SAMPLES_AND_TOOLS = " \
    clutter-1.0-examples \
    gtk+3-demo \
    libdrm-tests \
    qt5-simple \
    qt5-opengles2-test \
    qt5ledscreen \
    qtsmarthome \
    qt5everywheredemo \
    qt5nmapper \
    weston \
    weston-examples \
    weston-init \
"

RDEPENDS_${PN} = " \
    ${TSTOOLS} \
    ${SERBUSTOOLS} \
    ${GUI_SAMPLES_AND_TOOLS} \
"

