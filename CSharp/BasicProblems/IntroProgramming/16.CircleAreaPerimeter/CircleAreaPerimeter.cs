using System;


namespace _16.CircleAreaPerimeter
{
    class CircleAreaPerimeter
    {
        static void Main(string[] args)
        {
            var r = double.Parse(Console.ReadLine());
            var s = Math.PI * r * r;
            var p = 2 * Math.PI * r;
            Console.WriteLine("Area = " + s);
            Console.WriteLine("Perimeter = " + p);
        }
    }
}
