#ifndef EXAMPLE_COMMAND_H
#define EXAMPLE_COMMAND_H

#include <stdio.h>
#include "Segment.h"

// Example for function pointers
void (*commands[128])(int argc, char **argv);

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
    if (argc == 3) {
        char *fileName = argv[1];
        Segment *segments = parseSegmentsFromFile(fileName, NUM_OF_SEGMENTS);

        for (int i = 0; i < LEN_OF_PARAMETERS; ++i) {
            char *paramName = parameters[i]->Name;
            int parameterSegmentNum = parameters[i]->SegmentNum;
            int parameterPosition = parameters[i]->PositionInSegment;

            if (isNthBitSet(segments[parameterSegmentNum].Meta, parameterPosition + 1)) {
                char buff[16];
                getParameter(segments, NUM_OF_SEGMENTS, paramName, buff, 16);

                printf("%s\n", buff);
            }
        }
    } else if (argc > 3) {
        char *fileName = argv[1];
        Segment *segments = parseSegmentsFromFile(fileName, NUM_OF_SEGMENTS);

        for (int i = 3; i < argc; ++i) {
            char *paramName = argv[i];
            int parameterSegmentNum = getParameterSegmentNum(paramName);
            int parameterPosition = getParameterPositionInSegment(paramName);

            if (isNthBitSet(segments[parameterSegmentNum].Meta, parameterPosition + 1)) {
                char buff[16];
                getParameter(segments, NUM_OF_SEGMENTS, paramName, buff, 16);

                printf("%s\n", buff);
            }
        }
    } else {
        write(2, "Invalid arguments!\n", 30);
        exit(-1);
    }
}

void funcForL(int argc, char **argv) {
    if (argc == 3) {
        char *fileName = argv[1];
        Segment *segments = parseSegmentsFromFile(fileName, NUM_OF_SEGMENTS);

        for (int i = 0; i < LEN_OF_PARAMETERS; ++i) {
            char *paramName = parameters[i]->Name;

            char buff[16];
            getParameter(segments, NUM_OF_SEGMENTS, paramName, buff, 16);

            printf("%s\n", buff);
        }
    } else if (argc > 3) {
        char *fileName = argv[1];
        Segment *segments = parseSegmentsFromFile(fileName, NUM_OF_SEGMENTS);

        for (int i = 3; i < argc; ++i) {
            char *paramName = argv[i];

            char buff[16];
            getParameter(segments, NUM_OF_SEGMENTS, paramName, buff, 16);

            printf("%s\n", buff);
        }
    } else {
        write(2, "Invalid arguments!\n", 30);
        exit(-1);
    }
}

void funcForb(int argc, char **argv) {
    if (argc != 5) {
        write(2, "Invalid arguments!\n", 30);
        exit(-1);
    }

    char *fileName = argv[1];
    char *paramName = argv[3];
    int parameterSegmentNum = getParameterSegmentNum(paramName);
    int parameterPosition = getParameterPositionInSegment(paramName);

    uint8_t value = atoi(argv[4]);
    if (value != 0 && value != 1) {
        write(2, "Invalid arguments!\n", 30);
        exit(-1);
    }

    Segment *segments = parseSegmentsFromFile(fileName, NUM_OF_SEGMENTS);

    if (value) {
        if (!isNthBitSet(segments[parameterSegmentNum].Meta, parameterPosition + 1)) {
            setNthBit(segments[parameterSegmentNum].Meta, parameterPosition + 1);
        }
    } else {
        if (isNthBitSet(segments[parameterSegmentNum].Meta, parameterPosition + 1)) {
            unsetNthBit(segments[parameterSegmentNum].Meta, parameterPosition + 1);
        }
    }
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

#endif //EXAMPLE_COMMAND_H
