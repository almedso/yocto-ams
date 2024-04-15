FILESEXTRAPATHS:prepend := "${THISDIR}/files:"

SRC_URI += "file://wpa_supplicant-wlan0.conf"

SYSTEMD_AUTO_ENABLE = "enable"
SYSTEMD_SERVICE:${PN}:append = " \
   ${@bb.utils.contains('MACHINE_FEATURES','wifi','wpa_supplicant@wlan0.service','',d)} \
"

do_install:append () {
   install -d ${D}${sysconfdir}/wpa_supplicant/
   install -D -m 600 ${WORKDIR}/wpa_supplicant-wlan0.conf ${D}${sysconfdir}/wpa_supplicant/

   # modify SSID and PSK inplace
   if [ -n "${MY_SSID}" ] ; then
      sed -i "s/MY_SSID/${MY_SSID}/" ${D}${sysconfdir}/wpa_supplicant/wpa_supplicant-wlan0.conf
   fi
   if [ -n "${MY_PSK}" ] ; then
      sed -i "s/MY_PSK/${MY_PSK}/" ${D}${sysconfdir}/wpa_supplicant/wpa_supplicant-wlan0.conf
   fi
   # enable the service
   install -d ${D}${sysconfdir}/systemd/system/multi-user.target.wants/
   ln -s ${systemd_unitdir}/system/wpa_supplicant@.service ${D}${sysconfdir}/systemd/system/multi-user.target.wants/wpa_supplicant@wlan0.service
}
