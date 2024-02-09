PR:append = ".ams.4"

FILESEXTRAPATHS:prepend := "${THISDIR}/files:"

SRC_URI += "file://ws800x480.edid"

# Raspberrypi 3 requires the specific name edid.data
# only raspberrypi 4 allows more
# https://www.raspberrypi.org/documentation/configuration/config-txt/video.md
FILES:${PN}:append = " ${BOOTFILES_DIR_NAME}/edid.dat"

do_deploy:append() {

    bbnote "Append config file dependend on machine configuration"

    # Waveshare "R" 800x480" Resistive touch (http://www.waveshare.com/5inch-HDMI-LCD.htm)
    if [ "${WAVESHARE_800X480_RPI}" = "1" ]; then

        echo "# Waveshare 800x480 5 inch resistive touch screen" >> ${DEPLOYDIR}/${BOOTFILES_DIR_NAME}/config.txt
        echo "hdmi_force_hotplug=1" >> ${DEPLOYDIR}/${BOOTFILES_DIR_NAME}/config.txt
        echo "max_usb_current=1" >> ${DEPLOYDIR}/${BOOTFILES_DIR_NAME}/config.txt
        echo "hdmi_group=2" >> ${DEPLOYDIR}/${BOOTFILES_DIR_NAME}/config.txt
        echo "hdmi_mode=1" >> ${DEPLOYDIR}/${BOOTFILES_DIR_NAME}/config.txt
        echo "hdmi_mode=87" >> ${DEPLOYDIR}/${BOOTFILES_DIR_NAME}/config.txt
        echo "hdmi_cvt=800 480 60 6 0 0 0" >> ${DEPLOYDIR}/${BOOTFILES_DIR_NAME}/config.txt
        echo "hdmi_drive=1" >> ${DEPLOYDIR}/${BOOTFILES_DIR_NAME}/config.txt
        echo "hdmi_ignore_edid=0xa5000080" >> ${DEPLOYDIR}/${BOOTFILES_DIR_NAME}/config.txt

        # remaining safe mode settings see
        # https://www.raspberrypi.org/documentation/configuration/config-txt/video.md
        echo "disable_overscan=0" >> ${DEPLOYDIR}/${BOOTFILES_DIR_NAME}/config.txt
        echo "overscan_left=24" >> ${DEPLOYDIR}/${BOOTFILES_DIR_NAME}/config.txt
        echo "overscan_right=24" >> ${DEPLOYDIR}/${BOOTFILES_DIR_NAME}/config.txt
        echo "overscan_top=24" >> ${DEPLOYDIR}/${BOOTFILES_DIR_NAME}/config.txt
        echo "overscan_bottom=24" >> ${DEPLOYDIR}/${BOOTFILES_DIR_NAME}/config.txt

        echo "edid_content_type=0" >> ${DEPLOYDIR}/${BOOTFILES_DIR_NAME}/config.txt
        echo "hdmi_edid_file=1" >> ${DEPLOYDIR}/${BOOTFILES_DIR_NAME}/config.txt


        echo "" >> ${DEPLOYDIR}/${BOOTFILES_DIR_NAME}/config.txt
        echo "# Touchscreen controller settings for resistive touch" >> ${DEPLOYDIR}/${BOOTFILES_DIR_NAME}/config.txt
        echo "dtparam=spi=on" >> ${DEPLOYDIR}/${BOOTFILES_DIR_NAME}/config.txt
        echo "dtoverlay=ads7846,cs=1,penirq=25,penirq_pull=2,speed=50000,keep_vref_on=0,swapxy=0,pmax=255,xohms=150,xmin=200,xmax=3900,ymin=200,ymax=39001" >> ${DEPLOYDIR}/${BOOTFILES_DIR_NAME}/config.txt

        echo "" >> ${DEPLOYDIR}/${BOOTFILES_DIR_NAME}/config.txt
        echo "# Audio settings taken over from Raspberrian for this display" >> ${DEPLOYDIR}/${BOOTFILES_DIR_NAME}/config.txt
        echo "dtparam=audis=on" >> ${DEPLOYDIR}/${BOOTFILES_DIR_NAME}/config.txt

        echo "" >> ${DEPLOYDIR}/${BOOTFILES_DIR_NAME}/config.txt
    fi

    # Waveshare "R" 800x480" Resistive touch (http://www.waveshare.com/5inch-HDMI-LCD.htm)
    if [ "${WAVESHARE_800X480_RPI}" = "1" ]; then
        install -d ${DEPLOYDIR}/${PN}
        install -m 0644 ${WORKDIR}/ws800x480.edid ${DEPLOYDIR}/${PN}/edid.dat
    fi

    if [ "${ENABLE_I2C}" = "1" ] || [ "${PITFT}" = "1" ]; then
        # enable i2c-0 device
        echo "dtparam=i2c_vc=on" >> ${DEPLOYDIR}/${BOOTFILES_DIR_NAME}/config.txt
    fi
}
