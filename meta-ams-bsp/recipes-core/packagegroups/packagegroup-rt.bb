DESCRIPTION = "real-time test suite and tools appropriate for real-time use"
LICENSE = "MIT"
PR = "r1"

inherit packagegroup

RDEPENDS:${PN} = " \
    rt-tests \
    hwlatdetect \
"
