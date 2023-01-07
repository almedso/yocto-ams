
FILESEXTRAPATHS:prepend := "${THISDIR}/${PN}:"

SRC_URI += "file://config.cfg"

KERNEL_DEVICETREE += " \
    ${@bb.utils.contains('MACHINE_FEATURES', 'ads7846-touch', 'overlays/ads7846.dtbo', '', d)} \
"

KERNEL_MODULE_AUTOLOAD += " \
       ${@bb.utils.contains('MACHINE_FEATURES', 'ads7846-touch', 'ads7846', '', d)} \
"

# Enable things on the boot commandline for the JOY 3.5" display
CMDLINE:append = ' ${@oe.utils.conditional("JOY35", "1", "fbcon=map:10", "", d)}'

# Enable EXT4 encryption for /data partition
do_configure:prepend() {
    ext4Encryption="${@bb.utils.contains("DISTRO_FEATURES", "secure", "1", "0", d)}"
    if [ "${ext4Encryption}" = "1" ]; then
        kernel_configure_variable EXT4_ENCRYPTION y
        kernel_configure_variable EXT4_FS_ENCRYPTION y
        kernel_configure_variable FS_ENCRYPTION y
        kernel_configure_variable CRYPTO_AEAD y
        kernel_configure_variable CRYPTO_RNG y
        kernel_configure_variable CRYPTO_RNG_DEFAULT y
        kernel_configure_variable CRYPTO_NULL y
        kernel_configure_variable CRYPTO_SEQIV y
        kernel_configure_variable CRYPTO_CTR y
        kernel_configure_variable CRYPTO_CTS y
        kernel_configure_variable CRYPTO_ECB y
        kernel_configure_variable CRYPTO_XTS y
        kernel_configure_variable CRYPTO_HMAC y
        kernel_configure_variable CRYPTO_SHA256 y
        kernel_configure_variable CRYPTO_DRBG_MENU y
        kernel_configure_variable CRYPTO_DRBG y
        kernel_configure_variable CRYPTO_JITTERENTROPY y
    fi
}

