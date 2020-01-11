
PR_append = ".ams.4"

FILESEXTRAPATHS_prepend := "${THISDIR}/files:"

SRC_URI += "file://ws800x480.edid"

# Raspberrypi 3 requires the specific name edid.data
# only raspberrypi 4 allows more
# https://www.raspberrypi.org/documentation/configuration/config-txt/video.md
FILES_${PN}_append = " bcm2835-bootfiles/edid.dat"

do_deploy_append() {
    # Waveshare "R" 800x480" Resistive touch (http://www.waveshare.com/5inch-HDMI-LCD.htm)
    if [ "${WAVESHARE_800X480_RPI}" = "1" ]; then
        install -d ${DEPLOYDIR}/${PN}
        install -m 0644 ${WORKDIR}/ws800x480.edid ${DEPLOYDIR}/${PN}/edid.dat
    fi
}
