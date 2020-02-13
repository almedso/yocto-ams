# See settings from
# https://doc.qt.io/qt-5/embedded-linux.html

# Add fonts path to prevent warnings
export QT_QPA_FONTDIR=/usr/share/fonts/truetype

# wayland/weston specific settings
export QT_QPA_PLATFORM=wayland
export XDG_RUNTIME_DIR=/run/user/0/wayland-0
