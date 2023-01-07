SUMMARY = "A Python implementation of the CANopen standard"
SECTION = "devel/python"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://LICENSE.txt;md5=ac7bbdcc253a85b2ad8e275a41b18d97"

SRC_URI[md5sum] = "a5eeef65bb5e9cd26dcce07b0fc0c473"
SRC_URI[sha256sum] = "15d49f1f71e9989dde6e3b75fb8445c76bd223064dfc0ac629fe9ecb0e21fba9"
# https://files.pythonhosted.org/packages/4b/88/640cb0146eb04db63e04308020c2a338ec4db53af41f0d58205f69e1069c/canopen-1.2.0.tar.gz
PYPI_PACKAGE="canopen"

inherit pypi setuptools3
DEPENDS += "${PYTHON_PN}-setuptools-scm-native"

RDEPENDS:${PN} += "\
    ${PYTHON_PN}-modules \
    ${PYTHON_PN}-can \
"
