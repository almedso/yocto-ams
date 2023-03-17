DESCRIPTION = "Hardware development tools"
LICENSE = "MIT"

PACKAGE_ARCH = "${MACHINE_ARCH}"

inherit packagegroup

RDEPENDS_${PN} = " \
    usbutils \
    ethtool \
    i2c-tools \
    devmem2 \
    iw \
    bc \
    fbtest \
    libdrm-tests \
    memedit \
    memtester \
    e2fsprogs-mke2fs \
    dosfstools \
    e2fsprogs-tune2fs \
    e2fsprogs-resize2fs \
    parted \
    mmc-utils \
    util-linux-blkdiscard \
    mtd-utils \
    mtd-utils-ubifs \
    mtd-utils-misc \
    iproute2 \
    bumprts \
    serial-test \
    serialcheck \
    rs485test \
    libgpiod \
    libgpiod-tools \
    ${@bb.utils.contains("MACHINE_FEATURES", "can", "can-utils can-utils-cantest libsocketcan", "", d)} \
    ${@bb.utils.contains("MACHINE_FEATURES", "resistivetouch", "tslib-conf tslib-calibrate tslib-tests", "", d)} \
    ${@bb.utils.contains("MACHINE_FEATURES", "pci", "pciutils", "", d)} \
    lmsensors-fancontrol \
    nfs-utils-client \
    dtc \
    stressapptest \
"

# Those packages depend on a specific SoC architecture
RDEPENDS_${PN}:append:arm = " arm-memspeed"
RDEPENDS_${PN}:append:mx6 = " mmdc bbu"
RDEPENDS_${PN}:append:mx6ul = " mmdc bbu"
