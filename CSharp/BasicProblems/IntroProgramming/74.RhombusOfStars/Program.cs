using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace _74.RhombusOfStars
{
    class Program
    {
        static void Main(string[] args)
        {
            var n = int.Parse(Console.ReadLine());

            for (int row = 1; row <= n; row++)
            {
                Console.Write(new string(' ', n - row));
                Console.Write("*");

                for (int y = 0; y < row - 1; y++)
                {
                    Console.Write(" *");
                }

                Console.WriteLine();
            }

            for (int row = 1; row <= n - 1; row++)
            {
                Console.Write(new string (' ', row));
                Console.Write("*");

                for (int i = 0; i <  n - (row + 1); i++)
                {
                    Console.Write(" *");
                }

                Console.WriteLine();
            }

        }
    }
}
