SUMMMARY = "Packagegroup Imaging"
LICENSE = "MIT"
PR = "r1"

inherit packagegroup

RDEPENDS:${PN} = " \
    opencv \
    libopencv-core \
    libopencv-imgproc \
    v4l-utils \
    python3-opencv \
"

RDEPENDS:${PN}-dev = " \
"

