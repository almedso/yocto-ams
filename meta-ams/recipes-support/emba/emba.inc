DESCRIPTION = "PLOS Embedded Web Application"
SUMMARY = "Embedded Web Application"

HOMEPAGE = "http://github.com/pixmeter/emba"
BUGTRACKER = "http://github.com/pixmeter/emba/issues"

# SECTION = "unknown/unknown"

LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://${COREBASE}/LICENSE;md5=4d92cd373abda3937c2bc47fbc49d690 \
                    file://${COREBASE}/meta/COPYING.MIT;md5=3da9cfbcb788c80a0384361b4de20420"

INC_PR = "r0"


inherit setuptools gitpkgv systemd

RDEPENDS_${PN} += " \
        gunicorn \
        python-flask \
        python-flask-wtf \
        python-flask-script \
        python-flask-login \
        python-setuptools \
        python-pkgutil \
        python-html \
"

FILES_${PN} += "$ \
        {systemd_unitdir}/system \
        /var/lib/emba \
        ${sysconfdir} \
"

CONFFILES_${PN} += " \
        ${sysconfdir}/gunicorn-emba.conf \
"

SYSTEMD_SERVICE_${PN} = "gunicorn-emba.service"

do_install_append() {
        install -d ${D}${systemd_unitdir}/system
        install -m 0644 ${THISDIR}/${PN}/gunicorn-emba.service ${D}${systemd_unitdir}/system
        install -d ${D}${sysconfdir}
        install -m 0644 ${THISDIR}/${PN}/gunicorn-emba.conf ${D}${sysconfdir}
        install -d ${D}/var/lib/emba
}

