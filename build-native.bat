call "D:\program\MicrosoftVisual Studio\2019\BuildTools\VC\Auxiliary\Build\vcvars64.bat"
# set JAVA_HOME=D:\DevTool\Java\jdk17.0.3.1
# set PATH=%JAVA_HOME%\bin;%PATH%
mvn clean package -DskipTests -Pnative
pause