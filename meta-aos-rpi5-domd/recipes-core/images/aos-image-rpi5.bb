SUMMARY = "A small image just capable of allowing a device to boot."

# require recipes-core/images/core-image-minimal.bb
require recipes-core/image/rpi5-image-xt-domd.bb
require recipes-core/images/aos-image.inc


PACKAGE_INSTALL:append = " \
    kernel-modules \
"

IMAGE_INSTALL:append = "	\
    aos-messageproxy \
    optee-test			\
    xen-tools-vchan		\
"

# Set fixed rootfs size
IMAGE_ROOTFS_SIZE ?= "1048576"
IMAGE_OVERHEAD_FACTOR ?= "1.0"
IMAGE_ROOTFS_EXTRA_SPACE ?= "524288"
