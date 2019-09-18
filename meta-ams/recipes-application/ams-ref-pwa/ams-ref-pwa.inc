DESCRIPTION = "AMS Reference PWA"
SUMMARY = "AMS Reference Progressive Web Application (PWA)"

HOMEPAGE = "http://github.com/alemdso/emba"
BUGTRACKER = "http://github.com/almedso/emba/issues"

# SECTION = "unknown/unknown"

LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://${COREBASE}/LICENSE;md5=b97a012949927931feb7793eee5ed924 \
                    file://${COREBASE}/meta/COPYING.MIT;md5=3da9cfbcb788c80a0384361b4de20420"

INC_PR = "r0"


inherit gitpkgv

WEB_TARGET_HOME = "/var/lib/ams-ref-pwa"
B = "${S}/a2hs"

RDEPENDS_${PN} += " \
        nginx \
"

DDEPENDS += " \
        nodejs-native \
        npm-native \
"


FILES_${PN} += "$ \
        /var/lib/ams-ref-pwa \
"

CONFFILES_${PN} += " \
"


do_install_append() {
        cd ${B}  # find with exec and {} need to work with relative directories
        # create all directories
        find . -type d -exec install -d "${D}${WEB_TARGET_HOME}/{}" \;
        # copy all files
        find . -type f -exec install -Dm 755 "{}" "${D}${WEB_TARGET_HOME}/{}" \;
}

