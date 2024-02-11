# require recipes-devtools/gcc/gcc-${PV}.inc
# require recipes-devtools/gcc/gcc-source.inc

PV = "11.3.0"
BINV = "13.4.0"

LICENSE = "GPL-3.0-with-GCC-exception & GPL-3.0-only"

LIC_FILES_CHKSUM = "\
    file://COPYING;md5=59530bdf33659b29e73d4adb9f9f6552 \
    file://COPYING3;md5=d32239bcb673463ab874e80d47fae504 \
    file://COPYING3.LIB;md5=6a6a8e020838b23406c81b19c1d46df6 \
    file://COPYING.LIB;md5=2d5025d4aa3495befef8f17206a5b0a1 \
    file://COPYING.RUNTIME;md5=fe60d87048567d4fe8c8a0ed2448bcc8 \
"


BASEURI ?= "${GNU_MIRROR}/gcc/gcc-${PV}/gcc-${PV}.tar.xz \
           "
SRC_URI = "\
           ${BASEURI} \
           file://0001-gcc-4.3.1-ARCH_FLAGS_FOR_TARGET.patch \
           file://0002-gcc-poison-system-directories.patch \
           file://0003-64-bit-multilib-hack.patch \
           file://0004-Use-the-defaults.h-in-B-instead-of-S-and-t-oe-in-B.patch \
           file://0005-cpp-honor-sysroot.patch \
           file://0006-Define-GLIBC_DYNAMIC_LINKER-and-UCLIBC_DYNAMIC_LINKE.patch \
           file://0007-gcc-Fix-argument-list-too-long-error.patch \
           file://0008-libtool.patch \
           file://0009-gcc-armv4-pass-fix-v4bx-to-linker-to-support-EABI.patch \
           file://0010-Use-the-multilib-config-files-from-B-instead-of-usin.patch \
           file://0011-Avoid-using-libdir-from-.la-which-usually-points-to-.patch \
           file://0012-Ensure-target-gcc-headers-can-be-included.patch \
           file://0013-Don-t-search-host-directory-during-relink-if-inst_pr.patch \
           file://0014-libcc1-fix-libcc1-s-install-path-and-rpath.patch \
           file://0015-Makefile.in-Ensure-build-CPP-CPPFLAGS-is-used-for-bu.patch \
           file://0016-If-CXXFLAGS-contains-something-unsupported-by-the-bu.patch \
           file://0017-handle-sysroot-support-for-nativesdk-gcc.patch \
           file://0018-Search-target-sysroot-gcc-version-specific-dirs-with.patch \
           file://0020-Add-ssp_nonshared-to-link-commandline-for-musl-targe.patch \
           file://0021-Link-libgcc-using-LDFLAGS-not-just-SHLIB_LDFLAGS.patch \
           file://0022-sync-gcc-stddef.h-with-musl.patch \
           file://0023-Re-introduce-spe-commandline-options.patch \
           file://0024-libgcc_s-Use-alias-for-__cpu_indicator_init-instead-.patch \
           file://0025-gentypes-genmodes-Do-not-use-__LINE__-for-maintainin.patch \
           file://0026-mingw32-Enable-operation_not_supported.patch \
           file://0027-libatomic-Do-not-enforce-march-on-aarch64.patch \
           file://0028-debug-101473-apply-debug-prefix-maps-before-checksum.patch \
           file://0029-Fix-install-path-of-linux64.h.patch \
           file://0030-rust-recursion-limit.patch \
           file://0001-CVE-2021-42574.patch \
           file://0002-CVE-2021-42574.patch \
           file://0003-CVE-2021-42574.patch \
           file://0004-CVE-2021-42574.patch \
           file://0001-CVE-2021-46195.patch \
	   file://0001-aarch64-Update-Neoverse-N2-core-defini.patch \
	   file://0002-aarch64-add-armv9-a-to-march.patch \
	   file://0003-aarch64-Enable-FP16-feature-by-default-for-Armv9.patch \
	   file://0004-arm-add-armv9-a-architecture-to-march.patch \
	   file://CVE-2023-4039.patch \
"

SRC_URI[sha256sum] = "3f2db222b007e8a4a23cd5ba56726ef08e8b1f1eb2055ee72c1402cea73a8dd9"

EXCLUDE_FROM_WORLD = "1"
