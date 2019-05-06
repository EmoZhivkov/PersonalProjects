#!/bin/bash

maxCnt=0
currCnt=0
while read -n1 char
do
    if [[ $char = "{" ]]
    then
        currCnt=$(( $currCnt + 1 ))
        if [[ $currCnt -gt $maxCnt ]]
        then
            maxCnt=$currCnt
        fi
    elif [[ $char = "}" ]]
    then
        currCnt=$(( $currCnt - 1))
    fi
done < indent.c

echo "The maximum indentation is $maxCnt!"