#include "String.h"

#include<iostream>

String::String()
{
	setString("");
}

String::String(const char * str)
{
	setString(str);
}


String::String(const String & str)
{
	copyString(str);
}

String::~String()
{
	clearString();
}

String & String::operator=(const String & str)
{
	if (this != &str)
	{
		clearString();
		copyString(str);
	}

	return *this;
}

bool String::operator==(const String & s) const
{
	int lengthFirst = strlen(str);
	int lengthSecond = strlen(s.str);
	
	if (lengthFirst != lengthSecond)
		return false;

	for (int i = 0; i < lengthFirst; i++)
	{
		if (str[i] != s.str[i])
			return false;
	}

	return true;
}

String String::operator+(const String & s)
{
	int lengthFirst = strlen(str);
	int lengthSecond = strlen(s.str);

	char * container = new char[lengthFirst + lengthSecond + 1];

	for (int i = 0; i < lengthFirst; i++)
	{
		container[i] = str[i];
	}

	for (int i = lengthFirst; i < lengthSecond; i++)
	{
		container[i] = str[i];
	}

	return String(container);
}

void String::copyString(const String & str)
{
	setString(str.str);
}

void String::clearString()
{
	delete[] str;
}

void String::setString(const char * str)
{
	int length = strlen(str) + 1;
	this->str = new char[length];
	strcpy_s(this->str, length, str);
}

std::ostream & operator<<(std::ostream & out, const String & s)
{
	out << s.str;

	return out;
}

std::istream & operator>>(std::istream & in, String & s)
{
	s.clearString();
	s.str = new char[256];

	in.getline(s.str, 256);
	
	return in;
}
