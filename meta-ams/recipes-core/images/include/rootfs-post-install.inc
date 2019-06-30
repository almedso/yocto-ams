
# POSTINSTALLATION functions
#

write_build_info() {
    INFO_FILE="build-info"
    date_info=$(date "+%Y%m%d%H%M%S")
    mkdir -p ${D}${sysconfdir}
    echo "Build timestamp: ${date_info}" > ${IMAGE_ROOTFS}${sysconfdir}/${INFO_FILE}
    echo "Build host: ${HOSTNAME}" >> ${IMAGE_ROOTFS}${sysconfdir}/${INFO_FILE}
    echo "Target machine: ${MACHINE}" >>  ${IMAGE_ROOTFS}${sysconfdir}/${INFO_FILE}
    echo "Distro: ${DISTRO_NAME}@${DISTRO_VERSION}" >>  ${IMAGE_ROOTFS}${sysconfdir}/${INFO_FILE}
    echo "Image: ${IMAGE_BASENAME}" >>  ${IMAGE_ROOTFS}${sysconfdir}/${INFO_FILE}
    chmod 444 ${IMAGE_ROOTFS}${sysconfdir}/${INFO_FILE}
}


ROOTFS_POSTPROCESS_COMMAND += "write_build_info;"
