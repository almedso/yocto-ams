SUMMARY = "Running jupyter lab as a service"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://${COREBASE}/LICENSE.MIT;md5=030cb33d2af49ccebca74d0588b84a21"

PR = "4"

inherit systemd useradd

RDEPENDS:${PN} += "\
    packagegroup-imaging \
    packagegroup-python3-jupyter \
    "

SERVICE_HOME = "/home/${PN}"

USERADD_PACKAGES = "${PN}"
USERADD_PARAM:${PN} = "--home-dir ${SERVICE_HOME} --create-home --no-user-group --gid video ${PN}"

FILES:${PN} += "\
        ${systemd_system_unitdir}/${PN}.service \
        ${SERVICE_HOME}/.jupyter/jupyter_notebook_config.py \
        ${SERVICE_HOME}/.jupyter/jupyter_notebook_config.json \
        ${SERVICE_HOME}/example-opencv-v4l2.ipynb \
        ${SERVICE_HOME}/example-particle-count.ipynb \
        ${SERVICE_HOME}/fluorescent-particle.png \
"

CONFFILES:${PN} += " \
        ${sysconfdir}/${PN}.json \
"

SYSTEMD_SERVICE:${PN} = " ${PN}.service"

do_install:append() {
        install -d ${D}${systemd_unitdir}/system
        install -m 0644 ${THISDIR}/${PN}/${PN}.service ${D}${systemd_system_unitdir}
        install -d ${D}${SERVICE_HOME}/.jupyter
        install -m 0644 ${THISDIR}/${PN}/jupyter_notebook_config.py ${D}${SERVICE_HOME}/.jupyter
        install -m 0644 ${THISDIR}/${PN}/jupyter_notebook_config.json ${D}${SERVICE_HOME}/.jupyter
        install -m 0644 ${THISDIR}/${PN}/example-opencv-v4l2.ipynb ${D}${SERVICE_HOME}
        install -m 0644 ${THISDIR}/${PN}/example-particle-count.ipynb ${D}${SERVICE_HOME}
        install -m 0644 ${THISDIR}/${PN}/fluorescent-particle.png ${D}${SERVICE_HOME}

        chown -R ${PN}:video ${D}${SERVICE_HOME}

}
