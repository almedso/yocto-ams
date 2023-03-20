DESCRIPTION = "Hardware development tools for audio"
LICENSE = "MIT"
PR = "r1"

PACKAGE_ARCH = "${MACHINE_ARCH}"

inherit packagegroup

RDEPENDS:${PN} = " \
    alsa-utils \
    alsa-utils-scripts \
    alsa-state \
    vorbis-tools \
    libao-plugin-libalsa \
"
