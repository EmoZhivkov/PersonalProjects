#ifndef EXAMPLE_SEGMENT_H
#define EXAMPLE_SEGMENT_H

#include <stdint.h>
#include <stdio.h>
#include <stdlib.h>
#include <unistd.h>
#include <fcntl.h>
#include <err.h>

typedef union Data {
    char Text[3][16];
    uint32_t Num[14];
    uint8_t Byte[56];
} Data;

typedef struct Segment {
    uint8_t Type;
    uint8_t Meta[7];
    Data Data;
} Segment;

Segment parseSegmentFromFd(int *fd) {
    Segment segment;

    int temp = read(*fd, &segment, 64);
    if (temp < 0) {
        write(2, "Failed to read the segment\n", 50);
        exit(-1);
    }

    return segment;
}

Segment *parseSegmentsFromFile(char *fileName, int numOfSegments) {
    int fd = open(fileName, O_RDONLY);
    if (fd == -1) {
        write(2, "Failed to open file in read mode\n", 50);
        exit(-1);
    }

    Segment *segments = malloc(numOfSegments * 64);

    for (int i = 0; i < numOfSegments; ++i) {
        segments[i] = parseSegmentFromFd(&fd);
    }

    close(fd);
    return segments;
}

int writeSegmentsToFile(Segment *segments, int numOfSegments, char *fileName) {
    int fd = open(fileName, O_WRONLY|O_CREAT, 0666);
    if (fd == -1) {
        write(2, "Failed to open file in write mode\n", 50);
        exit(-1);
    }

    int bytesWritten = write(fd, segments, numOfSegments * 64);
    if (bytesWritten == (numOfSegments * 64)) {
        close(fd);
        return 1;
    }
    close(fd);
    return 0;
}

void setParameter(Segment *segments, int numOfSegments, char *paramName, char *value){
    if (!isValidValueForParameter(paramName,value)) {
        write(2, "Invalid value for parameter!\n", 50);
        exit(-1);
    }

    uint8_t segmentNum = getParameterSegmentNum(paramName);
    uint8_t positionInSegment = getParameterPositionInSegment(paramName);

    if (segmentNum >= numOfSegments) {
        write(2, "Invalid configuration. The segment number doesn't match!\n", 100);
        exit(-1);
    }

    if (segments[segmentNum].Type == 0) {
        memset(segments[segmentNum].Data.Text[positionInSegment], 0, 16);
        memcpy(segments[segmentNum].Data.Text[positionInSegment], value, strlen(value));
    } else if (segments[segmentNum].Type == 1) {
        uint32_t num = atoi(value);
        segments[segmentNum].Data.Num[positionInSegment] = num;
    } else if (segments[segmentNum].Type == 2) {
        uint8_t num = atoi(value);
        segments[segmentNum].Data.Byte[positionInSegment] = num;
    }
}

void getParameter(Segment *segments, int numOfSegments, char *paramName, char *buffer, int bufferSize) {
    uint8_t segmentNum = getParameterSegmentNum(paramName);
    uint8_t positionInSegment = getParameterPositionInSegment(paramName);

    if (segmentNum >= numOfSegments) {
        write(2, "Invalid configuration. The segment number doesn't match!\n", 100);
        exit(-1);
    }


    if (segments[segmentNum].Type == 0) {
        memcpy(buffer, segments[segmentNum].Data.Text[positionInSegment], bufferSize);
    } else if (segments[segmentNum].Type == 1) {
        uint32_t num = segments[segmentNum].Data.Num[positionInSegment];
        sprintf(buffer, "%d", num);
    } else if (segments[segmentNum].Type == 2) {
        uint8_t byte = segments[segmentNum].Data.Byte[positionInSegment];
        sprintf(buffer, "%d", byte);
    }
}

#endif //EXAMPLE_SEGMENT_H
