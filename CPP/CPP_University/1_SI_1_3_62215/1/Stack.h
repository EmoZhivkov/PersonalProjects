#ifndef REVERSEPOLISHNOTATION_STACK_H
#define REVERSEPOLISHNOTATION_STACK_H

class Stack
{
private:
    double arr[100];
    int top = -1;
public:
    void push(int value);
    double pop();
    double peek();
    bool empty();
    bool full();
};

#endif