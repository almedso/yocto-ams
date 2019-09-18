

PR_append = ".ams.1"

do_deploy_append() {

    bbnote "Append config file dependend on machine configuration"
    # Waveshare "R" 800x480" Resistive touch (http://www.waveshare.com/5inch-HDMI-LCD.htm)
    if [ "${WAVESHARE_800X480_RPI}" = "1" ]; then
        bbnote "Waveshare 5 inch 800x480 Resistive touch - is configured"

        echo "# Waveshare 800x480 5 inch resistive touch screen" >> ${DEPLOYDIR}/bcm2835-bootfiles/config.txt
        echo "max_usb_current=1" >> ${DEPLOYDIR}/bcm2835-bootfiles/config.txt
        echo "hdmi_group=2" >> ${DEPLOYDIR}/bcm2835-bootfiles/config.txt
        echo "hdmi_mode=1" >> ${DEPLOYDIR}/bcm2835-bootfiles/config.txt
        echo "hdmi_mode=87" >> ${DEPLOYDIR}/bcm2835-bootfiles/config.txt
        echo "hdmi_cvt 800 480 60 6 0 0 0" >> ${DEPLOYDIR}/bcm2835-bootfiles/config.txt
        echo "hdmi_drive=1" >> ${DEPLOYDIR}/bcm2835-bootfiles/config.txt

        echo "# Touchscreen controller settings" >> ${DEPLOYDIR}/bcm2835-bootfiles/config.txt
        echo "dtparam=spi=on" >> ${DEPLOYDIR}/bcm2835-bootfiles/config.txt
        echo "dtoverlay=ads7846,cs=1,penirq=25,penirq_pull=2,speed=50000,keep_vref_on=0,swapxy=0,pmax=255,xohms=150,xmin=200,xmax=3900,ymin=200,ymax=39001" >> ${DEPLOYDIR}/bcm2835-bootfiles/config.txt
    fi

}






