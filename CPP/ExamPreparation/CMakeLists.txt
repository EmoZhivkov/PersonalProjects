cmake_minimum_required(VERSION 3.10)
project(ExamPreparation)

set(CMAKE_CXX_STANDARD 11)

add_executable(ExamPreparation main.cpp Company.cpp Company.h PrivateCompany.cpp PrivateCompany.h StateOwnedCompany.cpp StateOwnedCompany.h Consortium.cpp Consortium.h)