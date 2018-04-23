#include <iostream>
#include "Stack.h"

void Stack::push(int value) {
    if (full()) {
        std::cout<<"The Stack is full!"<< std::endl;
        return;
    }
    this -> top++;
    this -> arr[top] = value;
}

double Stack::pop() {
    if (empty()) {
        std::cout << "The Stack is empty"<< std::endl;
        return 0;
    }
    this->top--;
    return this->arr[top + 1];
}

double Stack::peek() {
    if (empty()) {
        std::cout<<"The Stack is empty"<< std::endl;
        return 0;
    }
    return this -> arr[top];
}

bool Stack::empty() {
    return this -> top == -1;
}

bool Stack::full() {
    return this-> top == 100 - 1;
}
