

PR_append = ".ams.1"

FILESEXTRAPATHS_prepend := "${THISDIR}/files:"

SRC_URI += " file://ws800x480.edid"

FILES_${PN}_append = " boot/ws800x480.edid"

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

        echo "edid_content_type=0" >> ${DEPLOYDIR}/bcm2835-bootfiles/config.txt
        echo "hdmi_edid_file=1" >> ${DEPLOYDIR}/bcm2835-bootfiles/config.txt
        echo "hdmi_edid_filename=ws800x480.edid" >> ${DEPLOYDIR}/bcm2835-bootfiles/config.txt


        echo "" >> ${DEPLOYDIR}/bcm2835-bootfiles/config.txt
        echo "# Touchscreen controller settings for resistive touch" >> ${DEPLOYDIR}/bcm2835-bootfiles/config.txt
        echo "dtparam=spi=on" >> ${DEPLOYDIR}/bcm2835-bootfiles/config.txt
        echo "dtoverlay=ads7846,cs=1,penirq=25,penirq_pull=2,speed=50000,keep_vref_on=0,swapxy=0,pmax=255,xohms=150,xmin=200,xmax=3900,ymin=200,ymax=39001" >> ${DEPLOYDIR}/bcm2835-bootfiles/config.txt

        echo "" >> ${DEPLOYDIR}/bcm2835-bootfiles/config.txt
    fi

    install -d ${D}/boot/xdg/weston
    install -m 0644 ${WORKDIR}/ws800x480.edid ${D}/boot


}






