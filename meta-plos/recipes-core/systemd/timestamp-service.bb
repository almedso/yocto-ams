# Source: https://github.com/Angstrom-distribution/meta-angstrom/blob/master/recipes-core/systemd/timestamp-service.bb
DESCRIPTION = "Poor mans RTC using timestamps"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://${COREBASE}/LICENSE;md5=4d92cd373abda3937c2bc47fbc49d690"

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
SYSTEMD_SERVICE_${PN} = "timestamp.service"

FILES_${PN} += "${systemd_unitdir}/system"

