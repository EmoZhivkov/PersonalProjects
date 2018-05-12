using System;

namespace _19.CelsiusToFahrenheit
{
    class CelsiusToFahrenheit
    {
        static void Main(string[] args)
        {
            var cel = double.Parse(Console.ReadLine());
            var far = cel * 1.8000 + 32;
            Console.WriteLine(Math.Round(far, 2));
        }
    }
}
