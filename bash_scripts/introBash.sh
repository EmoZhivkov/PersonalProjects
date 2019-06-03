#!/bin/bash

for i in /etc/passwd
do
  echo $i
done

while read line
do
    echo $line
done < <(cat /etc/passwd)

