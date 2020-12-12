#!/bin/bash
qemu-system-x86_64 \
    -device virtio-scsi-pci,id=scsi \
    -drive file=${1:-"ams-image-gui-dev"}.wic,id=root-img,if=none,format=raw,cache=none \
    -device scsi-hd,drive=root-img \
    -no-reboot \
    -serial mon:stdio --enable-kvm -device virtio-vga,xres=480,yres=800 \
    -vga none -cpu host -m 4096 \
    -usb -device usb-kbd -usb -device usb-tablet
