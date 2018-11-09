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