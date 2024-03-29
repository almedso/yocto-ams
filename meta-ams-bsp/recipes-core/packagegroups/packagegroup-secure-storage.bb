DESCRIPTION = "Packagegroup Secure Key Storage for Kernel keyring access"
LICENSE = "MIT"
PR = "r1"

inherit packagegroup

# Runtime packages used in 'securestorage-ramdisk-init'
RDEPENDS:${PN} = " \
    util-linux \
    cryptsetup \
    lvm2 \
    kernel-module-dm-integrity \
"
