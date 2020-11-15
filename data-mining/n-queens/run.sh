g++ -O3 -funroll-loops -g -Wall -ansi minimum-conflicts.cpp -c -o minimum-conflicts.o
g++ -O3 -funroll-loops -g -Wall -ansi minimum-conflicts.o -o MinimumConflict

# running the program with 10000 queens
time ./MinimumConflict 10000