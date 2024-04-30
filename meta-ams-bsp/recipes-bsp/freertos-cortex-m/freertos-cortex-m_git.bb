inherit gitpkgv

SDK_PV = "2.13.x"
# Composing PV: s for sdk portion a for application portion
PV = "s${SDK_PV}-agit${SRCPV}"
PKGV = "s${SDK_PV}-agit${GITPKGV}"

# See https://github.com/varigit/freertos-variscite/blob/mcuxpresso_sdk_2.13.x-var01/docs/MCUXpresso%20SDK%20Release%20Notes%20for%20MCIMX93-EVK.pdf
# "Development Tools" section for supported GCC version
CM_GCC = "10.3-2021.10"

SRCREV_FORMAT = "sdk_apps"

MCUXPRESSO_BRANCH = "mcuxpresso_sdk_${SDK_PV}-var01"
MCUXPRESSO_BRANCH:mx9-nxp-bsp = "mcuxpresso_sdk_${SDK_PV}-var02"
SRC_URI = " git://github.com/varigit/freertos-variscite.git;protocol=https;branch=${MCUXPRESSO_BRANCH};name=sdk;destsuffix=sdk; "
# Reference the SDK version 2.13.x variant var01
SRCREV_sdk= "66cb1c980506524e85364ddadbdaace381c621a6"
# Reference the SDK version 2.13.x variant var02
SRCREV_sdk:mx9-nxp-bsp = "d711e8367c9d86fb1c6e60c99e7a92dd6c1622b3"
COMPATIBLE_MACHINE = "(mx9-nxp-bsp|imx8mm-var-dart|imx8mn-var-som|imx8mp-var-dart|imx8mq-var-dart)"

## SRC_URI:append:mx9-nxp-bsp = " git://github.com/varigit/freertos-variscite.git;protocol=https;branch=${MCUXPRESSO_BRANCH};name=sdk;destsuffix=sdk; "

# The application is located in another repository and sourced here under the app-path
SRC_URI += " git://git@github.com/almedso/m33-on-imx93.git;protocol=ssh;branch=master;name=apps;destsuffix=apps; "
SRCREV_apps = "${AUTOREV}"

include freertos-cortex-m.inc
