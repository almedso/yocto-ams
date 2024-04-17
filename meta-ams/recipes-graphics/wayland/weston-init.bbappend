FILESEXTRAPATHS:prepend := "${THISDIR}/${PN}:"

SRC_URI += "file://profile"

do_install:append() {
    # Make sure a westen.sh exists just to make appends in higher prorizied layers
    # pass
    install -Dm0755 ${WORKDIR}/profile ${D}${sysconfdir}/profile.d/weston.sh
}
