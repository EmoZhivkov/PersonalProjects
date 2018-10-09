/*
 * Дадени са два низа a и b, съставени от малки латински букви. Напишете програма substring, която намира низът с най-голяма дължина, който е едновременно подниз на пермутация на a и подниз на пермутация на b. Под „пермутация на низ” ще разбираме низ със същата дължина, включващ символите на изходния в някакъв ред. Под „подниз на низ” ще разбираме низ, съставен от ненулев брой последователни символи на дадения.

Input Format

От стандартния вход се въвеждат двата низа, всеки на отделен ред. Максималната дължина на всеки от тях е 1000 символа.

Constraints

До 1000 символа

Output Format

На единствения ред на стандартния изход се извежда търсеният низ. Ако има повече от един низ с най-голяма дължина, отговарящ на условието, да се изведе наймалкият в лексикографската им подредба.

Пример

Вход

autumn

tournament

Изход amntu

Обяснение на примера Даденият низ е подниз на пермутацията на a uamntu и пермутацията на b ornamntuet.
 * */

#include <iostream>
#include <algorithm>
using namespace std;

void eraseSubStr(std::string & mainStr, const std::string & toErase)
{
    size_t pos = mainStr.find(toErase);

    if (pos != std::string::npos)
    {
        mainStr.erase(pos, toErase.length());
    }
}

int main() {
    string first;
    string second;
    string answer;

    cin >> first;
    cin >> second;

    if (first.length() < second.length()) {
        for (int i = 0; i < first.length(); ++i) {

            string currentChar = string(1, first[i]);

            if (second.find(currentChar) != string::npos) {
                eraseSubStr(second,currentChar);
                answer += currentChar;
            }
        }
    } else  {
        for (int i = 0; i < second.length(); ++i) {

            string currentChar = string(1, second[i]);

            if (first.find(currentChar) != string::npos) {
                eraseSubStr(first, currentChar);
                answer += currentChar;
            }
        }
    }

    sort(answer.begin(), answer.end());

    cout << answer << endl;
    return 0;
}