SUMMARY = "Application Qt5 browser"
AUTHOR = "Volker Kempert"
DESCRIPTION = "Application Qt5 browser"

LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://LICENSE;md5=a4da52e2ccbb1d4dfb1c9a26e5ba67a0"

inherit gitpkgv qmake5

DEPENDS += "\
    qtbase \
    qtgraphicaleffects \
    qtmultimedia \
    qtquickcontrols2 \
    qtquickcontrols \
    qtwebengine \
    qtwebsockets \
    qttools-native \
    "

RDEPENDS_${PN} += "\
    qtbase \
    qtgraphicaleffects-qmlplugins \
    qtmultimedia-qmlplugins \
    qtquickcontrols2 \
    qtquickcontrols2-mkspecs \
    qtquickcontrols \
    qtvirtualkeyboard \
    qtwebengine \
    qtwebsockets \
    "

SRC_URI = "git://github.com/almedso/yocto-qt5-browser.git;branch=master"
SRCREV = "${AUTOREV}"

S = "${WORKDIR}/git"

FILES_${PN} += "/usr/bin/qt5-browser"

inherit qmake5