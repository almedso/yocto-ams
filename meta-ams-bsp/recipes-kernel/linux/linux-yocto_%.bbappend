# Add gpio-mockup driver to qemu/quirin kernel
FILESEXTRAPATHS:prepend := "${THISDIR}/linux-yocto:"

# inherit configfragment
# SRC_URI_append_quirin += " \
#     file://quirin-gpio-mockup.cfg \
# "

# do_merge_default_config_prepend() {
#     mergeConfigFragments ${S}/arch/${ARCH}/configs/${KERNEL_DEFCONFIG}
# }

KERNEL_MODULE_AUTOLOAD_quirin += "gpio-mockup"
KERNEL_MODULE_PROBECONF += "gpio-mockup"
module_conf_gpio-mockup = "options gpio-mockup gpio_mockup_ranges=0,39"
