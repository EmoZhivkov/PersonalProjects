using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace _08.IsTheNumberPrime
{
    class Program
    {
        static void Main(string[] args)
        {
            var num = int.Parse(Console.ReadLine());

            if (num == 1 || num == 0)
            {
                Console.WriteLine("The number is not prime");
                return;
            }
            else if (num == 2 || num == 3)
            {
                Console.WriteLine("The number is prime");
                return;
            }
            else
            {
                for (int a = 2; a <= num; a++)
                {
                    if (num % a == 0 && a == num)
                    {
                        Console.WriteLine("The number is prime");
                        break;
                    }
                    else if (num % a == 0 && a != num)
                    {
                        Console.WriteLine("The number is not prime");
                        break;
                    }
                 }
             }
        }
    }
}
