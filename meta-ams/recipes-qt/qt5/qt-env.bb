SUMMARY = "Configure Qt5"

LICENSE = "GPL-2.0"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/GPL-2.0;md5=801f80980d171dd6425610833a22dbe6"

SRC_URI = " \
    file://qt5-env.sh \
    file://qt5-env-wayland.sh \
"

S = "${WORKDIR}"


# Make sure wayland backend is installed for Qt in case it is configured
RDEPENDS_${PN} += "\
    ${@bb.utils.contains('DISTRO_FEATURES', 'wayland', 'qtwayland', '', d)} \
    "

HAS_WAYLAND = "${@bb.utils.contains('DISTRO_FEATURES', 'wayland', 1, 0, d)}"

FILES_${PN} += " \
    ${sysconfdir}/profile.d/qt5-env.sh \
    "


do_install() {
    install -d -m 0755 ${D}${sysconfdir}/profile.d

    if [ ${HAS_WAYLAND} -eq 1 ]; then
        install -m 0644 qt5-env-wayland.sh ${D}${sysconfdir}/profile.d/qt5-env.sh
    else
        install -m 0644 qt5-env.sh ${D}${sysconfdir}/profile.d
    fi
}
