%module JavaThreadTools
%pragma(java) moduleclassmodifiers="public class"
%pragma(java) jniclassclassmodifiers = "class"
%typemap(javaclassmodifiers)   SWIGTYPE, SWIGTYPE *, SWIGTYPE &, SWIGTYPE [], SWIGTYPE (CLASS::*) "class"

%{
#include <libthreadtools.h>
%}

%include "threadtools_swigged.h"
