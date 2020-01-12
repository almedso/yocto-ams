SUMMARY = "Application Qt5 browser"
AUTHOR = "Volker Kempert"
DESCRIPTION = "Application Qt5 browser"

LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://LICENSE;md5=a4da52e2ccbb1d4dfb1c9a26e5ba67a0"

inherit gitpkgv qmake5

DEPENDS += "\
    qtbase \
    qtquickcontrols2 \
    "

RDEPENDS_${PN} += "\
    qtbase \
    qtquickcontrols2 \
    "

SRC_URI = "git://github.com/almedso/yocto-qt5-simple.git;branch=master"
SRCREV = "${AUTOREV}"

S = "${WORKDIR}/git"

FILES_${PN} += "/usr/bin/qt5-simple"

inherit qmake5