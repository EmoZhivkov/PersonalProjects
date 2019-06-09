#ifndef EXAMPLE_COMMAND_H
#define EXAMPLE_COMMAND_H

#include <stdio.h>
#include "Segment.h"

// Example for function pointers
void (*commands[128]) (int argc, char **argv);

void funcFors(int argc, char **argv) {
    if (argc != 5) {
        write(2, "Invalid arguments!\n", 30);
        exit(-1);
    }

    char *fileName = argv[1];
    char *paramName = argv[3];
    char *paramValue = argv[4];

    Segment *segments = parseSegmentsFromFile(fileName, NUM_OF_SEGMENTS);
    setParameter(segments, NUM_OF_SEGMENTS, paramName, paramValue);

    int parameterSegmentNum = getParameterSegmentNum(paramName);
    int parameterPosition = getParameterPositionInSegment(paramName);

    setNthBit(segments[parameterSegmentNum].Meta, parameterPosition + 1);

    writeSegmentsToFile(segments, NUM_OF_SEGMENTS, fileName);
}

void funcForS(int argc, char **argv) {
    if (argc != 5) {
        write(2, "Invalid arguments!\n", 30);
        exit(-1);
    }

    char *fileName = argv[1];
    char *paramName = argv[3];
    char *paramValue = argv[4];

    Segment *segments = parseSegmentsFromFile(fileName, NUM_OF_SEGMENTS);
    setParameter(segments, NUM_OF_SEGMENTS, paramName, paramValue);

    writeSegmentsToFile(segments, NUM_OF_SEGMENTS, fileName);
}

void funcForg(int argc, char **argv) {
    if (argc != 4) {
        write(2, "Invalid arguments!\n", 30);
        exit(-1);
    }

    char *fileName = argv[1];
    char *paramName = argv[3];

    Segment *segments = parseSegmentsFromFile(fileName, NUM_OF_SEGMENTS);

    int parameterSegmentNum = getParameterSegmentNum(paramName);
    int parameterPosition = getParameterPositionInSegment(paramName);

    if (isNthBitSet(segments[parameterSegmentNum].Meta, parameterPosition + 1)) {
        char buff[16];
        getParameter(segments, NUM_OF_SEGMENTS, paramName, buff, 16);

        printf("%s\n", buff);
    }
}

void funcForG(int argc, char **argv) {
    if (argc != 4) {
        write(2, "Invalid arguments!\n", 30);
        exit(-1);
    }

    char *fileName = argv[1];
    char *paramName = argv[3];

    Segment *segments = parseSegmentsFromFile(fileName, NUM_OF_SEGMENTS);

    char buff[16];
    getParameter(segments, NUM_OF_SEGMENTS, paramName, buff, 16);

    printf("%s\n", buff);
}

void funcForl(int argc, char **argv) {

}

void funcForL(int argc, char **argv) {

}

void funcForb(int argc, char **argv) {

}

void funcForc(int argc, char **argv) {

}

// TODO: Finish this last
void funcForh(int argc, char **argv) {
    
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
