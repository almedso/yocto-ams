inherit systemd

# See for valid PACKAGECONFIGs:
# https://github.com/OSSystems/meta-browser/blob/master/meta-chromium/README.md
# We won't use any here since we want epic/stellar performance on target ...
# just bear in mind that linking Chromium takes ~8GB of RAM.
#PACKAGECONFIG_append = " component-build"

# Mesa is a build dependency? Per:
# https://community.nxp.com/t5/i-MX-Processors/Chromium-ozone-wayland-in-Yocto-Zeus-build-not-working-properly/td-p/1051099
DEPENDS += " \
    mesa \
"

# Custom chromium.service systemd file for starting with Weston
FILESEXTRAPATHS:prepend := "${THISDIR}/files:"

SRC_URI += " \
    file://chromium.service \
"

FILES:${PN} += " \
    ${systemd_system_unitdir}/chromium.service \
"

SYSTEMD_SERVICE:${PN} = "chromium.service"

do_install:append () {
    install -d ${D}${systemd_system_unitdir}
    install -m 0644 ${WORKDIR}/chromium.service ${D}${systemd_system_unitdir}
}

# enable is the default if not specified but let's be explicit
SYSTEMD_AUTO_ENABLE:${PN} = "enable"

