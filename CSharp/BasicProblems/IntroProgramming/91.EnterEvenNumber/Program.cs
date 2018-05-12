using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace _91.EnterEvenNumber
{
    class Program
    {
        static void Main(string[] args)
        {
            var n = 1;
            while (n == 1)
            {
                try
                {
                    Console.Write("Enter even number: ");
                    n = int.Parse(Console.ReadLine());
                }
                catch
                {
                    Console.WriteLine("Invalid number!");
                }
            }
            while (n % 2 != 0)
            {

                try
                {
                    Console.WriteLine("The number is not even.");
                    if (n % 2 == 0)
                    {
                        break;
                    }
                    Console.Write("Enter even number: ");
                    n = int.Parse(Console.ReadLine());
                }
                catch
                {
                    Console.WriteLine("Invalid number!");
                }
            }


            Console.WriteLine("Even number entered: " + n);
        }
    }
}
