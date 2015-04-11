DESCRIPTION = "Python 3.4 Enum backport"
LICENSE = "BSD"
LIC_FILES_CHKSUM = "file://enum/LICENSE;md5=0a97a53a514564c20efd7b2e8976c87e"

PR = "r0"

SRC_URI = "https://pypi.python.org/packages/source/e/enum34/enum34-${PV}.tar.gz"
SRC_URI[md5sum] = "9d57f5454c70c11707998ea26c1b0a7c"
SRC_URI[sha256sum] = "384b593703b057e0b19d90ff62844b1c8796da2e6bd9957d6ce9119bdeade635"

S = "${WORKDIR}/enum34-${PV}"

inherit distutils
