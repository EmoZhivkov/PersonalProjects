using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace _05.Diamond
{
    class Program
    {
        static void Main(string[] args)
        {
            var n = int.Parse(Console.ReadLine());

            Console.Write(new string('.', n));
            Console.Write(new string('*', 3 * n));
            Console.WriteLine(new string('.', n));

            int j = 3 * n;
            for (int i = 1; i < n; i++)
            {
                Console.Write(new string('.', n - i));
                Console.Write("*");
                Console.Write(new string('.', j));
                Console.Write("*");
                Console.WriteLine(new string('.', n - i));
                j += 2;
            }

            Console.WriteLine(new string('*', 5 * n));


            j = (5 * n) - 4;
            for (int i = 1; i <= 2 * n; i++)
            {
                Console.Write(new string('.', i));
                Console.Write("*");
                Console.Write(new string('.', j));
                Console.Write("*");
                Console.WriteLine(new string('.', i));

                j -= 2;
            }

            Console.Write(new string('.', (2 * n) + 1));
            Console.Write(new string('*', n - 2));
            Console.WriteLine(new string('.', (2 * n) + 1));
            
        }
    }
}
