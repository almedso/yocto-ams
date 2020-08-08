SUMMARY = "AMS development image"
DESCRIPTION = "A-l M-ed S-o development image"
LICENSE = "MIT"

require include/ams-image-dev.inc

PR = "1.0.${PR_INC}"

# overwrite image name - to find it in tmp* tree
export IMAGE_BASENAME = "ams-image-ptest"

# IMAGE_FEATURES += "ptest-pkgs"

IMAGE_INSTALL_append = " \
    packagegroup-ams-tools \
    localedef \
    glibc-utils \
    e2fsprogs-ptest \
    zlib-ptest \
    "

# Additional image linguas are required if ptest shall work
# for glib-2.0-ptest
# IMAGE_LINGUAS += " tr-tr, lt-lt, ja-jp.euc-jp, fa-ir, ru-ru, de-de, hr-hr, el-gr, fr-fr, es-es, en-gb"
# for bash-ptest
# IMAGE_LINGUAS += " fr-fr, de-de"