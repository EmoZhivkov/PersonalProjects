using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace _07.NumbersABCD
{
    class Program
    {
        static void Main(string[] args)
        {
            var num = int.Parse(Console.ReadLine());
            var a = num / 1000;
            a = a % 10;
            var b = num / 100;
            b = b % 10;
            var c = num / 10;
            c = c % 10;
            var d = num % 10;

            Console.WriteLine(a + b + c + d);
            Console.WriteLine(d.ToString() + (c) + (b) + (a));
            Console.WriteLine(d.ToString() + (a) + (b) + (c));
            Console.WriteLine(a.ToString() + (c) + (b) + (d));
        }
    }
}
