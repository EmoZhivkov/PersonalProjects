using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace _79.DrawFort
{
    class Program
    {
        static void Main(string[] args)
        {
            var n = int.Parse(Console.ReadLine());
            if (n == 3 || n == 4)
            {
                Console.Write("/" + new string('^', n / 2) + "\\");
                Console.WriteLine("/" + new string('^', n / 2) + "\\");

                for (int row = 0; row < n - 3; row++)
                {
                    Console.WriteLine("|" + new string(' ', 2 * n - 2) + "|");
                }

                Console.WriteLine("|" + new string(' ', (n / 2) + 1) + new string(' ', (n / 2) + 1) + "|");
                Console.WriteLine("\\" + new string('_', n / 2) + "/" + "\\" + new string('_', n / 2) + "/");
                
            }
            else
            {
                Console.Write("/" + new string('^', n / 2) + "\\");
                Console.Write(new string('_', n * 2 - 4 - 2 * (n / 2)));
                Console.WriteLine("/" + new string('^', n / 2) + "\\");

                for (int row = 0; row < n - 3; row++)
                {
                    Console.WriteLine("|" + new string(' ', 2 * n - 2) + "|");
                }

                Console.WriteLine("|" + new string(' ', (n / 2) + 1) + new string('_', n * 2 - 4 - 2 * (n / 2)) + new string(' ', (n / 2) + 1) + "|");
                Console.WriteLine("\\" + new string('_', n / 2) + "/" + new string(' ', n * 2 - 4 - 2 * (n / 2)) + "\\" + new string('_', n / 2) + "/");
            }
        }
    }
}
