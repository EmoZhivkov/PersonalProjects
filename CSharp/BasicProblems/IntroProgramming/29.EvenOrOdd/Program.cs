using System;


namespace _29.EvenOrOdd
{
    class Program
    {
        static void Main(string[] args)
        {
            var a = int.Parse(Console.ReadLine());

            if (a % 2 == 0)
            { Console.WriteLine("even"); }
            else
            { Console.WriteLine("odd"); }
        }
    }
}
