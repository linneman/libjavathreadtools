DESCRIPTION = "Thread Tools for Java"
HOMEPAGE = "tbd."
LICENSE = "GPLv2"
LIC_FILES_CHKSUM = "file://COPYING;md5=23c2a5e0106b99d75238986559bb5fc6"
PR = "r0"

FILESPATH =+ "${WORKSPACE}:"
SRC_URI = "file://peiker/libjavathreadtools \
           file://test_libjavathreadtools.sh"
S = "${WORKDIR}/libjavathreadtools/"

# EXTRA_OECONF += "CFLAGS='-O1 -g'"
EXTRA_OECONF += "CPPFLAGS='-D_FORTIFY_SOURCE=2' CFLAGS='-O2 -fpic -fstack-protector-all' LDFLAGS='-fpic'"

inherit autotools pkgconfig gettext

do_compile_append_mdm9640() {
    javac -cp ".:${WORKDIR}/build/swig/threadtools.jar" ${S}/test/testthreadtools.java
}

do_install_append_mdm9640() {
    mkdir -p ${D}/usr/share/java

    # install jar file
    install -m 0755 ${WORKDIR}/build/swig/threadtools.jar -D ${D}/usr/share/java
    install -m 0755 ${S}/test/testthreadtools.class -D ${D}/usr/share/java
    install -m 0755 ${WORKDIR}/test_libjavathreadtools.sh -D ${D}/usr/bin
}

# avoid messing up library symlinks generated by libtool
# acc. to https://patchwork.openembedded.org/patch/17297/
#
# "When  PACKAGE_SNAP_LIB_SYMLINK   is  enabled,  development   packages  (-dev)
# contained dangling symbolic  links which prevented usage  of snapped libraries
# on development machines with installed toolchain and snapped -dev package(s).
#
# library object snapping  from dependency computation and put  it into separate
# function which is  executed before the package splitting is  done. This way we
# have all relevant files available and  can do all necessary queries to library
# files."

PACKAGE_SNAP_LIB_SYMLINKS = "0"


FILES_${PN} += "/usr/share/java/*"
FILES_${PN} += "/usr/bin/test_libjavathreadtools.sh"