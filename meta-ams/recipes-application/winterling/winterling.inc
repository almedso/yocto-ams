SUMMARY = "Rest service to control raspi"
HOMEPAGE = "git@gitlab.com:almedso/winterling.git"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://LICENSE.md;md5=2132a6d3449ec2731209701beda95440"

INC_PR = "r2"

inherit cargo


FILES:${PN} += "\
        ${systemd_system_unitdir}/${PN}.service \
        ${sysconfdir}/${PN}.toml \
"

CONFFILES:${PN} += " \
        ${sysconfdir}/${PN}.toml \
"

SYSTEMD_SERVICE:${PN} = "${PN}.service"

do_install:append() {
        install -d ${D}${systemd_unitdir}/system
        install -m 0644 ${THISDIR}/${PN}/${PN}.service ${D}${systemd_system_unitdir}
        install -d ${D}${sysconfdir}
        install -m 0644 ${THISDIR}/${PN}/${PN}.toml ${D}${sysconfdir}
}
