# Patch the /etc/sudoer file
PR_append = ".ams.1"

# make sure we find the new file
FILESEXTRAPATHS_prepend := "${THISDIR}/${PN}:"
SRC_URI += "file://sudoers"


do_install_append () {
    install -p -m 440 ${WORKDIR}/sudoers ${D}${sysconfdir}/
}