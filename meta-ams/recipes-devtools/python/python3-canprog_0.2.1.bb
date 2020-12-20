SUMMARY = "Command-line tool to flashing devices by CAN-BUS"
SECTION = "devel/python"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://PKG-INFO;md5=4f75ebcb3ba962e96ef933cd680bf61f"

SRC_URI[md5sum] = "db975dccfa518e74c91814d102667666"
SRC_URI[sha256sum] = "1359af1b511093930fc5ce902af2da60f479ffae9baaff721c6bd608446e54a9"
PYPI_PACKAGE="canprog"

inherit pypi setuptools3
DEPENDS += "${PYTHON_PN}-setuptools-scm-native"

RDEPENDS_${PN} += "\
    ${PYTHON_PN}-can \
    ${PYTHON_PN}-intelhex \
"
