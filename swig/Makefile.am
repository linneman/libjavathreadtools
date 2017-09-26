ACLOCAL_AMFLAGS = -I m4

# generated sources
THREADTOOLS_WRAP = libthreadtools_wrap.c
BUILT_SOURCES = $(THREADTOOLS_WRAP)
# Correctly clean the generated headers
CLEANFILES = $(BUILT_SOURCES)

# installed header files
# include_HEADERS= \
# 	native/jni_setup.h

# meta library name used by libtool
lib_LTLIBRARIES=libjavathreadtools.la
libjavathreadtools_la_CFLAGS = \
	-I$(top_srcdir)/include \
	-I${JDK_HOME}/include/ \
	-I${JDK_HOME}/include/linux
libjavathreadtools_la_LDFLAGS = -L../src/.libs -version-info $(libtool_VERSION)
libjavathreadtools_la_LIBADD = -lthreadtools -ldl

# the rest of the sources goes into distribution (make dist)
libjavathreadtools_la_SOURCES = \
	threadtools_wrap.c \
	threadtools.i \
	threadtools_swigged.h

$(THREADTOOLS_WRAP): threadtools_swigged.h threadtools.i
	mkdir -p com/valeo/threadtools
	swig -java -package com.valeo.threadtools -outdir com/valeo/threadtools $(abs_srcdir)/threadtools.i
	javac com/valeo/threadtools/JavaThreadTools.java
	jar cf threadtools.jar com

install-exec-local:
	$(INSTALL_PROGRAM) threadtools.jar $(DESTDIR)$(libdir)

uninstall-hook:
	-rm $(DESTDIR)$(libdir)/threadtools.jar

clean-local:
	-rm -rf com threadtools.jar
