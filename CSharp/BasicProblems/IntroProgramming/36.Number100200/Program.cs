using System;

namespace _36.Number100200
{
    class Program
    {
        static void Main(string[] args)
        {
            var a = int.Parse(Console.ReadLine());
            if (a < 100)
            {
                Console.WriteLine("Less than 100");
            }
            else if (a >= 100 && a <= 200)
            {
                Console.WriteLine("Between 100 and 200");
            }
            else if (a >= 200)
            {
                Console.WriteLine("Greater than 200");
            }
        }
    }
}
