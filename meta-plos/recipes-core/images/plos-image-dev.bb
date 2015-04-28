SUMMARY = "A console-only image that fully supports the target device \
hardware for development provided by plos."

require plos-image-base.bb

IMAGE_FEATURES += " \
    debug-tweaks \
    dev-pkgs \
    eclipse-debug \
    tools-debug \
    tools-profile \
    tools-sdk \
    tools-testapps \
    package-management \
    ssh-server-openssh \
"
