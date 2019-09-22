@echo off

SET CURRENT_DIRECTORY=%~dp0
SET CLASSPATH=%CURRENT_DIRECTORY%lib\*

: default jdk
java -classpath %CLASSPATH% org.prolobjectlink.db.prolog.jpl7.swi7.SwiPrologDatabaseConsole -m
java -classpath %CLASSPATH% org.prolobjectlink.db.prolog.jpl7.swi7.SwiPrologDatabaseConsole -j %CURRENT_DIRECTORY%lib\prolobjectlink-jpx-model.jar