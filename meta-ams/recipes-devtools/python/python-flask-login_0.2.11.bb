DESCRIPTION = "User session management for Flask"
LICENSE = "BSD"
LIC_FILES_CHKSUM = "file://LICENSE;md5=8aa87a1cd9fa41d969ad32cfdac2c596"

PR = "r0"

SRC_URI = "https://pypi.python.org/packages/source/F/Flask-Login/Flask-Login-${PV}.tar.gz"
SRC_URI[md5sum] = "c0a7eaf28623f0aeac4929dc05a7a064"
SRC_URI[sha256sum] = "83d5f10e5c4f214feed6cc41c212db63a58a15ac32e56df81591bfa0a5cee3e5"

S = "${WORKDIR}/Flask-Login-${PV}"

inherit setuptools

RDEPENDS_${PN} += "python-flask"
