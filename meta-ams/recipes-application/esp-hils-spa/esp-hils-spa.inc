DESCRIPTION = "ESP HILS SPA"
SUMMARY = "ESP Hardware In a Loop Simulator (HILS) - Single page application (SPA) "

HOMEPAGE = "https://gitlab.com/almedso/esp-hils-spa"
BUGTRACKER = "https://gitlab.com/almedso/esp-hils-spa/issues"

# SECTION = "unknown/unknown"

LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://${COREBASE}/LICENSE;md5=4d92cd373abda3937c2bc47fbc49d690 \
                    file://${COREBASE}/meta/COPYING.MIT;md5=3da9cfbcb788c80a0384361b4de20420"

INC_PR = "r0"

PREFERRED_VERSION_nodejs = "10.7.0"

inherit gitpkgv

inherit npm-install-global

BBCLASSEXTEND = "native nativesdk"

WEB_TARGET_HOME = "/var/lib/${PN}"
B = "${S}/build"

RDEPENDS_${PN} += " \
        nginx \
"

DEPENDS_${PN} += " \
        nodejs-native \
        npm-native \
"


FILES_${PN} += "\
        /var/lib/${PN} \
"

CONFFILES_${PN} += " \
"

do_compile() {
        cd ${S}
        ng build --prod
}

do_install() {
        cd ${B}  # find with exec and {} need to work with relative directories
        # create all directories
        find . -type d -exec install -d "${D}${WEB_TARGET_HOME}/{}" \;
        # copy all files
        find . -type f -exec install -Dm 755 "{}" "${D}${WEB_TARGET_HOME}/{}" \;
}

