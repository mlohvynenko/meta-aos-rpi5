SUMMARY = "Aos image for Raspberry Pi devices"

require recipes-core/images/core-image-minimal.bb
require recipes-core/images/aos-image.inc

# Enable package manager
EXTRA_IMAGE_FEATURES += "package-management"

RDEPENDS += "rpi-bootfiles trusted-firmware-a"

do_image[depends] += " \
    rpi-bootfiles:do_deploy \
    trusted-firmware-a:do_deploy \
    ${@bb.utils.contains('RPI_USE_U_BOOT', '1', 'u-boot-tools-native:do_populate_sysroot', '',d)} \
    ${@bb.utils.contains('RPI_USE_U_BOOT', '1', 'u-boot:do_deploy', '',d)} \
    ${@bb.utils.contains('RPI_USE_U_BOOT', '1', 'u-boot-default-script:do_deploy', '',d)} \
"

PACKAGE_INSTALL:append = " \
    coreutils \
    u-boot \
    xen \
    xen-tools-scripts-network \
    xen-tools-scripts-block \
    xen-tools-xenstore \
    xen-tools-devd \
    virtual-xenstored \
    xen-network \
    kernel-modules \
"

# Basic packages
IMAGE_INSTALL:append = " \
    bash \
    v4l-utils \
    i2c-tools \
    coreutils \
"

IMAGE_INSTALL:append = " \
    pciutils \
    devmem2 \
    optee-test \
    xen \
    xen-tools-devd \
    xen-tools-scripts-network \
    xen-tools-scripts-block \
    xen-tools-xenstore \
    xen-tools-vchan \
    xen-network \
    dnsmasq \
    openssh \
"

IMAGE_INSTALL:append = " \
    iproute2 \
    iproute2-tc \
    tcpdump \
    e2fsprogs \
    aos-messageproxy \
"

IMAGE_FSTYPES:remove = "wic.bz2 wic.bmap ext3"
IMAGE_FSTYPES:append = " ext4"

# Set fixed rootfs size
IMAGE_ROOTFS_SIZE ?= "1048576"
IMAGE_OVERHEAD_FACTOR ?= "1.0"
IMAGE_ROOTFS_EXTRA_SPACE ?= "524288"
