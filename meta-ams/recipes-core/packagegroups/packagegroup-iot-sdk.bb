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
    ${PYTHON_PN}-dbg \
    python-setuptools3 \
    ${PYTHON_PN}-virtualenv \
    vim \
    wget \
"

