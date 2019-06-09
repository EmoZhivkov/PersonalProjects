#ifndef EXAMPLE_PARAMETER_H
#define EXAMPLE_PARAMETER_H

#include <fcntl.h>
#include <stdlib.h>
#include <unistd.h>
#include <regex.h>

#define LEN_OF_PARAMETERS 15

typedef struct Parameter {
    char *Name;
    uint8_t SegmentNum;
    uint8_t PositionInSegment;
    char *Regex;
} Parameter;

Parameter deviceName = {"device_name", 0, 0, "[a-zA-Z0-9_-]+"};
Parameter romRevision = {"rom_revision", 0, 1, "[a-zA-Z0-9_-]+"};
Parameter serialNumber = {"serial_number", 0, 2, "[A-Z0-9]+"};

Parameter bdAddress0 = {"bd_addr_part0", 1, 0, "[A-Z0-9:]+"};
Parameter bdAddress1 = {"bd_addr_part1", 1, 1, "[A-Z0-9:]+"};
Parameter bdPass0 = {"bd_pass_part0", 1, 2, "[a-z0-9]+"};

Parameter serialBaudrate = {"serial_baudrate", 2, 0, "1200|2400|4800|9600|19200|115200"};
Parameter audioBitrate = {"audio_bitrate", 2, 1, "32|96|128|160|192|256|320"};
Parameter sleepPeriod = {"sleep_period", 2, 2, "100|500|1000|5000|10000"};

Parameter parity = {"serial_parity", 3, 0, "78|69|79"};
Parameter dataBit = {"serial_data_bit", 3, 1, "5|6|7|8"};
Parameter stopBit = {"serial_stop_bit", 3, 2, "0|1"};

Parameter bdPassPart1 = {"bd_pass_part1", 4, 0, "[a-z0-9]+"};
Parameter romChecksumPart0 = {"rom_checksum_part0", 4, 1, "[a-z0-9]+"};
Parameter romChecksumPart1 = {"rom_checksum_part1", 4, 2, "[a-z0-9]+"};


Parameter *parameters[15] = {
        &deviceName,
        &romRevision,
        &serialNumber,
        &bdAddress0,
        &bdAddress1,
        &bdPass0,
        &serialBaudrate,
        &audioBitrate,
        &sleepPeriod,
        &parity,
        &dataBit,
        &stopBit,
        &bdPassPart1,
        &romChecksumPart0,
        &romChecksumPart1,
};

uint8_t getParameterSegmentNum(char *name) {
    for (int i = 0; i < LEN_OF_PARAMETERS; ++i) {
        if (!strcmp(parameters[i]->Name, name)) {
            return parameters[i]->SegmentNum;
        }
    }
    return -1;
}

uint8_t getParameterPositionInSegment(char *name) {
    for (int i = 0; i < LEN_OF_PARAMETERS; ++i) {
        if (!strcmp(parameters[i]->Name, name)) {
            return parameters[i]->PositionInSegment;
        }
    }
    return -1;
}

char* getParameterRegex(char *name) {
    for (int i = 0; i < LEN_OF_PARAMETERS; ++i) {
        if (!strcmp(parameters[i]->Name, name)) {
            return parameters[i]->Regex;
        }
    }
    return "";
}

int isValidValueForParameter(char *paramName, char *value) {
    char * regexStr = getParameterRegex(paramName);

    int rv;
    regex_t exp;

    rv = regcomp(&exp, regexStr, REG_EXTENDED);
    if (rv != 0) {
        write(2, "The regex failed to compile!\n", 35);
        exit(-1);
    }

    regmatch_t matches[1];

    if (regexec(&exp, value, 1, matches, 0) != 0 || matches[0].rm_so != 0 || matches[0].rm_eo != strlen(value)) {
        regfree(&exp);
        return 0;
    }

    regfree(&exp);
    return 1;
}

#endif //EXAMPLE_PARAMETER_H
