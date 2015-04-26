DESCRIPTION = "PLOS Embedded Web Application"
SUMMARY = "Embedded Web Application"

HOMEPAGE = "http://github.com/pixmeter/emba"
BUGTRACKER = "http://github.com/pixmeter/emba/issues"

# SECTION = "unknown/unknown"

LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://${COREBASE}/LICENSE;md5=4d92cd373abda3937c2bc47fbc49d690 \
                    file://${COREBASE}/meta/COPYING.MIT;md5=3da9cfbcb788c80a0384361b4de20420"

INC_PR = "r0"


inherit useradd setuptools gitpkgv systemd

RDEPENDS_${PN} += " \
        gunicorn \
        python-flask \
        python-flask-wtf \
        python-setuptools \
"


USERADD_PACKAGES = "${PN}"
USERADD_PARAM_${PN} = " \
        --uid 1024 --user-group ${PN} \
        --create-home --base-dir /var/lib \
        --shell /bin/sh \
        --password changeme \
"

FILESEXTRAPATHS_prepend := "${THISDIR}/${PN}:"
FILES_${PN} += "${systemd_unitdir}/system \
                ${systemd_unitdir}/system/tempfiles.d \
                ${systemd_unitdir}/system/tempfiles.d/gunicorn-emba.conf \
               "

SYSTEMD_SERVICE_${PN} = "gunicorn-emba.service"

do_install_append() {
        install -d ${D}${systemd_unitdir}/system
        # install -d ${D}${systemd_unitdir}/system/tempfiles.d
        install -m 0644 gunicorn-emba.service ${D}${systemd_unitdir}/system/
        install -m 0644 gunicorn-emba.socket ${D}${systemd_unitdir}/system/
        # install -m 0644 gunicorn-emba.conf ${D}${systemd_unitdir}/system/tempfiles.d/

}

