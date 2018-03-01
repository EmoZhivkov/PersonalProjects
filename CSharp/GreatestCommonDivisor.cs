using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace ConsoleApp1
{
    class Program
    {
        static void Main()
        {
            //Euclid's Algorithm
            int a = int.Parse(Console.ReadLine());
            int b = int.Parse(Console.ReadLine());

            int remainder = 0;
            if (a >= b)
            {
                while (b != 0)
                {
                    remainder = a % b;
                    a = b;
                    b = remainder;

                }
                Console.WriteLine(a);
            }
            else
            {
                while (a != 0)
                {
                    remainder = b % a;
                    b = a;
                    a = remainder;

                }
                Console.WriteLine(b);
            }
        }
    }
}

