SUMMARY = "A small image just capable of allowing a device to boot."

# require recipes-core/images/core-image-minimal.bb
require recipes-core/image/rpi5-image-xt-domd.bb
require recipes-core/images/aos-image.inc

PACKAGE_INSTALL:append = " \
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
"

IMAGE_INSTALL:append = " \
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

IMAGE_INSTALL:append = " iproute2 iproute2-tc tcpdump nvme-cli"

# IMAGE_INSTALL:append = " kernel-module-nvme-core kernel-module-nvme"

# IMAGE_INSTALL:append = " kernel-module-ixgbe"

IMAGE_INSTALL:append = " e2fsprogs"

IMAGE_INSTALL:append = " \
    aos-messageproxy \
"

# Set fixed rootfs size
IMAGE_ROOTFS_SIZE ?= "1048576"
IMAGE_OVERHEAD_FACTOR ?= "1.0"
IMAGE_ROOTFS_EXTRA_SPACE ?= "524288"
