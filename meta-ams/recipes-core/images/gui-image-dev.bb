UMMARY = "AMS gui image"
DESCRIPTION = "A-l M-ed S-o weston image"
LICENSE = "MIT"

require include/ams-image-dev.inc

PR = "1.2"

# overwrite image name - to find it in tmp* tree
export IMAGE_BASENAME = "gui-image-dev"


IMAGE_INSTALL += " \
    packagegroup-ams-tools \
    packagegroup-gui \
"

## Select Image Features
IMAGE_FEATURES += " \
    package-management \
    splash \
    tools-debug \
    tools-testapps \
    hwcodecs \
    ${@bb.utils.contains('DISTRO_FEATURES', 'wayland', 'weston', \
       bb.utils.contains('DISTRO_FEATURES',     'x11', 'x11-base x11-sato', \
                                                       '', d), d)} \
"
G2D_SAMPLES              = ""
G2D_SAMPLES:imxgpu2d     = "imx-g2d-samples"
G2D_SAMPLES:mx93-nxp-bsp = "imx-g2d-samples"

CORE_IMAGE_EXTRA_INSTALL += " \
    packagegroup-core-full-cmdline \
    packagegroup-tools-bluetooth \
    packagegroup-fsl-tools-audio \
    packagegroup-fsl-tools-gpu \
    packagegroup-fsl-tools-gpu-external \
    packagegroup-fsl-tools-testapps \
    packagegroup-fsl-tools-benchmark \
    packagegroup-imx-isp \
    packagegroup-imx-security \
    firmwared \
    ${@bb.utils.contains('DISTRO_FEATURES', 'x11 wayland', 'weston-xwayland xterm', '', d)} \
    ${G2D_SAMPLES} \
"
