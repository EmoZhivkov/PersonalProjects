cmake_minimum_required(VERSION 3.13)
project(ClientServer C)

set(CMAKE_C_STANDARD 99)

add_executable(ClientServer Client.c Server.c Comm.h)