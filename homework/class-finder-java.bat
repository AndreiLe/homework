@echo off
REM Class Finder
set "PATH=%PATH%;C:\Program Files\Java\jdk1.8.0_131\bin"
:start
cd /d %~dp0
echo Write "<filename> '<pattern>'"
set /p pattern=
javac src/ClassFinder.java
java -cp src ClassFinder %pattern%
pause
del "%cd%\src\ClassFinder.class"
del "%cd%\src\StringFinder.class"
del "%cd%\src\StringFinderString.class"
del "%cd%\src\StringFinderUtils.class"
del "%cd%\src\StringPatternString.class"
cls
goto start