DESCRIPTION = "Basic (core) software for bsp development"
LICENSE = "MIT"
PR = "r1"

# Needs to be machine dependent arch due to glibc-utils package that provides dynamic packages
PACKAGE_ARCH = "${MACHINE_ARCH}"

inherit packagegroup

RDEPENDS:${PN} = " \
    glibc-utils \
    kbd \
    kbd-keymaps \
    localedef \
"
