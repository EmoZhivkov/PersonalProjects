cmake_minimum_required(VERSION 3.13)
project(example C)

set(CMAKE_C_STANDARD 99)

add_executable(example main.c Parameter.h BitManipulation.h Segment.h Command.h)