#ifndef EXAMPLE_COMMAND_H
#define EXAMPLE_COMMAND_H

#include <stdio.h>
#include "Segment.h"

// Example for function pointers
void (*commands[128]) (int argc, char **argv);

void funcFors(int argc, char **argv) {

}

void funcForS(int argc, char **argv) {

}

void funcForg(int argc, char **argv) {

}

void funcForG(int argc, char **argv) {

}

void funcForl(int argc, char **argv) {

}

void funcForL(int argc, char **argv) {

}

void funcForb(int argc, char **argv) {

}

void funcForc(int argc, char **argv) {

}

// TODO
void funcForh(int argc, char **argv) {
    printf("%s\n", "I need to finish this last!");
}

void initCommands() {
    commands['s'] = &funcFors;
    commands['S'] = &funcForS;
    commands['g'] = &funcForg;
    commands['G'] = &funcForG;
    commands['l'] = &funcForl;
    commands['L'] = &funcForL;
    commands['b'] = &funcForb;
    commands['c'] = &funcForc;
    commands['h'] = &funcForh;
}

// This is how you can call them
// (*p[1]) (i, j);

#endif //EXAMPLE_COMMAND_H
