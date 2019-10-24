SUMMARY = "Brick Daemon"
DESCRIPTION = "Tinkerforge Brick Daemon"

HOMEPAGE = "http://gitlab.com/Tinkerforge/brickd"

# SECTION = "unknown/unknown"

LICENSE = "GPL-2"
LIC_FILES_CHKSUM = " \
   file://${WORKDIR}/git/license.txt;md5=b234ee4d69f5fce4486a80fdaf4a4263 \
   file://${WORKDIR}/git/src/daemonlib/license.txt;md5=b234ee4d69f5fce4486a80fdaf4a4263 \
   "

INC_PR = "r0"

inherit gitpkgv systemd

FILES_${PN}_append = "\
   /lib/systemd/system/brickd.service \
   /lib/systemd/system/brickd-resume.service \
   /run \
"

EXTRA_OEMAKE = " \
   'PLATFORM=Linux' \
   '-I${S}/../daemonlib' \
   'BUILDDIR=${S}' 'DESTDIR=${D}' \
   "

do_install () {
   oe_runmake install
}

PARALLEL_MAKE = ""

BBCLASSEXTEND = "native"

# systemd provides udev - no need to add at all since we inherit systemd
DEPENDS = " \
   pkgconfig-native \
   libusb \
"

RDPENDS_${PN} = " \
   libusb \
"