#!/bin/sh
export JAVA_HOME=$JAVA_HOME
export PATH=$JAVA_HOME/bin:$PATH
export CLASSPATH=.:$JAVA_HOME/lib/dt.jar:$JAVA_HOME/lib/tools.jar

java -Xms128M -Xmx1024M -jar ./lib/ArchetypeProject-0.0.1-SNAPSHOT.war  &

