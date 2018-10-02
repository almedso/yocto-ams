SUMMARY = "A console-only image that fully supports the target device \
hardware for development provided by iot."

require iot-image-base.bb

IMAGE_FEATURES += " \
    debug-tweaks \
    dev-pkgs \
    eclipse-debug \
    iot-tools-debug \
    iot-tools-profile \
    iot-tools-sdk \
    iot-tools-testapps \
    package-management \
    ssh-server-openssh \
"
