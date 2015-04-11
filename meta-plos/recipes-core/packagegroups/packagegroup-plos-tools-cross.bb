SUMMMARY = "PLOS cross tools"
LICENSE = "MIT"
PR = "r1"

inherit packagegroup

RDEPENDS_${PN} = " \
	openssh-sftp-server \
	python-virtualenv \
	vim \
"

