#!/bin/sh

java -Djava.library.path=".:/usr/lib" -cp ".:/usr/share/java:/usr/share/java/threadtools.jar" testthreadtools
