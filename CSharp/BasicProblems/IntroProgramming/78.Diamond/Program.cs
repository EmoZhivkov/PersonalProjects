using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace _78.Diamond
{
    class Program
    {
        static void Main(string[] args)
        {
            var n = int.Parse(Console.ReadLine());
            int i = n - 4;
            if (n == 1)
            {
                Console.WriteLine("*");
            }
            else if (n == 2)
            {
                Console.WriteLine("**");
            }
            else if(n % 2 == 0)
            {
                Console.WriteLine(new string('-', (n - 2) / 2) + "**" + new string('-', (n - 2) / 2));
                for (int row = 1; row <= n / 2 - 1; row++)
                {

                    Console.WriteLine(new string('-', (n / 2 - 1) - row) + "*" + new string('-', row * 2) + "*" + new string('-', (n / 2 - 1) - row));
                }

                for (int row = 1; row <= (n / 2) - 2; row++)
                {
                    Console.Write(new string('-', row) + "*");



                    Console.Write(new string('-', i)); 
                    i = i - 2;
                    Console.WriteLine("*" + new string('-', row));
                }
                Console.WriteLine(new string('-', (n - 2) / 2) + "**" + new string('-', (n - 2) / 2));
            }
            else
            {
                
                Console.WriteLine(new string('-', n / 2) + "*" + new string('-', n / 2));
                int y = 1;
                for (int row = 1; row <= (n / 2); row++)
                {

                    Console.Write(new string('-', Math.Abs((n / 2) - row)) + "*");
                    Console.Write(new string('-', y));
                    Console.WriteLine("*" + new string('-', Math.Abs((n / 2) - row)));
                    y = y + 2;
                }

                i = n - 4;
                for (int row = 1; row <= n / 2 - 1; row++)
                {
                    Console.Write(new string('-', row) + "*");
                    Console.Write(new string('-', i));
                    i = i - 2;
                    Console.WriteLine("*" + new string('-', row));
                }

                Console.WriteLine(new string('-', n / 2) + "*" + new string('-', n / 2));
            }
        }
    }
}
