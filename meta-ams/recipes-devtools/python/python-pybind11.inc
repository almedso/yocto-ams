SUMMARY = "Seamless operability between C++11 and Python"
HOMEPAGE = "https://github.com/wjakob/pybind11"
LICENSE = "BSD-2-Clause"
LIC_FILES_CHKSUM = "file://LICENSE;md5=774f65abd8a7fe3124be2cdf766cd06f"

SRC_URI[md5sum] = "c87d54e1ca1d0982ad54af888c682d93"
SRC_URI[sha256sum] = "ab7e60a520fe6ae25eca939191bb2ac416cd58478ce754740238a8bf1af18934"

PYPI_PACKAGE := "pybind11"

inherit pypi

BBCLASSEXTEND = "native"
