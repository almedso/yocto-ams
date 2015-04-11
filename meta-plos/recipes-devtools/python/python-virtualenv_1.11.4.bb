DESCRIPTION = "Virtual Python Environment builder"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://LICENSE.txt;md5=53df9f8889d6a5fba83f425abe3b1568"

PR = "r0"

SRC_URI = "https://pypi.python.org/packages/source/v/virtualenv/virtualenv-${PV}.tar.gz \
           file://python-optimize.patch"
SRC_URI[md5sum] = "9accc2d3f0ec1da479ce2c3d1fdff06e"
SRC_URI[sha256sum] = "cf3d958f28eb7470bd04262ef397580a2e57407f2ee2c88e9b2892218eb0465a"

S = "${WORKDIR}/virtualenv-${PV}"

inherit setuptools
