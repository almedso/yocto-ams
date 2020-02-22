PR_append = ".ams.1"

FILESEXTRAPATHS_prepend := "${THISDIR}/${PN}:"

SRC_URI_append = " \
    file://10-dhcp.network \
"
# enable networkd, resolved and timesyncd
# networkd - configures networks appropriately
# resolved - takes care for name resolution
# timesyncd - acts as ntp client
# see: https://jlk.fjfi.cvut.cz/arch/manpages/man/systemd.network.5
# see: https://hub.mender.io/t/how-to-configure-networking-using-systemd-in-yocto-project/1097
PACKAGECONFIG_append = " networkd resolved timesyncd"

# Make sure we get wpa-supplicant service available at runtime
# in order to connect to wireless networks
# see  https://hub.mender.io/t/how-to-configure-networking-using-systemd-in-yocto-project/1097

RDEPENDS_${PN}_append = " \
    ${@bb.utils.contains('MACHINE_FEATURES','wifi','wpa-supplicant','',d)} \
"

FILES_${PN} += "\
    ${sysconfdir}/systemd/network/10-dhcp.network \
"

do_install_append() {
    install -d ${D}${sysconfdir}/systemd/network
    install -m 0644 ${WORKDIR}/10-dhcp.network ${D}${sysconfdir}/systemd/network
}
