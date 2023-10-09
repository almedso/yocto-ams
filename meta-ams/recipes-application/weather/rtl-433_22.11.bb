# Copyright (C) 2023 Volker Kempert <volker.kempert@almedso.de>
SUMMARY = "rtl_433 -  SDR generic ISM data receiver"
DESCRIPTION = "Software defined radio generic ISM data receiver"
HOMEPAGE = "https://github.com/merbanan/rtl_433"
LICENSE = "GPL-v2"
LIC_FILES_CHKSUM = "file://COPYING;md5=751419260aa954499f7abaabaa882bbe"

PR = "r0"

SRC_URI = "https://github.com/merbanan/rtl_433/archive/refs/tags/${PV}.tar.gz"
SRC_URI[md5sum] = "0144cb3d46ee94c0920966b2ea9375f1"
SRC_URI[sha256sum] = "61a9163d69cc4b1da46aebbcaf969bd180a055a6b90f42ad281218cc4fbefb86"

S = "${WORKDIR}/rtl_433-${PV}"

inherit cmake pkgconfig systemd

DEPENDS = " \
	libusb1 \
	librtlsdr \
	openssl \
"

RDEPENDS:${PN} += " \
	libusb1 \
	openssl \
"

FILES:${PN} += "\
"

do_install:append() {
	# the install target also deploys a lot of sample configuration files that are not needed
	rm -rf ${D}/usr/etc

    # install -d ${D}${sysconfdir}/rtl_433
    # install -m 0644 ${WORKDIR}/20-eth.network ${D}${sysconfdir}/systemd/network
}
