#!/bin/bash

array=($(cat /etc/passwd | cut -d: -f3))

echo ${#array[@]}