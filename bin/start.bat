@echo off

SET CURRENT_DIRECTORY=%~dp0
for %%B in (%CURRENT_DIRECTORY%.) do set PROLOBJECTLINK_HOME=%%~dpB
SET CLASSPATH=%PROLOBJECTLINK_HOME%lib\*

: default jdk
java -classpath %CLASSPATH% io.github.prolobjectlink.db.prolog.jpl7.swi7.SwiPrologDatabaseConsole -m
java -classpath %CLASSPATH% io.github.prolobjectlink.db.prolog.jpl7.swi7.SwiPrologDatabaseConsole -z 9110