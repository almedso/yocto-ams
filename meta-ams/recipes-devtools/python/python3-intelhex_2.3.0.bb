SUMMARY = "Python library to read, write, create from scratch and manipulate data from Intel HEX file format"
SECTION = "devel/python"
LICENSE = "BSD"
LIC_FILES_CHKSUM = "file://LICENSE.txt;md5=4eba844696655c3eae07aca8e3a94772"

SRC_URI[md5sum] = "9de0e92c1b66f75322581c8b22c020c2"
SRC_URI[sha256sum] = "892b7361a719f4945237da8ccf754e9513db32f5628852785aea108dcd250093"
PYPI_PACKAGE="intelhex"

inherit pypi setuptools3
DEPENDS += "${PYTHON_PN}-setuptools-scm-native"
