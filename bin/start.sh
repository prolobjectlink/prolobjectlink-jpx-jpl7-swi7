#!/usr/bin/bash
java -classpath "$(dirname "$(pwd)")/lib/*" io.github.prolobjectlink.db.prolog.jpl7.swi7.SwiPrologDatabaseConsole -m
java -classpath "$(dirname "$(pwd)")/lib/*" io.github.prolobjectlink.db.prolog.jpl7.swi7.SwiPrologDatabaseConsole -z 9110