SUMMARY = "weather data logger and service "
LICENSE = "MIT"

require include/ams-image-dev.inc

PR = "1"

# overwrite image name - to find it in tmp* tree
export IMAGE_BASENAME = "weather-image-dev"

IMAGE_INSTALL:append = " \
    packagegroup-ams-tools \
    waveshare-demo \
    packagegroup-weather \
    "
