#!/usr/bin/bash
java -classpath "$(dirname "$(pwd)")/lib/*" org.prolobjectlink.db.prolog.jpl7.swi7.SwiPrologDatabaseConsole ${1+"$@"}