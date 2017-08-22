#!/bin/bash
MAIN_PATH=$1
CODE_FILENAME=$MAIN_PATH/code.cpp
OUTPUT_FILENAME=$MAIN_PATH/result.txt
EXECUTABLE_PATH=$MAIN_PATH
EXECUTABLE_NAME=$MAIN_PATH/a.out
TESTCASE_FILENAME=$2
ANS_FILENAME=$MAIN_PATH/testcaseOutput.txt
REPORT_FILENAME=$MAIN_PATH/report.res
CC=g++
TIMEOUT=1
######################################################
#some useful funcs
write_time(){
	echo "`date +%Y-%m-%d-%H%M%S`.log"
}


__EXEC_COMMAND_WITH_TIMEOUT() {
COMMAND=$1
TIMEOUT=$2

 $COMMAND 2> /dev/null &
 PID=$!
  sleep $TIMEOUT && ps -p $PID -o pid,ppid | grep $$ | awk"{print $1}"2> /dev/null | xargs kill &
   wait $PID

    return $?
}

#######################################################
#prepare work
cd $MAIN_PATH
#clean the previous log and executable info
if test -e *.log
then 
	rm *.log
elif test -e *.res
then 
	rm *.res
fi	
######################################################
#start work now
logName=`write_time`
$CC $CODE_FILENAME -o $EXECUTABLE_NAME 2>> $logName
if [[ $? == 0 ]];
then 
	./a.out < $TESTCASE_FILENAME > $OUTPUT_FILENAME
	#sleep $TIMEOUT 
	#if test ps --no-heading $PID| wc -l > /dev/null
	if false
		then
			kill -9 $PID
			echo TLE> $REPORT_FILENAME
	else
	#sleep $TIMEOUT &&ps -p $PID -o pid,ppid  | grep $$ |awk"{print "aaa"}">/dev/null |xargs 
	#kill &
	#wait &PID
		#echo success>stdout
		#echo diff -w -b -B  $ANS_FILENAME $OUTPUT_FILENAME
		diff  -w   $ANS_FILENAME $OUTPUT_FILENAME
		if [[ $? == 0 ]];
		then
			echo AC> $REPORT_FILENAME
		else
			echo WA> $REPORT_FILENAME
		fi
	fi
else
	echo CE> $REPORT_FILENAME
	#cat $logName >> $RESULT_FILE
fi
