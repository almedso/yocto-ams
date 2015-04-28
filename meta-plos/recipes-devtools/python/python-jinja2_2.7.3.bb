DESCRIPTION = "Jinja2"
LICENSE = "BSD"
LIC_FILES_CHKSUM = "file://LICENSE;md5=20c831f91dd3bd486020f672ba2be386"

PR = "r0"

SRC_URI = "https://pypi.python.org/packages/source/J/Jinja2/Jinja2-${PV}.tar.gz"
SRC_URI[md5sum] = "b9dffd2f3b43d673802fe857c8445b1a"
SRC_URI[sha256sum] = "2e24ac5d004db5714976a04ac0e80c6df6e47e98c354cb2c0d82f8879d4f8fdb"

S = "${WORKDIR}/Jinja2-${PV}"

inherit setuptools

RDEPENDS_${PN} += " \
    python-markupsafe \
    python-shell \
"
