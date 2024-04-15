SUMMARY = "Tinkerforge brick-daemon image"
DESCRIPTION = "Tinkerforge brick-daemon image - allow to work as hub for e.g. weather station"
LICENSE = "MIT"

require include/ams-image.inc

PR = "1.0"

# overwrite image name - to find it in tmp* tree
export IMAGE_BASENAME = "brick-image"

IMAGE_INSTALL:append = " \
  brick-daemon \
  influxdb \
"

NOT_INSTALLED = " \
  weather-station \
"
