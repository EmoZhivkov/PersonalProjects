using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace _97.SpecialNumbers
{
    class Program
    {
        static void Main(string[] args)
        {
            var n = int.Parse(Console.ReadLine());

            for (int i = 1111; i <= 9999; i++)
            {
                int first = i % 10;
                int second = (i / 10) % 10;
                int third = (i / 100) % 10;
                int fourth = (i / 1000) % 10;

                if (first == 0 || second == 0 || third == 0 || fourth == 0)
                {
                    continue;
                }
                if (n % first == 0 && n % second == 0 && n % third == 0 && n % fourth ==0)
                {
                    Console.Write(i + " ");
                }
            }
        }
    }
}
