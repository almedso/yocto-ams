DESCRIPTION = "Userland software services for bsp development"
LICENSE = "MIT"

PACKAGE_ARCH = "${MACHINE_ARCH}"

inherit packagegroup

RDEPENDS_${PN} = " \
    crda \
    gdbserver \
    git \
    htop \
    kbd \
    kbd-keymaps \
    openssh \
    openssh-sftp-server \
    rsync \
    strace \
    tmux \
    vim \
"
