SUMMARY = "Weather Station from Tinkerforge written in Rust"
HOMEPAGE = "git@gitlab.com:volker-kempert/tinkerforge-weatherstation.git"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://LICENSE;md5=cc38aedb66ffade44ebffd945e837209"

INC_PR = "r1"

inherit cargo systemd

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
