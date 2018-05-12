using System;

namespace _33.SumSeconds
{
    class Program
    {
        static void Main(string[] args)
        {
            var first = int.Parse(Console.ReadLine());
            var second = int.Parse(Console.ReadLine());
            var third = int.Parse(Console.ReadLine());
            var sum = first + second + third;

            var minutes = sum / 60;
            var seconds = sum % 60;

            Console.WriteLine("{0}:{1:D2}", minutes, seconds);

        }
    }
}
