using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace _49.InvalidNumber
{
    class Program
    {
        static void Main(string[] args)
        {
            var a = double.Parse(Console.ReadLine());

            if (a == 0)
            {
               
            }
            else if (a < 100 || a > 200)
            {
                Console.WriteLine("invalid");
            }
            else if (a > 100 || a < 200)
            {
 
            }
        }
    }
}
