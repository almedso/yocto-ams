inherit kernel-module-split-blacklist
include recipes-kernel/linux/mtd_test_packages.inc

FILESEXTRAPATHS_prepend := "${THISDIR}/features:"

SRC_URI_append = " file://mtd-tests.cfg"
KERNEL_MODULES_RDEPENDS_BLACKLIST += "${MTD_TEST_PACKAGES}"

SRC_URI_append_secureboot = " \
    file://fs_encryption.cfg \
    file://ubifs_encryption.cfg \
    file://dm_crypt_devicemapper.cfg \
    file://crypto-api.cfg \
    file://trustedkey-base.cfg \
    ${@bb.utils.contains('MACHINE_FEATURES', 'tpm2', 'file://trustedkey-tpm.cfg', '', d)} \
    ${@bb.utils.contains('MACHINE_FEATURES', 'caam', 'file://trustedkey-caam.cfg', '', d)} \
    ${@bb.utils.contains('MACHINE_FEATURES', 'optee', 'file://trustedkey-tee.cfg', '', d)} \
"
SRC_URI_append_kernelmodsign = " \
    file://kernel-modsign.cfg \
"
SRC_URI_append_update = " \
    file://rauc.cfg \
"

inherit ${@bb.utils.contains('DISTRO_FEATURES', 'kernelmodsign', 'kernel-modsign', '', d)}

LOCALVERSION = "-${@legitimize_package_name(d.getVar('DISTRO_VERSION', True))}"