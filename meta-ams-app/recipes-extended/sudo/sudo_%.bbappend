# Patch the /etc/sudoer file
PR:append = ".ams.1"

# make sure we find the new file
FILESEXTRAPATHS:prepend := "${THISDIR}/${PN}:"
SRC_URI += "file://sudoers"


do_install:append () {
    install -p -m 440 ${WORKDIR}/sudoers ${D}${sysconfdir}/
}
