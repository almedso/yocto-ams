SUMMMARY = "PLOS Development System"
LICENSE = "MIT"
PR = "r1"

inherit packagegroup

# For backwards compatibility after rename
RPROVIDES_packagegroup-plos-sdk = "packagegroup-plos-devel"
RREPLACES_packagegroup-plos-sdk = "packagegroup-plos-devel"
RCONFLICTS_packagegroup-plos-sdk = "packagegroup-plos-devel"

RDEPENDS_${PN} = " \
    bash \
    git \
    openssh-sftp-server \
    python-dbg \
    python-setuptools \
    python-virtualenv \
    vim \
    wget \
"

