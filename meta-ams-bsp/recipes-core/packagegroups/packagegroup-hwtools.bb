DESCRIPTION = "Hardware development tools"
LICENSE = "MIT"
PR = "r1"

PACKAGE_ARCH = "${MACHINE_ARCH}"

inherit packagegroup

RDEPENDS:${PN} = " \
    bumprts \
    devmem2 \
    dosfstools \
    dtc \
    e2fsprogs-mke2fs \
    e2fsprogs-tune2fs \
    e2fsprogs-resize2fs \
    ethtool \
    fbtest \
    i2c-tools \
    iproute2 \
    iw \
    libdrm-tests \
    libgpiod \
    libgpiod-tools \
    lmsensors-fancontrol \
    memedit \
    memtester \
    mmc-utils \
    mtd-utils \
    mtd-utils-ubifs \
    mtd-utils-misc \
    nfs-utils-client \
    parted \
    rs485test \
    serialcheck \
    serial-test \
    usbutils \
    util-linux-blkdiscard \
    ${@bb.utils.contains("MACHINE_FEATURES", "can", "can-utils can-utils-cantest libsocketcan", "", d)} \
    ${@bb.utils.contains("MACHINE_FEATURES", "pci", "pciutils", "", d)} \
    ${@bb.utils.contains("MACHINE_FEATURES", "resistivetouch", "tslib-conf tslib-calibrate tslib-tests", "", d)} \
"

# Those packages depend on a specific SoC architecture
RDEPENDS:${PN}:append:arm = " arm-memspeed"
