using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace _96.STOP
{
    class Program
    {
        static void Main(string[] args)
        {
            var n = int.Parse(Console.ReadLine());

            Console.Write(new string('.', n + 1));
            Console.Write(new string('_', 2 * n + 1));
            Console.WriteLine(new string('.', n + 1));

            int a = n;
            int b = 2 * n - 1;
            for (int i = 1; i <= n; i++)
            {
                Console.Write(new string('.', a));
                Console.Write("//");
                Console.Write(new string('_', b));
                Console.Write("\\\\");
                Console.Write(new string('.', a));
                Console.WriteLine();
                a = a - 1;
                b = b + 2;
            }

            Console.Write("//");
            Console.Write(new string('_', 2 * n - 3));
            Console.Write("STOP!");
            Console.Write(new string('_', 2 * n - 3));
            Console.WriteLine("\\\\");

            int c = 4 * n - 1;
            for (int i = 1; i <= n; i++)
            {
                Console.Write(new string('.', i - 1));
                Console.Write("\\\\");
                Console.Write(new string('_', c));
                Console.Write("//");
                Console.Write(new string('.', i - 1));
                Console.WriteLine();
                c = c - 2;
            }
        }
    }
}
