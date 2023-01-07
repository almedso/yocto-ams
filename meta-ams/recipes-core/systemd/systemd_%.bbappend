PR:append = ".ams.3"

FILESEXTRAPATHS:prepend := "${THISDIR}/${PN}:"

SRC_URI:append = " \
    file://10-wlan.network \
    file://20-eth.network \
"
# enable networkd, resolved and timesyncd
# networkd - configures networks appropriately
# resolved - takes care for name resolution
# timesyncd - acts as ntp client
# see: https://jlk.fjfi.cvut.cz/arch/manpages/man/systemd.network.5
# see: https://hub.mender.io/t/how-to-configure-networking-using-systemd-in-yocto-project/1097
PACKAGECONFIG:append = " networkd resolved timesyncd"

# Make sure we get wpa-supplicant service available at runtime
# in order to connect to wireless networks
# see  https://hub.mender.io/t/how-to-configure-networking-using-systemd-in-yocto-project/1097

RDEPENDS:${PN}:append = " \
    ${@bb.utils.contains('MACHINE_FEATURES','wifi','wpa-supplicant','',d)} \
"

FILES:${PN} += "\
    ${sysconfdir}/systemd/network/10-wlan.network \
    ${sysconfdir}/systemd/network/20-eth.network \
"

do_install:append() {
    install -d ${D}${sysconfdir}/systemd/network
    install -m 0644 ${WORKDIR}/10-wlan.network ${D}${sysconfdir}/systemd/network
    install -m 0644 ${WORKDIR}/20-eth.network ${D}${sysconfdir}/systemd/network
}
