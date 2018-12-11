
# 1.12.x branch is the current stable branch, the recommended default
# 1.13.x is the current mainline branches containing all new features
DEFAULT_PREFERENCE = "-1"


do_install_append() {
    install -m 0644 ${WORKDIR}/nginx.conf ${D}${sysconfdir}/nginx/nginx.conf
    sed -i 's,/var/,${localstatedir}/,g' ${D}${sysconfdir}/nginx/nginx.conf
    sed -i 's/^user.*/user ${NGINX_USER};/g' ${D}${sysconfdir}/nginx/nginx.conf
}