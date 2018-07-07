#ifndef VECTOR_H
#define VECTOR_H

#include<exception>

template<typename T>
class Vector
{
private:
	T * container;
	int capacity;
	int size;

	void copyObject(const Vector& v);
	void freeMemory();

	void moveElements(T * target, T * source);
	void Resize();
	void swapToBack(int index);
public:
	Vector();
	Vector(const Vector& v);
	~Vector();
	Vector& operator=(const Vector& v);

	T& operator[](const int index) const;

	void erase(int index);
	void pushBack(const T& element);
	int getSize() const { return size; }
};

#endif // !VECTOR_H

template<typename T>
inline Vector<T>::Vector()
{
	size = 0;
	capacity = 1;
	container = new T[capacity];
}

template<typename T>
inline Vector<T>::Vector(const Vector & v)
{
	copyObject(v);
}

template<typename T>
inline Vector<T>::~Vector()
{
	freeMemory();
}

template<typename T>
inline Vector<T> & Vector<T>::operator=(const Vector<T> & v)
{
	if (this != &v)
	{
		freeMemory();
		copyObject(v);
	}

	return *this;
}

template<typename T>
inline T & Vector<T>::operator[](const int index) const
{
	if (index < 0 || index >= size)
	{
		throw std::out_of_range("Index out of range.");
	}

	return container[index];
}

template<typename T>
inline void Vector<T>::erase(int index)
{
	if (index < 0 || index >= size)
	{
		throw std::out_of_range("Index out of range.");
	}

	swapToBack(index);
	size--;
}

template<typename T>
inline void Vector<T>::pushBack(const T & element)
{
	if (capacity == size)
	{
		Resize();
	}

	container[size++] = element;
}

template<typename T>
inline void Vector<T>::copyObject(const Vector<T>& v)
{
	size = v.size;
	capacity = v.capacity;

	container = new T[capacity];
	moveElements(container, v.container);
}

template<typename T>
inline void Vector<T>::freeMemory()
{
	delete[] container;
}

template<typename T>
inline void Vector<T>::moveElements(T * target, T * source)
{
	for (int i = 0; i < size; i++)
	{
		target[i] = source[i];
	}
}

template<typename T>
inline void Vector<T>::Resize()
{
	capacity *= 2;

	T* newContainer = new T[capacity];
	moveElements(newContainer, container);

	freeMemory();
	container = newContainer;
}

template<typename T>
inline void Vector<T>::swapToBack(int index)
{
	for (index; index < size - 1; index++)
	{
		T temp = container[index];
		container[index] = container[index + 1];
		container[index + 1] = temp;
	}
}
