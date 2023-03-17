DESCRIPTION = "Hardware development tools for audio"
LICENSE = "MIT"

PACKAGE_ARCH = "${MACHINE_ARCH}"

inherit packagegroup

RDEPENDS_${PN} = " \
    alsa-utils \
    alsa-utils-scripts \
    alsa-state \
    vorbis-tools \
    libao-plugin-libalsa \
"
