# Source: https://github.com/Angstrom-distribution/meta-angstrom/blob/master/recipes-core/systemd/timestamp-service.bb
DESCRIPTION = "Poor mans RTC using timestamps"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/MIT;md5=0835ade698e0bcf8506ecda2f7b4f302"

inherit allarch systemd

SRC_URI = "file://timestamp.service \
           file://load-timestamp.sh \
          "

do_compile() {
    :
}


do_install () {
	install -d ${D}/${bindir}

	install -m 0755 ${WORKDIR}/load-timestamp.sh ${D}/${bindir}

	install -d ${D}${systemd_unitdir}/system
	install -m 0644 ${WORKDIR}/timestamp.service ${D}${systemd_unitdir}/system
}

NATIVE_SYSTEMD_SUPPORT = "1"
SYSTEMD_PACKAGES = "${PN}"
SYSTEMD_SERVICE:${PN} = "timestamp.service"

FILES:${PN} += "${systemd_unitdir}/system"

