#ifndef EXAMPLE_BITMANIPULATION_H
#define EXAMPLE_BITMANIPULATION_H

#include <stdint.h>

int isNthBitSet(uint8_t meta[7], int n) {
    uint8_t bit[8] = {128, 64, 32, 16, 8, 4, 2, 1};

    int metaIndex = (n - 1) / 8;
    int bitIndex = n;
    if (bitIndex > 8) {
        bitIndex = (bitIndex % 8) - 1;
    } else {
        bitIndex--;
    }

    uint8_t temp = meta[metaIndex] & bit[bitIndex];
    if (temp == bit[bitIndex]) {
        return 1;
    }
    return 0;
}

void setNthBit(uint8_t *meta, int n) {
    uint8_t bit[8] = {128, 64, 32, 16, 8, 4, 2, 1};

    int metaIndex = (n - 1) / 8;
    int bitIndex = n;
    if (bitIndex > 8) {
        bitIndex = (bitIndex % 8) - 1;
    } else {
        bitIndex--;
    }

    meta[metaIndex] = meta[metaIndex] | bit[bitIndex];
}

#endif //EXAMPLE_BITMANIPULATION_H
