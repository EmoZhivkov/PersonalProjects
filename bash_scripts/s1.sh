#!/bin/bash

if [ ! -d $1 ]
then
    echo "$1 is not a directory"
    exit 1
else
    dir=$1
fi

shift

for file in $@
do
    if [ ! -f $file ]
    then
        echo "The file $file doesn't exist"
        continue
    fi

    currentSize=$( stat -f"%z" $file )
    if [ $currentSize -gt 4096 ]
    then
        mv $file $dir
    else
        echo "The file $file is not greater than 4096 bytes, it is $currentSize"
    fi
done
