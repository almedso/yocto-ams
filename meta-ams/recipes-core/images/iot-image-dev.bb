SUMMARY = "A console-only image that fully supports the target device \
hardware for development provided by iot."

require iot-image-base.bb
PR="1.${PR_INC}"

IMAGE_FEATURES += " \
    debug-tweaks \
    dev-pkgs \
    iot-tools-debug \
    iot-tools-profile \
    iot-tools-sdk \
    iot-tools-testapps \
"
