#!/bin/bash

echo "Please input your"
read name

last | grep $name | wc -l