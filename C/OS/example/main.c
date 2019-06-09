#include <stdio.h>
#include <string.h>
#include "Parameter.h"
#include "BitManipulation.h"
#include "Segment.h"

#define NUM_OF_SEGMENTS 5

int main(int argc, char **argv) {
    Segment *segments = parseSegmentsFromFile("../bt.bin", NUM_OF_SEGMENTS);

    char buffer[16];
    getParameter(segments, NUM_OF_SEGMENTS, "serial_stop_bit", buffer, 16);
    printf("%s\n", buffer);
}