#!/bin/bash

echo "Name of file: "
read file

echo "Word: "
read word

cat $file | grep $word &> /dev/null

echo "The exit code of the program is: $?"