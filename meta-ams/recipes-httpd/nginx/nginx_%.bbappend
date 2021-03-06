PR_append = ".ams.4"

FILESEXTRAPATHS_prepend := "${THISDIR}/files:"
SRC_URI += "file://ams-ref-spa.site"

FILES_${PN} += "\
    ${sysconfdir}/nginx/sites-available/ams-ref-spa \
"

do_install_append() {
    install -Dm 0644 ${WORKDIR}/ams-ref-spa.site ${D}${sysconfdir}/nginx/sites-available/ams-ref-spa
    ln -s ../sites-available/ams-ref-spa ${D}${sysconfdir}/nginx/sites-enabled/

    # remove the link of the default site - i.e. disable the default site
    rm ${D}${sysconfdir}/nginx/sites-enabled/default_server
}
