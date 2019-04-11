#!/bin/bash

echo "Input dir name:"

read dir

if [ ! -d $dir ]
then
    echo "$dir is not a directory."
    exit 1
else
    numOfFiles=$( find $dir -type f -maxdepth 1 | wc -l )
    numOfDirs=$( find $dir -type d -maxdepth 1 | wc -l )

    echo "Num of files: $numOfFiles"
    echo "Num of dirs: $numOfDirs"
fi

