PR:append = ".ams.1"

FILESEXTRAPATHS:prepend := "${THISDIR}/${PN}:"
SRC_URI += "file://sshd_config"


do_install:append () {
    # Overwrite existing default configuration
    # because the default allows ssh via root
    install -p -m 440 ${WORKDIR}/sshd_config ${D}${sysconfdir}/ssh/
}
