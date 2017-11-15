@echo off
REM Class Finder
set "PATH=%PATH%;C:\Program Files\Java\jdk1.8.0_131\bin"
:start
cd /d %~dp0
echo Write "<filename> '<pattern>'"
set /p pattern=
javac src/*.java src/stringFinder/*.java
java -cp src ClassFinder %pattern%

del "%cd%\src\ClassFinder.class"
del "%cd%\src\stringFinder\StringFinder.class"
del "%cd%\src\stringFinder\StringFinderString.class"
del "%cd%\src\stringFinder\StringFinderUtils.class"
del "%cd%\src\stringFinder\StringPatternString.class"
pause
cls
goto start