SUMMARY = "Embedded SPA/WPA"
DESCRIPTION = "Single Page Application/ Progressive Web Application for embedded linux target"

HOMEPAGE = "http://gitlab.com/almedso/emb-spa"
BUGTRACKER = "http://gitlab.com/almedso/emb-spa"

# SECTION = "unknown/unknown"

LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://${COREBASE}/LICENSE.MIT;md5=030cb33d2af49ccebca74d0588b84a21 \
                    file://${COREBASE}/meta/COPYING.MIT;md5=3da9cfbcb788c80a0384361b4de20420"

INC_PR = "r2"

DEPENDS = "nodejs-native"
RDEPENDS_${PN} = "nginx"

SPA_TARGET_LOCATION = "/var/www/ams-ref-spa/html"

do_configure () {
    npm ci
}

do_compile () {
    ./node_modules/@angular/cli/bin/ng build --prod
}

FILES_${PN} = "\
        ${SPA_TARGET_LOCATION}/** \
"

# todo PATCH app BASE_REF in index.html

do_install() {
        # collect all files from the build folder and place them to the
        # web servers home
        install -d -m 755 ${D}${SPA_TARGET_LOCATION}
        cd dist/esp-gui
        # install the directories first
        find . -type d -exec install -d -m 755 "${D}${SPA_TARGET_LOCATION}/{}" \;
        # install the files next
        find . -type f -exec install -m 644 "{}" "${D}${SPA_TARGET_LOCATION}/{}" \;
        cd -
}
