SUMMARY = "python3 library for parsing dates and time"
DESCRIPTION = "Library for parsing the following: \
  - Parse a time, get a datetime.time \
  - Parse a date, get a datetime.date \
  - Parse a datetime, get a datetime.datetime \
  - Parse a duration, get a datetime.timedelta \
  - Parse an interval, get a tuple of dates or datetimes \
  - Parse a repeating interval, get a date or datetime generator."
HOMEPAGE = "https://bitbucket.org/nielsenb/aniso8601"

SUMMARY = "Pure pythonic ISO8601 date / time functionality"
DESCRIPTION = "\
Pure pythonic ISO8601 date / time functionality \
"
HOMEPAGE = "https://github.com/flask-restful/flask-restful"
LICENSE = "Closed"
LICENSE = "BSD-3-Clause"

LIC_FILES_CHKSUM = "file://LICENSE;md5=bf2bdb115b4d685026985cc189ca5375"

SRC_URI[md5sum] = "2d5fc0461004569dff1acf2c5508da2c"
SRC_URI[sha256sum] = "b8a6a9b24611fc50cf2d9b45d371bfdc4fd0581d1cc52254f5502130a776d4af"

inherit pypi

PYPI_PACKAGE = "aniso8601"
