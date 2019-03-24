#!/usr/bin/bash
java -classpath "$(dirname "$(pwd)")/lib/*" org.prolobjectlink.prolog.jpl7.swi.SwiPrologDatabaseConsole ${1+"$@"}