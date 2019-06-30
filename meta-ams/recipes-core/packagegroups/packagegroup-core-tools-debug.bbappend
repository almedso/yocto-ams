SUMMMARY = "AMS Base System tools-debug (image feature)"
LICENSE = "CLOSED"
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
    i2c-tools \
    openssh-sftp-server \
    parted \
    setserial \
    socat \
    strace \
    tcpdump \
    vim \
    wget \
    wireshark \
    ${EXTRAS} \
    "