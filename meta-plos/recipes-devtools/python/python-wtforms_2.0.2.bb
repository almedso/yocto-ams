DESCRIPTION = "WTForms"
LICENSE = "BSD"
LIC_FILES_CHKSUM = "file://LICENSE.txt;md5=b4690d03125dd93251646f2e6f02b3f1"

PR = "r0"

SRC_URI = "https://pypi.python.org/packages/source/W/WTForms/WTForms-${PV}.zip"
SRC_URI[md5sum] = "613cf723ab40537705bec02733c78d95"
SRC_URI[sha256sum] = "10737758ceae03b53021f3aa7e81bfc8dd6f679c879ffeb5e64ac6570facb6c1"

S = "${WORKDIR}/WTForms-${PV}"

inherit setuptools
