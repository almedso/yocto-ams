DESCRIPTION = "Userland software services for bsp development"
LICENSE = "MIT"
PR = "r1"

inherit packagegroup

RDEPENDS:${PN} = " \
    bc \
    crda \
    gdbserver \
    git \
    jq \
    openssh \
    opkg \
    python3-pip \
    rsync \
    strace \
    tmux \
    vim \
"
