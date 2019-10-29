SUMMARY = "Docker CE Image"
DESCRIPTION = "Docker container engine image"
LICENSE = "MIT"

# see http://git.yoctoproject.org/cgit/cgit.cgi/meta-virtualization/tree/recipes-containers/docker/docker-ce_git.bb

require include/ams-image.inc

PR = "1.0.${PR_INC}"

# overwrite image name - to find it in tmp* tree
export IMAGE_BASENAME = "docker-ce-image"

IMAGE_FEATURES_append = " \
"
IMAGE_INSTALL_append = " \
    docker-ce \
    "