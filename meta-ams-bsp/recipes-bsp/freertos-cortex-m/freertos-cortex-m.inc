DESCRIPTION = "MX Cortex M4/M7/M33 Firmware"
LICENSE = "CLOSED"
SECTION = "BSP"
PR = "4"

#4inherit cmake
DEPENDS = "cmake-native"
DEPENDS:append = " cortexm-toolchain-cross (=${CM_GCC})"

inherit deploy

S = "${WORKDIR}/apps"

MCORE_TYPE  ?= "m4"
MCORE_TYPE:mx8mn-nxp-bsp  = "m7"
MCORE_TYPE:mx8mnul-nxp-bsp = "m7"
MCORE_TYPE:mx8mp-nxp-bsp  = "m7"
MCORE_TYPE:mx8mpul-nxp-bsp  = "m7"
MCORE_TYPE:mx8ulp-nxp-bsp  = "m33"
MCORE_TYPE:mx93-nxp-bsp  = "m33"

CM_BOARD="INVALID"
CM_BOARD:mx8mn-nxp-bsp="som_mx8mn"
CM_BOARD:mx8mq-nxp-bsp="dart_mx8mq"
CM_BOARD:mx8mm-nxp-bsp="dart_mx8mm"
CM_BOARD:mx8mp-nxp-bsp="dart_mx8mp som_mx8mp"
CM_BOARD:mx8qm-nxp-bsp="som_mx8qm"
CM_BOARD:mx8qxp-nxp-bsp="som_mx8qx"
CM_BOARD:mx9-nxp-bsp="som_mx93"

CM_BUILD_TARGETS = " \
    debug \
    release \
"
APPLICATION ?= "rpmsg_lite_str_echo_rtos"
APP_TARGET_NAME ?= "cortex-m-firmware"

compile_fw() {
    DIR_GCC="$1"
    cd ${DIR_GCC}
    ./clean.sh
    if grep -q "make -j" build_all.sh; then
        sed -i "s/make -j.*[0-9]*/make ${PARALLEL_MAKE}/g" build_all.sh
    fi
    LDFLAGS="" CFLAGS="" CXXFLAGS="" ./build_all.sh > /dev/null
}

do_compile() {
    # Configure ARMGCC
    export ARMGCC_DIR="${STAGING_DIR_NATIVE}${bindir}/cortexm-toolchain-cross-${CM_GCC}"
    # cmake needs to know where to find the sdk
    export SdkRootDirPath="${WORKDIR}/sdk"

    compile_fw "${S}/apps/${APPLICATION}/armgcc"
}

do_install() {
    install -d ${D}${nonarch_base_libdir}/firmware/
    install -d ${D}/boot/

    DIR_GCC="${S}/apps/${APPLICATION}/armgcc"
    # Install all build targets
    for CM_BUILD_TARGET in ${CM_BUILD_TARGETS}; do
        FW_BASENAME="$(basename ${DIR_GCC}/${CM_BUILD_TARGET}/*.elf .elf)"

        # Install elf
        FILE_CM_FW="${FW_BASENAME}.elf"
        install -m 644 ${DIR_GCC}/${CM_BUILD_TARGET}/${FILE_CM_FW} ${D}${nonarch_base_libdir}/firmware/${APP_TARGET_NAME}.elf.${CM_BUILD_TARGET}

        # Install bin
        FILE_CM_FW="$(basename ${DIR_GCC}/${CM_BUILD_TARGET}/*.bin)"
        install -m 644 ${DIR_GCC}/${CM_BUILD_TARGET}/${FILE_CM_FW} ${D}/boot/${APP_TARGET_NAME}.bin.${CM_BUILD_TARGET}
    done
}

# Make sure that the cortex-m firmware shows up as a folder within deploy directory
do_deploy() {
    fwdir="${MCORE_TYPE}_fw"
    install -d ${DEPLOYDIR}/${fwdir}/bin
    install -d ${DEPLOYDIR}/${fwdir}/elf

    cp -rf ${D}/boot/* ${DEPLOYDIR}/${fwdir}/bin
    cp -rf ${D}${nonarch_base_libdir}/firmware/* ${DEPLOYDIR}/${fwdir}/elf
}
addtask deploy after do_install

FILES:${PN} = " \
    ${nonarch_base_libdir}/firmware/${APP_TARGET_NAME}.elf.release \
    /boot/${APP_TARGET_NAME}.bin.release \
"
FILES:${PN}-dbg = " \
    ${nonarch_base_libdir}/firmware/${APP_TARGET_NAME}.elf.debug \
    /boot/${APP_TARGET_NAME}.bin.debug \
"

INHIBIT_PACKAGE_STRIP = "1"
INHIBIT_PACKAGE_DEBUG_SPLIT = "1"

# Firmware files are run on M4/M7/M33
INSANE_SKIP = "arch"
