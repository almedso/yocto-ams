SUMMARY = "Docker Engine Image"
DESCRIPTION = "Docker Engie Image"
LICENSE = "MIT"

require include/ams-image.inc

PR = "1.1"

# overwrite image name - to find it in tmp* tree
export IMAGE_BASENAME = "docker-engine-image"

IMAGE_INSTALL:append = " \
  docker-ce \
  python3-docker-compose \
"
