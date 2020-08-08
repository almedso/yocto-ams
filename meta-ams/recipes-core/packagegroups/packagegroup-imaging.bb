SUMMMARY = "Packagegroup Imaging"
LICENSE = "MIT"
PR = "r1"

inherit packagegroup

RDEPENDS_${PN} = " \
    opencv \
    libopencv-core \
    libopencv-imgproc \
    v4l-utils \
    python3-opencv \
"

RDEPENDS_${PN}-dev = " \
"

