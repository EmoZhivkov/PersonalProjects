using System;

namespace _34.MetricConverter
{
    class Program
    {
        static void Main(string[] args)
        {
            var a = double.Parse(Console.ReadLine());
            string fromUnit = Console.ReadLine();
            string toUnit = Console.ReadLine();

            var factor = 0.0;

            if (fromUnit == "km")
            {
                factor = 1 / 0.001;
            }
            else if (fromUnit == "mm")
            {
                factor = 1 / 1000.0;
            }
            else if (fromUnit == "cm")
            {
                factor = 1 / 100.0;
            }
            else if (fromUnit == "mi")
            {
                factor = 1 / 0.000621371192;
            }
            else if (fromUnit == "in")
            {
                factor = 1 / 39.3700787;
            }
            else if (fromUnit == "ft")
            {
                factor = 1 / 3.2808399;
            }
            else if (fromUnit == "yd")
            {
                factor = 1 / 1.0936133;
            }
            else if (fromUnit == "m")
            {
                factor = 1;
            }



            if (toUnit == "km")
            {
                factor = factor * 0.001;
            }
            else if (toUnit == "mm")
            {
                factor = factor * 1000.0;
            }
            else if (toUnit == "cm")
            {
                factor = factor * 100.0;
            }
            else if (toUnit == "mi")
            {
                factor = factor * 0.000621371192;
            }
            else if (toUnit == "in")
            {
                factor = factor * 39.3700787;
            }
            else if (toUnit == "ft")
            {
                factor = factor * 3.2808399;
            }
            else if (toUnit == "yd")
            {
                factor = factor * 1.0936133;
            }
            else if (toUnit == "m")
            {
                factor = factor * 1;
            }

            Console.WriteLine(a * factor);
        }
    }
}
