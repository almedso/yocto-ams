DESCRIPTION = "Same image as gui-image-dev with Chromium browser added."
LICENSE = "MIT"

require gui-image-dev.bb

# overwrite image name - to find it in tmp* tree
export IMAGE_BASENAME = "browser-image-dev"

IMAGE_INSTALL:append = " chromium-ozone-wayland"

ROOTFS_POSTPROCESS_COMMAND:append = "install_chromium; "

install_chromium() {
    printf "\n[launcher]\nicon=/usr/share/icons/hicolor/24x24/apps/chromium.png\npath=/usr/sbin/runuser -l weston -c chromium" >> ${IMAGE_ROOTFS}${sysconfdir}/xdg/weston/weston.ini
}
