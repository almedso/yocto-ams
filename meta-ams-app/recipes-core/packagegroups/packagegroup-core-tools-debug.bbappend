SUMMMARY = "AMS Base System tools-debug (image feature)"
PR:append = ".ams.1"


EXTRAS = "\
    mtd-utils \
    mtd-utils-ubifs \
    udev-extraconf \
"

RDEPENDS:${PN}:append = " \
    curl \
    devmem2 \
    git \
    ethtool \
    htop \
    i2c-tools \
    libgpiod \
    minicom \
    parted \
    setserial \
    sshfs-fuse \
    socat \
    strace \
    tcpdump \
    tmux \
    vim \
    wget \
    ${DETAILED_EXTRAS} \
    ${EXTRAS} \
    "

DETAILED_EXTRAS = ""
