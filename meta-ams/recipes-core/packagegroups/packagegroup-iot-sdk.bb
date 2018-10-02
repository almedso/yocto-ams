SUMMMARY = "IOT Development System"
LICENSE = "MIT"
PR = "r1"

inherit packagegroup

# For backwards compatibility after rename
RPROVIDES_packagegroup-iot-sdk = "packagegroup-iot-devel"
RREPLACES_packagegroup-iot-sdk = "packagegroup-iot-devel"
RCONFLICTS_packagegroup-iot-sdk = "packagegroup-iot-devel"

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

