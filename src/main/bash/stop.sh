#!/bin/sh
AppPath=ArchetypeProject-0.0.1-SNAPSHOT
PROCESS_NUM=`ps -ef|grep "$AppPath"|grep -v "grep"|wc -l`
PROCESS_PID=`ps -ef | grep "$AppPath" | grep -v grep | awk '{print $2}'`
if [ $PROCESS_NUM -ge 1 ]
then
   echo kill $PROCESS_PID
   kill -9 $PROCESS_PID
else
   echo NoSearch
fi