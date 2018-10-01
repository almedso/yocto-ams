DESCRIPTION = "Its dangerous"
LICENSE = "BSD"
LIC_FILES_CHKSUM = "file://LICENSE;md5=b61841e2bf5f07884148e2a6f1bcab0c"

PR = "r0"

SRC_URI = "https://pypi.python.org/packages/source/i/itsdangerous/itsdangerous-${PV}.tar.gz"
SRC_URI[md5sum] = "a3d55aa79369aef5345c036a8a26307f"
SRC_URI[sha256sum] = "cbb3fcf8d3e33df861709ecaf89d9e6629cff0a217bc2848f1b41cd30d360519"

S = "${WORKDIR}/itsdangerous-${PV}"

inherit setuptools

RDEPENDS_${PN} += " \
    python-json \
"