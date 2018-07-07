# Vehicles

#pragma once
class Vehicle
{
public:
	Vehicle(const char* make="", const char* model = "", const char* color="",
		int year = 1990, double mileage = 0.0);
	Vehicle(const Vehicle& v);
	Vehicle& operator=(const Vehicle& v);
	virtual ~Vehicle();

	void setMake(const char* make);
	void setModel(const char* model);
	void setColor(const char* color);
	void setYear(int year) { m_year = year; }
	void setMileage(double mileage) { m_mileage = mileage; }

	char* getMake() const { return m_make; }
	char* getModel() const { return m_model; }
	char* getColor() const { return m_color; }
	int getYear() const { return m_year; }
	double getMileage() const { return m_mileage; }

	virtual void details() const = 0;

private:
	void Destroy();
	void Copy(const Vehicle& v);
	char* m_make;
	char* m_model;
	char* m_color;
	int m_year;
	double m_mileage;
};

