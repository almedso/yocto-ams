SUMMMARY = "AMS Base System tools-debug (image feature)"
PR_append = ".ams.1"


EXTRAS = "\
    mtd-utils \
    mtd-utils-ubifs \
    udev-extraconf \
"

RDEPENDS_${PN}_append = " \
    curl \
    devmem2 \
    git \
    ethtool \
    htop \
    i2c-tools \
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
