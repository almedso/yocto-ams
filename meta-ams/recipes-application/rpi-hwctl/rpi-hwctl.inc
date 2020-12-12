SUMMARY = "RaspberryPi Hardware Control in Rust"
HOMEPAGE = "git@gitlab.com:almedso/rpi-hwctl.git"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://LICENSE.md;md5=2132a6d3449ec2731209701beda95440"

INC_PR = "r2"

inherit cargo systemd

# CARGO_FEATURES = "feature1 feature2"

FILES_${PN} += "\
        ${systemd_system_unitdir}/${PN}.service \
        ${systemd_system_unitdir}/${PN}-once.service \
        ${sysconfdir}/${PN}.toml \
"

CONFFILES_${PN} += " \
        ${sysconfdir}/${PN}.toml \
"

SYSTEMD_SERVICE_${PN} = " ${PN}.service ${PN}-once.service"

do_install_append() {
        install -d ${D}${systemd_unitdir}/system
        install -m 0644 ${THISDIR}/${PN}/${PN}.service ${D}${systemd_system_unitdir}
        install -m 0644 ${THISDIR}/${PN}/${PN}-once.service ${D}${systemd_system_unitdir}
        install -d ${D}${sysconfdir}
        install -m 0644 ${THISDIR}/${PN}/${PN}.toml ${D}${sysconfdir}
}
