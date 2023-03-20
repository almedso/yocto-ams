DESCRIPTION = "Benchmark tools used for benchmarking"
LICENSE = "MIT"
PR = "r1"

inherit packagegroup

RDEPENDS:${PN} = " \
    bonnie++ \
    hdparm \
    iozone3 \
    iperf3 \
    lmbench \
    rt-tests \
    evtest \
    perf \
    stress-ng \
    ${@bb.utils.contains("DISTRO_FEATURES", "systemd", "systemd-analyze", "",d)} \
"

REMOVED_RDEPENDS = " \
    pmbw \
"
