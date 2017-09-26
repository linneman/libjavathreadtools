AM_CPPFLAGS = -Wall -std=c99 -I$(top_srcdir)/include

# meta library name used by libtool
lib_LTLIBRARIES=libthreadtools.la
libthreadtools_la_LDFLAGS = -version-info $(libtool_VERSION)
libthreadtools_la_LIBADD = -ldl

# the rest of the sources goes into distribution (make dist)
libthreadtools_la_SOURCES = \
	libthreadtools.c

# module tests
bin_PROGRAMS = test_libthreadtools
test_libthreadtools_CPPFLAGS=-I$(top_srcdir)/src -DDATADIR=\"$(pkgdatadir)\" $(AM_CPPFLAGS)
test_libthreadtools_SOURCES = \
	test_libthreadtools.c
test_libthreadtools_LDADD = libthreadtools.la -lm
