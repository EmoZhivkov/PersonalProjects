using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace _77.House
{
    class Program
    {
        static void Main(string[] args)
        {
            var n = int.Parse(Console.ReadLine());

            for ( int i = 1; i <= (n+1) / 2; i++)
            {
                int numberStars = 2 * i;
                if (n % 2 != 0)
                {
                    numberStars--;
                }
                int numberLine = (n - numberStars) / 2;

                Console.WriteLine(new string('-', numberLine) + new string('*', numberStars) + new string('-', numberLine));

            }

            for (int i = 0; i < n / 2; i++)
            {
                Console.WriteLine("|" + new string('*', n - 2) + "|");
            }
        }
    }
}
