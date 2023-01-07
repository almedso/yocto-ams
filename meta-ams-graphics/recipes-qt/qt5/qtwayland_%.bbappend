PR:append = ".ams.1"

# FIXME: This should not be necessary because removing x11 from distro
# features should also remove the package. But I had to remove it manually in
# order to successfully build qtwayland with eglfs enabled...
PACKAGECONFIG:remove = " xcomposite-glx"
