PR:append = ".4"

FILESEXTRAPATHS:prepend := "${THISDIR}/${PN}:"

# inherit config fragments
SRC_URI += "file://defconfig"
# SRC_URI:append = " file://0001-enable-rust-modules.cfg "
# SRC_URI:append = " file://0002-rust-sample.cfg "

# SRC_URI:append:quirin = "file://quirin-gpio-mockup.cfg:"
# KERNEL_MODULE_AUTOLOAD:append:quirin = " gpio-mockup "
# KERNEL_MODULE_PROBECONF:append:quirin += "gpio-mockup"
# module_conf_gpio-mockup = "options gpio-mockup gpio_mockup_ranges=0,39"
