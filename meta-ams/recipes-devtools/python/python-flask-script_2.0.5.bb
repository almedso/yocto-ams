DESCRIPTION = "Flask Scripts"
LICENSE = "BSD"
LIC_FILES_CHKSUM = "file://LICENSE;md5=e686048adb69341fc8a08caeda528b41"

PR = "r0"

SRC_URI = "https://pypi.python.org/packages/source/F/Flask-Script/Flask-Script-${PV}.tar.gz"
SRC_URI[md5sum] = "e5c73d3b7937f5b88942f342f9617029"
SRC_URI[sha256sum] = "cef76eac751396355429a14c38967bb14d4973c53e07dec94af5cc8fb017107f"

S = "${WORKDIR}/Flask-Script-${PV}"

inherit setuptools

RDEPENDS_${PN} += "python-flask"
