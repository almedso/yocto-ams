SUMMARY = "Application Qt5 browser"
AUTHOR = "Volker Kempert"
DESCRIPTION = "Application Qt5 browser"

LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://LICENSE;md5=a4da52e2ccbb1d4dfb1c9a26e5ba67a0"


SRC_URI = "git://github.com/almedso/yocto-qt5-browser.git;branch=master"
SRCREV = "${AUTOREV}"

BASE_VERSION = "0.3"
PR = ".r2"
PKGV = "${BASE_VERSION}+git${GITPKGV}"
PV = "${BASE_VERSION}+git${SRCPV}"

inherit gitpkgv
inherit qmake5 systemd

DEPENDS += "\
    qtbase \
    qtvirtualkeyboard \
    qtgraphicaleffects \
    qtmultimedia \
    qtquickcontrols2 \
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


S = "${WORKDIR}/git"

FILES_${PN} += "/usr/bin/qt5-browser"

inherit qmake5