#
# POSTINSTALLATION functions
#

override_sshd_setting() {
    setting="$1"
    value="$2"

    sshd_config="${IMAGE_ROOTFS}${sysconfdir}/ssh/sshd_config"

    if grep -q "$setting" "$sshd_config"; then
        # setting exists, replace with target value
        sed -i "s/^[#[:space:]]*${setting}.*/${setting} ${value}/" "$sshd_config"
    else
        # setting doesn't exist yet; specify explicitly (because we
        # don't know what the default is)
        echo "${setting} ${value}" >> "$sshd_config"
    fi
}

sshd_config_lockdown() {
    override_sshd_setting X11Forwarding no
    override_sshd_setting IgnoreRhosts  yes
    override_sshd_setting PermitEmptyPasswords yes
    override_sshd_setting PermitRootLogin yes
    override_sshd_setting MaxAuthTries 3
    override_sshd_setting PasswordAuthentication yes
    override_sshd_setting PubkeyAuthentication yes
}

# The SSH with public/private key pair is enabled in the bxl-insecure distributions for all images (including -dev images).
# To enable the SSH key access in luminos-insecure distros (like labuser-image) as before, the second entry it neccessary.
ROOTFS_POSTPROCESS_COMMAND += "\
    ${@bb.utils.contains("DISTRO_FEATURES", "ams-insecure", "", "sshd_config_lockdown; ", d)} \
    ${@bb.utils.contains("IMAGE_FEATURES", "debug-tweaks", "", "sshd_config_lockdown; ", d)} \
"

