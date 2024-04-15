SUMMARY = "ESP Verificator"
DESCRIPTION = "ESP Verificator - python3 app with twisted and flask-restful"

HOMEPAGE = "http://gitlab.com/alemdso/esp-validator"
BUGTRACKER = "http://gitlab.com/alemdso/esp-validator"

# SECTION = "unknown/unknown"

LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://${COREBASE}/LICENSE.MIT;md5=030cb33d2af49ccebca74d0588b84a21 \
                    file://${COREBASE}/meta/COPYING.MIT;md5=3da9cfbcb788c80a0384361b4de20420"

INC_PR = "r0"

inherit gitpkgv setuptools3 systemd
inherit ptest

# here appending is unconditional, since it does not hurt
SRC_URI += "file://run-ptest"

PREFERED_VERSION_python = "3.5%"

RDEPENDS:${PN} += " \
        ${PYTHON_PN}-click \
        ${PYTHON_PN}-flask \
        ${PYTHON_PN}-flask-restful \
        ${PYTHON_PN}-pyserial \
        ${PYTHON_PN}-requests \
        ${PYTHON_PN}-twisted \
        glibc-utils \
"
# note: glibc-utils and glibc-locale is required for python?-click

FILES:${PN} += "\
        ${systemd_system_unitdir}/${PN}.service \
        ${sysconfdir}/${PN}.conf \
"

CONFFILES:${PN} += " \
        ${sysconfdir}/${PN}.conf \
"

SYSTEMD_SERVICE:${PN} = "${PN}.service"

do_install:append() {
        install -d ${D}${systemd_unitdir}/system
        install -m 0644 ${THISDIR}/${PN}/${PN}.service ${D}${systemd_system_unitdir}
        install -d ${D}${sysconfdir}
        install -m 0644 ${THISDIR}/${PN}/${PN}.conf ${D}${sysconfdir}

}

#do_install_ptest() {
#       maybe do not do anything
#}

RDEPENDS:${PN}-ptest += " \
        ${PYTHON_PN}-pytest \
"
