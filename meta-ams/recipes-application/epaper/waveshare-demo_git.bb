# Copyright (C) 2023 Volker Kempert <volker.kempert@almedso.de>
# Released under the MIT license (see COPYING.MIT for the terms)

SUMMARY = "2.7 Inch ePaper 176x264 (4 greyscale)  waveshare demo application"
HOMEPAGE = "http://www.waveshare.com/product/displays/e-paper/2.7inch-e-paper-hat.htm"
LICENSE = "MIT"

RDEPENDS:${PN}

inherit setuptools

S = ${WORKDIR}/git/RaspberryPI_JetsonNano/python

SRC_URI = "https://github.com/waveshare/e-Paper.git"
