SUMMARY = "WSGI HTTP Server for UNIX"
DESCRIPTION = "\
  Gunicorn ‘Green Unicorn’ is a Python WSGI HTTP Server for UNIX. It’s \
  a pre-fork worker model ported from Ruby’s Unicorn project. The \
  Gunicorn server is broadly compatible with various web frameworks, \
  simply implemented, light on server resource usage, and fairly speedy. \
  "

LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://LICENSE;md5=745a2e1156687fbf695fa81a971f82d1"


PR = "r0"

SRC_URI = "https://pypi.python.org/packages/source/g/gunicorn/${PN}-${PV}.tar.gz"
SRC_URI[md5sum] = "faa3e80661efd67e5e06bba32699af20"
SRC_URI[sha256sum] = "8bc835082882ad9a012cd790c460011e4d96bf3512d98a04d3dabbe45393a089"

inherit setuptools

