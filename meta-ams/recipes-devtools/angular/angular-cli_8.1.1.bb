
SUMMARY = "Command line interface for the Angular (CLI) build system"
HOMEPAGE = "https://github.com/angular/angular-cli"
SECTION = "js/devel"
LICENSE = "MIT"

LIC_FILES_CHKSUM = "file://LICENSE;md5=dc2a37e472c366af2a7b8bd0f2ba5af4"

PACKAGE_ARCH = "all"

SRC_URI = "https://github.com/angular/angular-cli/archive/v${PV}.tar.gz"
SRC_URI[md5sum] = "a539feb2d531771e79a1ac29c21d49e3"
SRC_URI[sha256sum] = "9461737689323f6740766f4a690b7570812b1eb78abf471f7a21c74b4c6f4d21"

INSANE_SKIP_${PN} += "file-rdeps"

# angular8 Requires minimum node version of 8.9 - 10.16.0 is the latest stable version
# requires npm 6.1 version (for proper install) - which comes along with 10.7.0 node version
PREFERRED_VERSION_nodejs = "10.7.0"


# npm > version 5 is less lazy - a none-existing node_modules folder will be created
NPM_INSTALL_FLAGS_${PN} += " --force"

inherit npm-install-global

BBCLASSEXTEND = "native nativesdk"