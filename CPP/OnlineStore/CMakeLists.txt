cmake_minimum_required(VERSION 3.10)
project(OnlineStore)

set(CMAKE_CXX_STANDARD 11)

add_executable(OnlineStore main.cpp Store.cpp Store.h Product.cpp Product.h)