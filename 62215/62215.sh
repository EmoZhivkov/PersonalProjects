#!/bin/bash

tr -cs '[:alpha:]' '\n' < text.txt | awk '{print tolower($0)}' | sort | uniq | \
xargs -I{} -n1 sh -c '(echo {}: && agrep -w -B -s {} dic.txt) | tr "\n" ":"; echo "\n"'| \
grep . | awk -F: '{if ($3 != 0) print $1":"$3":"$4}'

