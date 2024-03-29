# Auto-Generated by cargo-bitbake 0.3.16
#
inherit cargo

# If this is git based prefer versioned ones if they exist
# DEFAULT_PREFERENCE = "-1"

# how to get rpi-hwctl could be as easy as but default to a git checkout:
# SRC_URI += "crate://crates.io/rpi-hwctl/0.1.0"
SRC_URI += "git://git@github.com/almedso/rpi-hwctl.git;protocol=ssh;nobranch=1;branch=devel"
SRCREV = "43ef1b187957e5641c2f376a280cf4801d4e736e"
S = "${WORKDIR}/git"
CARGO_SRC_DIR = ""
PV:append = ".AUTOINC+43ef1b1879"

# please note if you have entries that do not begin with crate://
# you must change them to how that package can be fetched
SRC_URI += " \
    crate://crates.io/actix-codec/0.5.0 \
    crate://crates.io/actix-http/3.3.1 \
    crate://crates.io/actix-macros/0.2.3 \
    crate://crates.io/actix-router/0.5.1 \
    crate://crates.io/actix-rt/2.8.0 \
    crate://crates.io/actix-server/2.2.0 \
    crate://crates.io/actix-service/2.0.2 \
    crate://crates.io/actix-utils/3.0.1 \
    crate://crates.io/actix-web-codegen/4.2.0 \
    crate://crates.io/actix-web/4.3.1 \
    crate://crates.io/adler/1.0.2 \
    crate://crates.io/ahash/0.7.6 \
    crate://crates.io/ahash/0.8.3 \
    crate://crates.io/aho-corasick/0.7.20 \
    crate://crates.io/alloc-no-stdlib/2.0.4 \
    crate://crates.io/alloc-stdlib/0.2.2 \
    crate://crates.io/autocfg/1.1.0 \
    crate://crates.io/base64/0.21.0 \
    crate://crates.io/bitflags/1.3.2 \
    crate://crates.io/block-buffer/0.10.4 \
    crate://crates.io/bmp085/0.1.2 \
    crate://crates.io/brotli-decompressor/2.3.4 \
    crate://crates.io/brotli/3.3.4 \
    crate://crates.io/bytecount/0.6.3 \
    crate://crates.io/byteorder/1.4.3 \
    crate://crates.io/bytes/0.4.12 \
    crate://crates.io/bytes/1.4.0 \
    crate://crates.io/bytestring/1.3.0 \
    crate://crates.io/camino/1.1.4 \
    crate://crates.io/cargo-platform/0.1.2 \
    crate://crates.io/cargo_metadata/0.14.2 \
    crate://crates.io/cast/0.2.7 \
    crate://crates.io/cc/1.0.79 \
    crate://crates.io/cfg-if/0.1.10 \
    crate://crates.io/cfg-if/1.0.0 \
    crate://crates.io/convert_case/0.4.0 \
    crate://crates.io/cookie/0.16.2 \
    crate://crates.io/cpufeatures/0.2.6 \
    crate://crates.io/crc32fast/1.3.2 \
    crate://crates.io/crypto-common/0.1.6 \
    crate://crates.io/derive_more/0.99.17 \
    crate://crates.io/digest/0.10.6 \
    crate://crates.io/embedded-graphics/0.6.2 \
    crate://crates.io/embedded-hal/0.2.7 \
    crate://crates.io/encoding_rs/0.8.32 \
    crate://crates.io/env_logger/0.10.0 \
    crate://crates.io/errno-dragonfly/0.1.2 \
    crate://crates.io/errno/0.2.8 \
    crate://crates.io/error-chain/0.12.4 \
    crate://crates.io/fastrand/1.9.0 \
    crate://crates.io/flate2/1.0.25 \
    crate://crates.io/fnv/1.0.7 \
    crate://crates.io/form_urlencoded/1.1.0 \
    crate://crates.io/futures-core/0.3.27 \
    crate://crates.io/futures-sink/0.3.27 \
    crate://crates.io/futures-task/0.3.27 \
    crate://crates.io/futures-util/0.3.27 \
    crate://crates.io/gcc/0.3.55 \
    crate://crates.io/generic-array/0.14.6 \
    crate://crates.io/getrandom/0.2.8 \
    crate://crates.io/glob/0.3.1 \
    crate://crates.io/h2/0.3.16 \
    crate://crates.io/hashbrown/0.12.3 \
    crate://crates.io/hermit-abi/0.2.6 \
    crate://crates.io/hermit-abi/0.3.1 \
    crate://crates.io/http/0.2.9 \
    crate://crates.io/httparse/1.8.0 \
    crate://crates.io/httpdate/1.0.2 \
    crate://crates.io/humantime/2.1.0 \
    crate://crates.io/i2cdev-bmp180/0.1.0 \
    crate://crates.io/i2cdev/0.3.2 \
    crate://crates.io/i2cdev/0.4.4 \
    crate://crates.io/i2cdev/0.5.1 \
    crate://crates.io/i2csensors/0.1.3 \
    crate://crates.io/idna/0.3.0 \
    crate://crates.io/indexmap/1.9.3 \
    crate://crates.io/instant/0.1.12 \
    crate://crates.io/io-lifetimes/1.0.9 \
    crate://crates.io/ioctl-rs/0.1.6 \
    crate://crates.io/iovec/0.1.4 \
    crate://crates.io/is-terminal/0.4.5 \
    crate://crates.io/itoa/1.0.6 \
    crate://crates.io/jobserver/0.1.26 \
    crate://crates.io/language-tags/0.3.2 \
    crate://crates.io/libc/0.2.140 \
    crate://crates.io/linux-embedded-hal/0.3.0 \
    crate://crates.io/linux-raw-sys/0.1.4 \
    crate://crates.io/local-channel/0.1.3 \
    crate://crates.io/local-waker/0.1.3 \
    crate://crates.io/lock_api/0.4.9 \
    crate://crates.io/log/0.4.17 \
    crate://crates.io/memchr/2.5.0 \
    crate://crates.io/memoffset/0.6.5 \
    crate://crates.io/mime/0.3.17 \
    crate://crates.io/miniz_oxide/0.6.2 \
    crate://crates.io/mio/0.8.6 \
    crate://crates.io/nb/0.1.3 \
    crate://crates.io/nb/1.1.0 \
    crate://crates.io/nix/0.10.0 \
    crate://crates.io/nix/0.14.1 \
    crate://crates.io/nix/0.17.0 \
    crate://crates.io/nix/0.23.2 \
    crate://crates.io/num_cpus/1.15.0 \
    crate://crates.io/once_cell/1.17.1 \
    crate://crates.io/parking_lot/0.12.1 \
    crate://crates.io/parking_lot_core/0.9.7 \
    crate://crates.io/paste/1.0.12 \
    crate://crates.io/pcf857x/0.4.0 \
    crate://crates.io/percent-encoding/2.2.0 \
    crate://crates.io/pin-project-lite/0.2.9 \
    crate://crates.io/pin-utils/0.1.0 \
    crate://crates.io/pkg-config/0.3.26 \
    crate://crates.io/port-expander/0.2.1 \
    crate://crates.io/ppv-lite86/0.2.17 \
    crate://crates.io/proc-macro2/1.0.53 \
    crate://crates.io/pulldown-cmark/0.9.2 \
    crate://crates.io/quote/1.0.26 \
    crate://crates.io/rand/0.8.5 \
    crate://crates.io/rand_chacha/0.3.1 \
    crate://crates.io/rand_core/0.6.4 \
    crate://crates.io/redox_syscall/0.2.16 \
    crate://crates.io/regex-syntax/0.6.29 \
    crate://crates.io/regex/1.7.3 \
    crate://crates.io/rustc_version/0.4.0 \
    crate://crates.io/rustix/0.36.11 \
    crate://crates.io/ryu/1.0.13 \
    crate://crates.io/same-file/1.0.6 \
    crate://crates.io/scopeguard/1.1.0 \
    crate://crates.io/semver/1.0.17 \
    crate://crates.io/serde/1.0.158 \
    crate://crates.io/serde_derive/1.0.158 \
    crate://crates.io/serde_json/1.0.94 \
    crate://crates.io/serde_urlencoded/0.7.1 \
    crate://crates.io/serial-core/0.4.0 \
    crate://crates.io/serial-unix/0.4.0 \
    crate://crates.io/sha1/0.10.5 \
    crate://crates.io/shared-bus/0.2.5 \
    crate://crates.io/si7021/0.2.0 \
    crate://crates.io/signal-hook-registry/1.4.1 \
    crate://crates.io/skeptic/0.13.7 \
    crate://crates.io/slab/0.4.8 \
    crate://crates.io/smallvec/1.10.0 \
    crate://crates.io/socket2/0.4.9 \
    crate://crates.io/spidev/0.4.1 \
    crate://crates.io/ssd1306/0.3.1 \
    crate://crates.io/syn/1.0.109 \
    crate://crates.io/syn/2.0.10 \
    crate://crates.io/sysfs_gpio/0.5.4 \
    crate://crates.io/sysfs_gpio/0.6.1 \
    crate://crates.io/tempfile/3.4.0 \
    crate://crates.io/termcolor/1.2.0 \
    crate://crates.io/termios/0.2.2 \
    crate://crates.io/time-core/0.1.0 \
    crate://crates.io/time-macros/0.2.8 \
    crate://crates.io/time/0.3.20 \
    crate://crates.io/tinyvec/1.6.0 \
    crate://crates.io/tinyvec_macros/0.1.1 \
    crate://crates.io/tokio-macros/1.8.2 \
    crate://crates.io/tokio-util/0.7.7 \
    crate://crates.io/tokio/1.26.0 \
    crate://crates.io/tracing-core/0.1.30 \
    crate://crates.io/tracing/0.1.37 \
    crate://crates.io/typenum/1.16.0 \
    crate://crates.io/unicase/2.6.0 \
    crate://crates.io/unicode-bidi/0.3.13 \
    crate://crates.io/unicode-ident/1.0.8 \
    crate://crates.io/unicode-normalization/0.1.22 \
    crate://crates.io/url/2.3.1 \
    crate://crates.io/version_check/0.9.4 \
    crate://crates.io/void/1.0.2 \
    crate://crates.io/walkdir/2.3.3 \
    crate://crates.io/wasi/0.11.0+wasi-snapshot-preview1 \
    crate://crates.io/winapi-i686-pc-windows-gnu/0.4.0 \
    crate://crates.io/winapi-util/0.1.5 \
    crate://crates.io/winapi-x86_64-pc-windows-gnu/0.4.0 \
    crate://crates.io/winapi/0.3.9 \
    crate://crates.io/windows-sys/0.42.0 \
    crate://crates.io/windows-sys/0.45.0 \
    crate://crates.io/windows-targets/0.42.2 \
    crate://crates.io/windows_aarch64_gnullvm/0.42.2 \
    crate://crates.io/windows_aarch64_msvc/0.42.2 \
    crate://crates.io/windows_i686_gnu/0.42.2 \
    crate://crates.io/windows_i686_msvc/0.42.2 \
    crate://crates.io/windows_x86_64_gnu/0.42.2 \
    crate://crates.io/windows_x86_64_gnullvm/0.42.2 \
    crate://crates.io/windows_x86_64_msvc/0.42.2 \
    crate://crates.io/zstd-safe/6.0.4+zstd.1.5.4 \
    crate://crates.io/zstd-sys/2.0.7+zstd.1.5.4 \
    crate://crates.io/zstd/0.12.3+zstd.1.5.2 \
"



# # FIXME: update generateme with the real MD5 of the license file
# # Fixed in rpi-hwctl.inc
# LIC_FILES_CHKSUM = " \
#     file://MIT;md5=generateme \
# "

SUMMARY = "RaspberryPy with Explorer700 board hardware exploration"
HOMEPAGE = "https://github.com/almedso/rpi-hwctl"
LICENSE = "MIT"

# includes this file if it exists but does not fail
# this is useful for anything you may want to override from
# what cargo-bitbake generates.
include rpi-hwctl-${PV}.inc
include rpi-hwctl.inc
