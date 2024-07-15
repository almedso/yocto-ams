PR:append = ".a2"

FILESEXTRAPATHS:prepend := "${THISDIR}/${PN}:"

# Machine specific: imx93-var-som-m33
#------------------------------
# Inject the device tree
SRC_URI:append:imx93-var-som-m33 = " \
"
#
# Define the kernel config fragments
SRC_URI:append:imx93-var-som-m33 = "\
    file://rpmsg.cfg \
"
