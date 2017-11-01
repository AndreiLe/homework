::Class Finder
@echo off
set "PATH=%PATH%;C:\Program Files\Java\jdk1.8.0_131\bin"
:start
echo Write "<filename> '<pattern>'"
set /p pattern=
javac src/ClassFinder.java
java -cp src ClassFinder %pattern%
pause 
del /S /Q %cd%\src\ClassFinder.class
cls
goto start