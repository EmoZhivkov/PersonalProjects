#include <stdio.h>
#include <string.h>
#include "Parameter.h"
#include "BitManipulation.h"
#include "Segment.h"
#include "Command.h"

// TODO: Add adequate error handling in the main method
int main(int argc, char **argv) {
    initCommands();

    if (argc < 2) {
        write(2, "Invalid arguments!\n", 30);
        exit(-1);
    }

    if (argc == 2) {
        char *arg = argv[1];
        if (strlen(arg) == 2) {
            char command = arg[1];
            if (commands[command] == NULL) {
                write(2, "Not supported argument!\n", 30);
                exit(-1);
            }

            (commands[command])(argc, argv);
        } else {
            write(2, "Invalid arguments!\n", 30);
            exit(-1);
        }
    } else {
        char *arg = argv[2];
        if (strlen(arg) == 2) {
            char command = arg[1];
            if (commands[command] == NULL) {
                write(2, "Not supported argument!\n", 30);
                exit(-1);
            }

            (commands[command])(argc, argv);
        } else {
            write(2, "Invalid arguments!\n", 30);
            exit(-1);
        }
    }
}