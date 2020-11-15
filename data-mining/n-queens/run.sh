g++ -O3 -funroll-loops -g -Wall -ansi minimum-conflicts.cpp -c -o minimum-conflicts.o
g++ -O3 -funroll-loops -g -Wall -ansi minimum-conflicts.o -o MinimumConflict
./MinimumConflict 10000