PR_append = ".ams.3"


do_deploy_append() {

    bbnote "Append config file dependend on machine configuration"

    # Waveshare "R" 800x480" Resistive touch (http://www.waveshare.com/5inch-HDMI-LCD.htm)
    if [ "${WAVESHARE_800X480_RPI}" = "1" ]; then

        echo "# Waveshare 800x480 5 inch resistive touch screen" >> ${DEPLOYDIR}/bcm2835-bootfiles/config.txt
        echo "hdmi_force_hotplug=1" >> ${DEPLOYDIR}/bcm2835-bootfiles/config.txt
        echo "max_usb_current=1" >> ${DEPLOYDIR}/bcm2835-bootfiles/config.txt
        echo "hdmi_group=2" >> ${DEPLOYDIR}/bcm2835-bootfiles/config.txt
        echo "hdmi_mode=1" >> ${DEPLOYDIR}/bcm2835-bootfiles/config.txt
        echo "hdmi_mode=87" >> ${DEPLOYDIR}/bcm2835-bootfiles/config.txt
        echo "hdmi_cvt=800 480 60 6 0 0 0" >> ${DEPLOYDIR}/bcm2835-bootfiles/config.txt
        echo "hdmi_drive=1" >> ${DEPLOYDIR}/bcm2835-bootfiles/config.txt
        echo "hdmi_ignore_edid=0xa5000080" >> ${DEPLOYDIR}/bcm2835-bootfiles/config.txt

        # remaining safe mode settings see
        # https://www.raspberrypi.org/documentation/configuration/config-txt/video.md
        echo "disable_overscan=0" >> ${DEPLOYDIR}/bcm2835-bootfiles/config.txt
        echo "overscan_left=24" >> ${DEPLOYDIR}/bcm2835-bootfiles/config.txt
        echo "overscan_right=24" >> ${DEPLOYDIR}/bcm2835-bootfiles/config.txt
        echo "overscan_top=24" >> ${DEPLOYDIR}/bcm2835-bootfiles/config.txt
        echo "overscan_bottom=24" >> ${DEPLOYDIR}/bcm2835-bootfiles/config.txt

        echo "edid_content_type=0" >> ${DEPLOYDIR}/bcm2835-bootfiles/config.txt
        echo "hdmi_edid_file=1" >> ${DEPLOYDIR}/bcm2835-bootfiles/config.txt


        echo "" >> ${DEPLOYDIR}/bcm2835-bootfiles/config.txt
        echo "# Touchscreen controller settings for resistive touch" >> ${DEPLOYDIR}/bcm2835-bootfiles/config.txt
        echo "dtparam=spi=on" >> ${DEPLOYDIR}/bcm2835-bootfiles/config.txt
        echo "dtoverlay=ads7846,cs=1,penirq=25,penirq_pull=2,speed=50000,keep_vref_on=0,swapxy=0,pmax=255,xohms=150,xmin=200,xmax=3900,ymin=200,ymax=39001" >> ${DEPLOYDIR}/bcm2835-bootfiles/config.txt

        echo "" >> ${DEPLOYDIR}/bcm2835-bootfiles/config.txt
        echo "# Audio settings taken over from Raspberrian for this display" >> ${DEPLOYDIR}/bcm2835-bootfiles/config.txt
        echo "dtparam=audis=on" >> ${DEPLOYDIR}/bcm2835-bootfiles/config.txt

        echo "" >> ${DEPLOYDIR}/bcm2835-bootfiles/config.txt
    fi

}
