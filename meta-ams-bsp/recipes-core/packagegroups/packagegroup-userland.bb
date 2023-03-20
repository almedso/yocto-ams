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
    kbd \
    kbd-keymaps \
    openssh \
    openssh-sftp-server \
    rsync \
    strace \
    tmux \
    vim \
"
