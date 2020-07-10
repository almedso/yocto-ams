SUMMARY = "WSGI HTTP Server for UNIX"
DESCRIPTION = "\
  Gunicorn ‘Green Unicorn’ is a Python WSGI HTTP Server for UNIX. It’s \
  a pre-fork worker model ported from Ruby’s Unicorn project. The \
  Gunicorn server is broadly compatible with various web frameworks, \
  simply implemented, light on server resource usage, and fairly speedy. \
  "

LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://LICENSE;md5=f75f3fb94cdeab1d607e2adaa6077752"


PR = "r0"

SRC_URI = "https://pypi.python.org/packages/source/g/gunicorn/${PN}-${PV}.tar.gz"
SRC_URI[md5sum] = "f581937e9d8569ebd3fd6af1f9ab809f"
SRC_URI[sha256sum] = "fa2662097c66f920f53f70621c6c58ca4a3c4d3434205e608e121b5b3b71f4f3"

inherit setuptools3

RDEPENDS_${PN} += " \
    python-netclient \
    python-email \
    python-fcntl \
    python-resource \
    python-netserver \
    python-unixadmin \
    python-argparse \
    python-multiprocessing \
"

