DESCRIPTION = "Flask WTForms"
LICENSE = "BSD"
LIC_FILES_CHKSUM = "file://LICENSE;md5=d1eb373eabc6d20a5c4f2a2214f42b71"

PR = "r0"

SRC_URI = "https://pypi.python.org/packages/source/F/Flask-WTF/Flask-WTF-${PV}.tar.gz"
SRC_URI[md5sum] = "46eea9bad467ddc464658805ce200870"
SRC_URI[sha256sum] = "2f53a4b314ec26824d0b70f0766b7dd74c6df77bcf8b64de88e1354bc900874b"

S = "${WORKDIR}/Flask-WTF-${PV}"

inherit setuptools

RDEPENDS_${PN} += "python-flask python-wtforms (>= 2.0.2)"
