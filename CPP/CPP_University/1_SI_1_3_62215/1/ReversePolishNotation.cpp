#include <iostream>
#include "Stack.h"

bool isOperator(char a){
    for (int i = 0; i < 5; ++i) {
        if (a == '+' || a == '-'|| a == '*' || a == '/' || a == '%') {
            return true;
        }
    }
    return false;
}

bool isNumber(char a){
    if ((int)a >= 48 && (int)a <= 57) {
        return true;
    }
    return false;
}

int toNumber(char a){
    int num = 0;
    switch ((int) a) {
        case 48 : num = 0;
            break;
        case 49 : num = 1;
            break;
        case 50 : num = 2;
            break;
        case 51 : num = 3;
            break;
        case 52 : num = 4;
            break;
        case 53 : num = 5;
            break;
        case 54 : num = 6;
            break;
        case 55 : num = 7;
            break;
        case 56 : num = 8;
            break;
        case 57 : num = 9;
            break;
    }
    return num;
}

double performOperation(double firstOperand, char currentOperator, double secondOperand){
    double calculation = 0;
    if (currentOperator == '+') {
        calculation = firstOperand + secondOperand;
    }else if (currentOperator == '-'){
        calculation = firstOperand - secondOperand;
    }else if (currentOperator == '*'){
        calculation = firstOperand * secondOperand;
    }else if (currentOperator == '/'){
        calculation = firstOperand / secondOperand;
    }else if (currentOperator == '%'){
        calculation = (int)firstOperand % (int)secondOperand;
    }
    return calculation;
}

double calculate(char input[]) {
    double calculation = 0;
    Stack temp;
    Stack individualNumber;
    for (int i = 0; i < strlen(input); i++) {
        if (isNumber(input[i])) {
            individualNumber.push(toNumber(input[i]));
        }else if(input[i] == ' ' && !isOperator(input[i - 1])) {
            int number = 0;
            int multiplier = 1;
            while (!individualNumber.empty()) {
                number = number + individualNumber.pop() * multiplier;
                multiplier = multiplier*10;
            }
            temp.push(number);
        } else if (isOperator(input[i])) {
            double secondOperand = temp.pop();
            double firstOperand = temp.pop();

            calculation = performOperation(firstOperand, input[i], secondOperand);
            temp.push(calculation);
        }
    }
    return calculation;
}

int main() {
    char arr[] = {"25 1 2 + 4 * + 31 -"};
    std::cout << calculate(arr) << std::endl;
    return 0;
}