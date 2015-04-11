DESCRIPTION = "Werkzeug"
LICENSE = "BSD"
LIC_FILES_CHKSUM = "file://LICENSE;md5=a68f5361a2b2ca9fdf26b38aaecb6faa"

PR = "r0"

SRC_URI = "https://pypi.python.org/packages/source/W/Werkzeug/Werkzeug-${PV}.tar.gz"
SRC_URI[md5sum] = "231d10996b7c3c1efe1776f22d570f83"
SRC_URI[sha256sum] = "9cf783990b1a99173e707a5768610800aa87775e9d86e211d17180d5b6c245ab"

S = "${WORKDIR}/Werkzeug-${PV}"

inherit setuptools
