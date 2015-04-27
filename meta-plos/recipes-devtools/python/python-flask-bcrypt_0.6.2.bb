DESCRIPTION = "Brcrypt hashing for Flask"
LICENSE = "BSD"
LIC_FILES_CHKSUM = "file://LICENSE;md5=0ee2ee5bee7fe96597770e92db5719a8"

PR = "r0"

SRC_URI = "https://pypi.python.org/packages/source/F/Flask-Bcrypt/Flask-Bcrypt-${PV}.tar.gz"
SRC_URI[md5sum] = "5ec930a2004baca4867d742c3b16aa20"
SRC_URI[sha256sum] = "72012b5c38e06ba9f3151ec9d37e3d9917d5a4d6ee4c59606a9e67305627f5e1"

S = "${WORKDIR}/Flask-Bcrypt-${PV}"

inherit setuptools

RDEPENDS_${PN} += "python-flask"
