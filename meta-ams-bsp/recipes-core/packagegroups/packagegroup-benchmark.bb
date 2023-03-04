DESCRIPTION = "Benchmark tools used on Phytec boards"
LICENSE = "MIT"

inherit packagegroup

RDEPENDS_${PN} = " \
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
