SUMMARY = "Bring up can0 native network"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://${COREBASE}/LICENSE.MIT;md5=030cb33d2af49ccebca74d0588b84a21"

PR = "1"

inherit systemd

RDEPENDS_${PN} += "\
    "

FILES_${PN} += "\
        ${systemd_system_unitdir}/${PN}.service \
"

SYSTEMD_SERVICE_${PN} = " ${PN}.service"

do_install_append() {
        install -d ${D}${systemd_unitdir}/system
        install -m 0644 ${THISDIR}/${PN}/${PN}.service ${D}${systemd_system_unitdir}
}
