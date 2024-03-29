SUMMARY = "Power Logger"
DESCRIPTION = "Power Logger"

HOMEPAGE = "https://github.com/volker-kempert/power-logger"
BUGTRACKER = "https://github.com/volker-kempert/power-logger"

# SECTION = "unknown/unknown"

LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://LICENSE;md5=5f304fef41dfb5905b37457a44bc19b5"

INC_PR = "r3"

inherit setuptools3 systemd


PREFERED_VERSION_python = "3.8%"

RDEPENDS:${PN} += " \
        ${PYTHON_PN}-requests \
"

FILES:${PN} += "\
        ${systemd_system_unitdir}/${PN}.service \
"

SYSTEMD_SERVICE:${PN} = "${PN}.service"

do_install:append() {
        install -d ${D}${systemd_unitdir}/system
        install -m 0644 ${THISDIR}/${PN}/${PN}.service ${D}${systemd_system_unitdir}

        # prepare the directory to write to
        install --mode=0777 --directory ${D}/var/www/ams-ref-spa/html

        # Write a readme to be visible on the web
        install -m 0644 ${THISDIR}/${PN}/README.html ${D}/var/www/ams-ref-spa/html
}
