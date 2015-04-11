DESCRIPTION = "Werkzeug"
LICENSE = "BSD"
LIC_FILES_CHKSUM = "file://LICENSE;md5=c6d1adcf45d69359f256c1cea3254127"

PR = "r0"

SRC_URI = "https://pypi.python.org/packages/source/M/MarkupSafe/MarkupSafe-${PV}.tar.gz"
SRC_URI[md5sum] = "f5ab3deee4c37cd6a922fb81e730da6e"
SRC_URI[sha256sum] = "a4ec1aff59b95a14b45eb2e23761a0179e98319da5a7eb76b56ea8cdc7b871c3"

S = "${WORKDIR}/MarkupSafe-${PV}"

inherit setuptools
