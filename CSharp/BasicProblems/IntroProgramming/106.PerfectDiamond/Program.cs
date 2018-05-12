using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace _106.PerfectDiamond
{
    class Program
    {
        static void Main(string[] args)
        {
            var n = int.Parse(Console.ReadLine());
            if (n == 1)
            {
                Console.WriteLine("*");
            }
            else
            {
                Console.Write(new string(' ', n - 1));
                Console.Write("*");
                Console.WriteLine(new string(' ', n - 1));
               
                for (int i = 2; i <= n; i++)
                {
                    Console.Write(new string(' ', n - i));
                    Console.Write("*");
                    for (int y = 1; y <= i - 1; y++)
                    {
                        Console.Write("-*");
                    }
                    Console.WriteLine();
                }

                for (int i = 1; i < n - 1; i++)
                {
                    Console.Write(new string(' ', i));
                    Console.Write("*");

                    for (int y = 1; y < n - i; y++)
                    {
                        Console.Write("-*");
                    }
                    Console.WriteLine();
                }

                Console.Write(new string(' ', n - 1));
                Console.Write("*");
                Console.WriteLine(new string(' ', n - 1));
            }
        }
    }
}
