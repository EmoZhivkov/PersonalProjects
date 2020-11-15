g++ -O3 -funroll-loops -g -Wall -ansi main.cpp -c -o main.o
g++ -O3 -funroll-loops -g -Wall -ansi main.o -o main

# running the program with 10000 queens
./main 10000