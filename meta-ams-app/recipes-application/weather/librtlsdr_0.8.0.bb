DESCRIPTION = "librtlsdr"
HOMEPAGE = "https://github.com/librtlsdr/librtlsdr"
LICENSE = "GPL-2"
LIC_FILES_CHKSUM = "file://COPYING;md5=751419260aa954499f7abaabaa882bbe"

PR = "r2"

SRC_URI = "https://github.com/librtlsdr/librtlsdr/archive/refs/tags/v${PV}.tar.gz"
SRC_URI[md5sum] = "64f31f30f79cd91e4cd70b0a8edcff4e"
SRC_URI[sha256sum] = "ce18cd70c92d44e81e804b6b4dcd655e0e370d7c8a9c59c6a8fe59e60d3447fc"

S = "${WORKDIR}/librtlsdr-${PV}"

inherit cmake pkgconfig

EXTRA_OECMAKE += " \
    -DDETACH_KERNEL_DRIVER=ON \
"

DEPENDS = " \
	libusb1 \
"

RDEPENDS:${PN} = " \
	libusb1 \
"

BBCLASSEXTEND += "native"
