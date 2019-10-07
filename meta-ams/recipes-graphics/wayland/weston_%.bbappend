PR_append = ".ams.1"

FILESEXTRAPATHS_prepend := "${THISDIR}/${PN}:"

SRC_URI += " file://weston.ini"

FILES_${PN}_append = " ${sysconfdir}/xdg/weston/weston.ini"

do_install_append () {
    install -d ${D}${sysconfdir}/xdg/weston
    install -m 0644 ${WORKDIR}/weston.ini ${D}${sysconfdir}/xdg/weston
}
