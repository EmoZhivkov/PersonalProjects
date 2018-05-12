using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace _10.FiveNumbers
{
    class Program
    {
        static void Main(string[] args)
        {
            var a = int.Parse(Console.ReadLine());
            var b = int.Parse(Console.ReadLine());
            var c = int.Parse(Console.ReadLine());
            var d = int.Parse(Console.ReadLine());
            var e = int.Parse(Console.ReadLine());
            int y = 0;

            if (a < 0) 
            {
                Console.WriteLine("Invalid number! Please enter a new number.");
                y = int.Parse(Console.ReadLine());
                Console.WriteLine("Sum: " +  (b + c + d + e + y));
                return;
            }
            else if (b < 0)
            {
                Console.WriteLine("Invalid number! Please enter a new number.");
                y = int.Parse(Console.ReadLine());
                Console.WriteLine("Sum: " + (a + c + d + e + y));
                return;
            }
            else if (c < 0)
            {
                Console.WriteLine("Invalid number! Please enter a new number.");
                y = int.Parse(Console.ReadLine());
                Console.WriteLine("Sum: " + (a + b + d + e + y));
                return;
            }
            else if (d < 0)
            {
                Console.WriteLine("Invalid number! Please enter a new number.");
                y = int.Parse(Console.ReadLine());
                Console.WriteLine("Sum: " + (a + b + c + e + y));
                return;
            }
            else if (e < 0)
            {
                Console.WriteLine("Invalid number! Please enter a new number.");
                y = int.Parse(Console.ReadLine());
                Console.WriteLine("Sum: " + (a + b + d + c + y));
                return;
            }
            Console.WriteLine("Sum: " + (a + b + d + c + e));
        }
    }
}
