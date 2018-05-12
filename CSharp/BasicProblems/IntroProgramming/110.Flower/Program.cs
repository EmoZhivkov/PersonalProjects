using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace _110.Flower
{
    class Program
    {
        static void Main(string[] args)
        {
            var n = int.Parse(Console.ReadLine());
            int j = 0;
            for (int i = 0; i < n; i++)
            {
                Console.Write("#");
                Console.Write(new string('~', i));
                Console.Write("#");
                Console.Write(new string('.', (2 * n) - (2 * i)));
                Console.Write("#");
                Console.Write(new string('.', j));
                Console.Write("#");
                Console.Write(new string('.', (2 * n) - (2 * i)));
                Console.Write("#");
                Console.Write(new string('~', i));
                Console.WriteLine("#");
                j += 2;
            }

            j = 1;
            for (int i = 0; i <= n; i++)
            {
                Console.Write(new string('.', j));
                Console.Write("#");
                Console.Write(new string('~', n - i));
                Console.Write("#");
                Console.Write(new string('.', (2 * n) - (2 * i)));
                Console.Write("#");
                Console.Write(new string('~', n - i));
                Console.Write("#");
                Console.WriteLine(new string('.', j));
                j += 2;
            }

            for (int i = 0; i < n; i++)
            {
                Console.Write(new string('.', 2 * n + 2));
                Console.Write("##");
                Console.WriteLine(new string('.', 2 * n + 2));
            }
        }
    }
}
