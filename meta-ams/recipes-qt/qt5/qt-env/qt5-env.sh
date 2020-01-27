# See settings from
# https://doc.qt.io/qt-5/embedded-linux.html

# Add fonts path to prevent warnings
export QT_QPA_FONTDIR=/usr/share/fonts/truetype

# EGLS specific settings
export QT_QPA_PLATFORM=eglfs

# Size in pixel
export QT_QPA_EGLFS_WIDTH=800
export QT_QPA_EGLFS_HEIGHT=480

export QT_QPA_EGLFS_ROTATION=90
