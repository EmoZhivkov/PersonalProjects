#ifndef STRING_H
#define STRING_H
#include<iostream>

class String
{
private:
	char * str;
	void copyString(const String& str);
	void clearString();
	void setString(const char * str);
public:
	String();
	String(const char* str);
	String(const String& str);
	~String();
	String& operator=(const String& str);
	bool operator==(const String & s) const;
	String operator+(const String& s);

	friend std::ostream& operator<<(std::ostream& out, const String& s);
	friend std::istream& operator>>(std::istream& in, String& s);
};

#endif // !STRING_H