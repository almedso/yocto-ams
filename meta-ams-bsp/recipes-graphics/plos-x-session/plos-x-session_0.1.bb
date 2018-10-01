SUMMARY = "Extension to the very simple session manager for X"

PR = "r1"

LICENSE = "GPLv2"
LIC_FILES_CHKSUM = "file://session;endline=6;md5=cb4933e93d7740592e94cc3ddc0755fc"

SECTION = "x11"
RCONFLICTS_${PN} = "matchbox-common"

SRC_URI = "file://session"
S = "${WORKDIR}"

RDEPENDS_${PN} = "mini-x-session sudo"

do_install() {
	install -d ${D}/${sysconfdir}/mini_x
	install -m 0755 ${S}/session ${D}/${sysconfdir}/mini_x
}
