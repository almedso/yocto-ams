PR:append = ".ams.1"

FILESEXTRAPATHS:prepend := "${THISDIR}/${PN}:"

SRC_URI += " file://weston.ini"

FILES:${PN}:append = " ${sysconfdir}/xdg/weston/weston.ini"

do_install:append () {
    # Remove the udev rules that cause weston to auto-start despite systemd disabling
    rm ${D}${sysconfdir}/udev/rules.d/71-weston-drm.rules

    install -d ${D}${sysconfdir}/xdg/weston
    install -m 0644 ${WORKDIR}/weston.ini ${D}${sysconfdir}/xdg/weston
}
