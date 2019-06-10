#ifndef EXAMPLE_COMMAND_H
#define EXAMPLE_COMMAND_H

#include <stdio.h>
#include "Segment.h"

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
                printf("%s\n", paramName);
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
        for (int i = 0; i < LEN_OF_PARAMETERS; ++i) {
            char *paramName = parameters[i]->Name;
            printf("%s\n", paramName);
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
    if (argc < 5) {
        write(2, "Invalid arguments!\n", 30);
        exit(-1);
    }

    if ((argc - 3) % 2) {
        write(2, "Invalid arguments!\n", 30);
        exit(-1);
    }

    char *fileName = argv[1];
    Segment *segments = malloc(64 * (argc - 3) / 2);

    for (int i = 3; i < argc; i = i + 2) {
        Segment segment;
        uint8_t segmentNum = atoi(argv[i]);

        if (!strcmp(argv[i + 1], "t")) { // 16 byte words
            segment.Type = 0;
            for (int j = 0; j < 7; ++j) {
                segment.Meta[j] = 0;
            }
            for (int k = 0; k < 3; ++k) {
                memset(segment.Data.Text[k], 0, 16);
            }
        } else if (!strcmp(argv[i + 1], "n")) {
            segment.Type = 1;
            for (int j = 0; j < 7; ++j) {
                segment.Meta[j] = 0;
            }
            for (int k = 0; k < 14; ++k) {
                segment.Data.Num[k] = 0;
            }
        } else if (!strcmp(argv[i + 1], "b")) {
            segment.Type = 1;
            for (int j = 0; j < 7; ++j) {
                segment.Meta[j] = 0;
            }
            for (int k = 0; k < 56; ++k) {
                segment.Data.Byte[k] = 0;
            }
        } else {
            write(2, "Invalid arguments!\n", 30);
            exit(-1);
        }

        segments[segmentNum] = segment;
    }

    writeSegmentsToFile(segments, (argc - 3) / 2, fileName);
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
