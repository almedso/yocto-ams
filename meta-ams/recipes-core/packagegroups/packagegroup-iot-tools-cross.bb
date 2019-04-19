SUMMMARY = "IOT cross tools"
LICENSE = "MIT"
PR = "r1"

inherit packagegroup

RDEPENDS_${PN} = " \
	openssh-sftp-server \
	${PYTHON_PN}-virtualenv \
	vim \
"

