

PR_append = ".ams.1"

do_after_deploy() {

    # Waveshare "R" 800x480" Resistive touch (http://www.waveshare.com/5inch-HDMI-LCD.htm)
    if [ "${WAVESHARE_800X480_RPI}" = "1" ]; then
        echo "# Waveshare 800x480 5\" resistive touch screen" >> ${DEPLOYDIR}/bcm2835-bootfiles/config.txt
        echo "max_usb_current=1" >> ${DEPLOYDIR}/bcm2835-bootfiles/config.txt
        echo "hdmi_group=2" >> ${DEPLOYDIR}/bcm2835-bootfiles/config.txt
        echo "hdmi_mode=87" >> ${DEPLOYDIR}/bcm2835-bootfiles/config.txt
        echo "hdmi_cvt 800 480 60 6 0 0 0" >> ${DEPLOYDIR}/bcm2835-bootfiles/config.txt
        echo "hdmi_drive=1" >> ${DEPLOYDIR}/bcm2835-bootfiles/config.txt
    fi

}

addtask after_deploy after deploy
