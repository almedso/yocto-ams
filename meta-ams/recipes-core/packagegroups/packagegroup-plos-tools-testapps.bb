SUMMMARY = "PLOS Testing tools/applications"
LICENSE = "MIT"
PR = "r1"

inherit packagegroup

# Requires touchscreen in machine features to work
USE_TS = " \
    evtest \
"

# Different touchscreen tools
#TSTOOLS = " \
#    ${@base_contains('MACHINE_FEATURES', 'touchscreen', '${USE_TS}', '',d)} \
#"

# Different simple serial bus tools
SERBUSTOOLS = " \
    i2c-tools \
"

RDEPENDS_${PN} = " \
    ${TSTOOLS} \
    ${SERBUSTOOLS} \
    webmin \
"
