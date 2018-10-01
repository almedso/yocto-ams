FILESEXTRAPATHS_prepend := "${THISDIR}/${PN}:"

DEPENDS += "libxcomposite libxfixes xdamage"
SRC_URI += "file://0001-Fix-libm-linking.patch"
EXTRA_OECONF =+ "--enable-composite"
