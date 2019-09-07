#!/usr/bin/bash
java -classpath "$(pwd)/lib/*" org.prolobjectlink.db.prolog.jpl7.swi7.SwiPrologDatabaseConsole -m
java -classpath "$(pwd)/lib/*" org.prolobjectlink.db.prolog.jpl7.swi7.SwiPrologDatabaseConsole -j  "$(pwd)/lib/prolobjectlink-jpx-model.jar"