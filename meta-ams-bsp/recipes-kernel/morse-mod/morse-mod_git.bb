SUMMARY = "Kernel module - in rust for morse code LED output"
LICENSE = "GPLv2"
LIC_FILES_CHKSUM = "file://LICENSE;md5=b234ee4d69f5fce4486a80fdaf4a4263"


inherit gitpkgv

SRC_URI = "git://github.com/almedso/kernel-module-rust-morse.git;protocol=http;branch=master"
# SRC_URI[sha256sum] = "9cdeded70a6b2f1c09e14c904e7cb4d9ea83a8c2f89099f657eed003e64cb9c9"
SRCREV = "${AUTOREV}"

S = "${WORKDIR}/git"

inherit module rust rust-target-config

# DEPENDS += "rust-native"

PR = "r2"
PV = "0.1"

