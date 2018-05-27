#pragma once
#include <iostream>

template <class T>
class Pair
{
private:
	T value;
	char* key;

	void copyPair(const Pair<T>& temp);
	void clearPair();

	void setKey(const char* temp);

public:
	
	Pair<T>();
	Pair<T>(const char* key, T value);
	Pair<T>(const Pair<T>& temp);

	Pair<T>& operator=(const Pair& temp);
	~Pair<T>();

	char* getKey() const;
	T getValue() const;

	void setValue(T temp);
};

template<class T>
inline void Pair<T>::copyPair(const Pair& temp)
{
	this->setValue(temp.value);
	this->setKey(temp.key);

}

template<class T>
inline void Pair<T>::clearPair()
{
	delete[] this->key;
}

template<class T>
inline void Pair<T>::setKey(const char * temp)
{
	delete[] this->key;
	int lenght = strlen(temp) + 1;
	this->key = new char[lenght];
	memcpy(this->key, temp, lenght);
}

template<class T>
inline Pair<T>::Pair() {
	this->key = nullptr;
}

template<class T>
inline Pair<T>::Pair(const char * key, T value)
{
	this->value = value;
	this->setKey(key);
}

template<class T>
inline Pair<T>::Pair(const Pair<T>& temp)
{
	this->copyPair(temp);
}

template<class T>
inline Pair<T>& Pair<T>::operator=(const Pair& temp)
{
	if (this != &temp)
	{
		this->copyPair(temp);
	}
	return *this;
}

template<class T>
inline Pair<T>::~Pair()
{
	this->clearPair();
}

template<class T>
inline char * Pair<T>::getKey() const
{
	return this->key;
}

template<class T>
inline T Pair<T>::getValue() const
{
	return this->value;
}

template<class T>
inline void Pair<T>::setValue(T  temp)
{
	this->value = temp;
}