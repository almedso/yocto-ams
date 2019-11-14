PR_append = ".ams.1"

FILESEXTRAPATHS_prepend := "${THISDIR}/${PN}:"

SRC_URI_append = " \
    file://10-dhcp.network \
"

FILES_${PN} += "\
    ${sysconfdir}/systemd/network/10-dhcp.network \
"

do_install_append() {
    install -d ${D}${sysconfdir}/systemd/network
    install -m 0644 ${WORKDIR}/10-dhcp.network ${D}${sysconfdir}/systemd/network
}
