DESCRIPTION = "Userland software services for bsp development"
LICENSE = "MIT"
PR = "r1"

inherit packagegroup

RDEPENDS:${PN} = " \
    bc \
    crda \
    gdbserver \
    git \
    glibc-utils \
    jq \
    kbd \
    kbd-keymaps \
    localedef \
    openssh \
    opkg \
    python3-pip \
    rsync \
    strace \
    tmux \
    vim \
"
