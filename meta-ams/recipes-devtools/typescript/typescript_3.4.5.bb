
SUMMARY = "Typescript tanspiler"
HOMEPAGE = "https://www.typescriptlang.org/"
SECTION = "js/devel"
LICENSE = "APACHE2.0"

LIC_FILES_CHKSUM = "file://LICENSE;md5=2823b4b2f2e0f9bae5fa46f1f150c75a"

PACKAGE_ARCH = "all"

SRC_URI = "https://github.com/github.com/Microsoft/TypeScript/archive/v${PV}.tar.gz"
SRC_URI[md5sum] = "cf8f3c4d385fad98ffe0f073211fce7a"
SRC_URI[sha256sum] = "c95a8c2c59b8cfbe3d4d1092021d24287e9635e8f83aea3bfe83f053b37f49a8"

INSANE_SKIP_${PN} += "file-rdeps"

# angular8 Requires minimum node version of 8.9 - 10.16.0 is the latest stable version
PREFERRED_VERSION_nodejs = "10.16.0"


inherit npm-install-global

BBCLASSEXTEND = "native nativesdk"