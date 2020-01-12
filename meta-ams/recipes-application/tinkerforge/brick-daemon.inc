SUMMARY = "Brick Daemon"
DESCRIPTION = "Tinkerforge Brick Daemon"

HOMEPAGE = "http://gitlab.com/Tinkerforge/brickd"

# SECTION = "unknown/unknown"

LICENSE = "GPL-2"
LIC_FILES_CHKSUM = " \
   file://${WORKDIR}/git/license.txt;md5=b234ee4d69f5fce4486a80fdaf4a4263 \
   file://${WORKDIR}/git/src/daemonlib/license.txt;md5=b234ee4d69f5fce4486a80fdaf4a4263 \
   "

INC_PR = "r2"

# There are two sources in different git repos that need to be made available into one
# source area
# They are differently tagged as well.

inherit gitpkgv systemd

FILES_${PN}_append = "\
   /lib/systemd/system/brickd.service \
   /lib/systemd/system/brickd-resume.service \
"

EXTRA_OEMAKE = " \
   'PLATFORM=Linux' \
   '-I${S}/../daemonlib' \
   'BUILDDIR=${S}' 'DESTDIR=${D}' 'localstatedir=/var' \
   "

do_install () {
   oe_runmake install
   # run directory exists in the distribution already and
   # is also created by make install. This would be an QA issue
   # if not removed
   rmdir ${D}/var/run
}

SYSTEMD_SERVICE_${PN} = "brickd.service"

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