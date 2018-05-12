using System;


namespace _20.RadiansToDegrees
{
    class RadiansToDegrees
    {
        static void Main(string[] args)
        {
            var rad = double.Parse(Console.ReadLine());
            var deg = rad * 180 / Math.PI;
            Console.WriteLine(Math.Round(deg));
        }
    }
}
