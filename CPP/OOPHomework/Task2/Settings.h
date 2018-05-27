#pragma once
#include "Pair.h"
#include <iostream>

template <class T>
class Settings
{
private:
	Pair<T> * container;
	int currentPairCount;
	int resizeCounter;

	void setContainer(Pair<T> *temp, int currentPairCount);
	void clearSettings();
	void copySettings(const Settings& temp);
	bool compareKeys(const char* key1,const char* key2);
public:
	Settings<T>();
	Settings<T>(const Settings& temp);
	Settings<T>& operator=(const Settings<T>& temp);
	~Settings<T>();

	int count();
	void set(const char* key, T value);
	bool get(const char* key, T& value);
};

template<class T>
inline void Settings<T>::setContainer(Pair<T>* temp, int currentPairCount)
{
	delete[] this->container;
	this->container = new Pair<T>[(30 * this->resizeCounter) + 1];
	for (int i = 0; i < currentPairCount; i++)
	{
		this->container[i] = temp[i];
	}
}

template<class T>
inline void Settings<T>::clearSettings()
{
	delete[] this->container;

}

template<class T>
inline void Settings<T>::copySettings(const Settings & temp)
{
	this->currentPairCount = temp.currentPairCount;
	this->resizeCounter = temp.resizeCounter;
	this->setContainer(temp.container, temp.currentPairCount);
}

template<class T>
inline bool Settings<T>::compareKeys(const char * key1,const char * key2)
{
	bool b = true;

	if (strlen(key1) != strlen(key2))
	{
		b = false;
	}
	else
	{
		if (strlen(key1) < 0)
		{
			b = false;
		}
		else
		{
			for (unsigned int i = 0; i < strlen(key1); i++)
			{
				if (key1[i] != key2[i])
				{
					b = false;
					break;
				}
			}
		}
		
	}
	return b;
}

template <class T>
inline Settings<T>::Settings()
{
	this->container = new Pair<T>[31];
	this->resizeCounter = 1;
	this->currentPairCount = 0;
}

template<class T>
inline Settings<T>::Settings(const Settings & temp)
{
	this->copySettings(temp);
}

template<class T>
inline Settings<T>& Settings<T>::operator=(const Settings<T>& temp)
{
	if (this != &temp)
	{
		this->clearSettings();
		this->copySettings(temp);
	}
}

template<class T>
inline Settings<T>::~Settings()
{
	this->clearSettings();
}

template<class T>
inline int Settings<T>::count()
{
	return this->currentPairCount;
}

template<class T>
inline void Settings<T>::set(const char * key, T value)
{
	Pair<T> *currentPair = new Pair<T>();
	bool b = false;
	
	for (int i = 0; i < this->currentPairCount; i++)
	{
		*currentPair = this->container[i];
		if (this->compareKeys(currentPair->getKey(), key))
		{
			b = true;
			break;
		}
	}

	
	if (b)
	{
		currentPair->setValue(value);	
	}
	else
	{

		//TODO tuka se chupi mnogo moshtno, nqmam ideq zashto ne bachka
		cout << "//////" << endl;
		this->container[this->currentPairCount] = *currentPair;
		cout << "//////" << endl;
		this->currentPairCount++;

		if (this->currentPairCount % (30 * this->resizeCounter) == 1)
		{
			
			Pair<T> *temporary = new Pair<T>[(30 * this->resizeCounter) + 1];
			for (int i = 0; i < (30 * this->resizeCounter) + 1; i++)
			{
				temporary[i] = this->container[i];
			}
			delete[] this->container;

			this->container = new Pair<T>[(30 * ((currentPairCount / 30) + 1)) + 1];

			for (int i = 0; i < (30 * this->resizeCounter) + 1; i++)
			{
				this->container[i] = temporary[i];
			}
			delete[] temporary;
			this->resizeCounter++;
		}
	}
}

template<class T>
inline bool Settings<T>::get(const char * key, T & value)
{
	bool b = false;
	for (int i = 0; i < this->currentPairCount; i++)
	{
		Pair<T> currentPair = this->container[i];
		if (this->compareKeys(currentPair.getKey(), key))
		{
			value = currentPair.getValue();
			b = true;
			break;
		}
	}
	return b;
}

