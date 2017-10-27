set JAVA_HOME=c:\java\jdk64-7
set M2_HOME=c:\java\mvn311
set path=%JAVA_HOME%\bin;%M2_HOME%\bin;%path%
mvn -s c:\java\mvn311\conf\settings.xml archetype:generate -DarchetypeGroupId=org.codehaus.mojo -DarchetypeArtifactId=gwt-maven-plugin -DarchetypeVersion=2.6.1 -DgroupId=shu -DartifactId=ShuComp -DinteractiveMode=false -Dmodule=startpoint
