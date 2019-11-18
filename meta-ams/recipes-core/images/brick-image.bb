SUMMARY = "Tinkerforge brick-daemon image"
DESCRIPTION = "Tinkerforge brick-daemon image - allow to work as hub for e.g. weather station"
LICENSE = "MIT"

require include/ams-image.inc

PR = "1.0.${PR_INC}"

# overwrite image name - to find it in tmp* tree
export IMAGE_BASENAME = "brick-image"

CORE_IMAGE_EXTRA_INSTALL += "\
  brick-daemon \
"
