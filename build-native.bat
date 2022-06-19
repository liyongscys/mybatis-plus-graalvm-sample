@echo off
rem call "D:\program\MicrosoftVisual Studio\2019\BuildTools\VC\Auxiliary\Build\vcvars64.bat"
rem set graalVM_home=D:\DevTool\graalvm\graalvm-ce-java11-21.3.2
rem set JAVA_HOME=%graalVM_home%
rem set PATH=%JAVA_HOME%\bin;%PATH%
mvn clean package -DskipTests -Pnative
pause