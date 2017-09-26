#                                               -*- Autoconf -*-
# Process this file with autoconf to produce a configure script.

AC_INIT([libjavathreadtools],[git_full_version],[linneman@gmx.de])
AC_PREREQ([2.61])
AC_CONFIG_MACRO_DIR([m4])

AM_INIT_AUTOMAKE([subdir-objects])
AC_CONFIG_SRCDIR([src/libthreadtools.c])
AC_CONFIG_HEADERS([config.h])

# For libtool versioning info, format is CURRENT:REVISION:AGE
# specify version information for library using the following rules:
# - library source changed -> increment REVISION
# - interfaces added/removed/changed -> increment CURRENT, REVISION = 0
# - interfaces added -> increment AGE
# - interfaces removed -> AGE = 0
ASRC_CURRENT=1
ASRC_REVSION=1
ASRC_AGE=0

libtool_VERSION=$ASRC_CURRENT:$ASRC_REVSION:$ASRC_AGE
AC_SUBST(libtool_VERSION)

# determine version information for pkg-config
# attention: this works exclusviely for GNU/Linux and BSD based systems
pkgconfig_VERSION=$(expr $ASRC_CURRENT - $ASRC_AGE).$ASRC_AGE.$ASRC_REVSION
AC_SUBST(pkgconfig_VERSION)

# makro for fetching full git tag number version() function
# AX_GIT_REVISION

# Checks for programs.
AC_PROG_CC

# Checks for libraries.
AC_CHECK_LIB([pthread], [pthread_create])

# Checks for header files.
AC_HEADER_DIRENT
AC_HEADER_STDC
AC_CHECK_HEADERS([stdlib.h string.h ptread.h stdint.h])

# Checks for typedefs, structures, and compiler characteristics.
AC_C_CONST
AC_HEADER_STDBOOL
AC_C_INLINE
AC_TYPE_SIZE_T
AC_HEADER_TIME

# Checks for library functions.
AC_FUNC_CLOSEDIR_VOID
AC_FUNC_MEMCMP
AC_FUNC_SELECT_ARGTYPES
AC_TYPE_SIGNAL
AC_FUNC_STAT
AC_PROG_LIBTOOL
AC_CHECK_FUNCS([memset])


AC_ARG_VAR([JDK_HOME], [root directory of Java Development Kit])
if test -z "$JDK_HOME"; then
   # default for Debian/Wheezy
   JDK_HOME="/usr/lib/jvm/java-7-openjdk-amd64"
fi
AC_MSG_NOTICE([JDK_HOME=${JDK_HOME}])


AC_CONFIG_FILES([Makefile include/Makefile src/Makefile swig/Makefile libthreadtools.pc])
AC_OUTPUT
