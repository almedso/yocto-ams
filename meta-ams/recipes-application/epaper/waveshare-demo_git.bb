# Copyright (C) 2023 Volker Kempert <volker.kempert@almedso.de>
# Released under the MIT license (see COPYING.MIT for the terms)

SUMMARY = "2.7 Inch ePaper 176x264 (4 greyscale)  waveshare demo application"
HOMEPAGE = "http://www.waveshare.com/product/displays/e-paper/2.7inch-e-paper-hat.htm"

LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://${COREBASE}/LICENSE.MIT;md5=030cb33d2af49ccebca74d0588b84a21 \
                    file://${COREBASE}/meta/COPYING.MIT;md5=3da9cfbcb788c80a0384361b4de20420"

INC_PR = "r0"

inherit gitpkgv setuptools3

# PREFERED_VERSION_python = "3.5%"

RDEPENDS:${PN} += " \
        rpi-gpio \
        ${PYTHON_PN}-numpy \
        ${PYTHON_PN}-pillow \
"

PV = "0.1+git${SRCPV}"
PKGV = "0.1+git${GITPKGV}"
PR = "${INC_PR}.1"

SRC_URI = "git://github.com/waveshare/e-Paper.git;protocol=http;branch=master"
# SRC_URI[sha256sum] = "9cdeded70a6b2f1c09e14c904e7cb4d9ea83a8c2f89099f657eed003e64cb9c9"

SRCREV = "${AUTOREV}"
S = "${WORKDIR}/git/RaspberryPi_JetsonNano/python"
