using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace _09.TwoIntegersBetween
{
    class Program
    {
        static void Main(string[] args)
        {
            var a = int.Parse(Console.ReadLine());
            var b = int.Parse(Console.ReadLine());
            int z = 0;

            for (int c = a; c <= b; c++)
            {
                if (c % 5 == 0)
                {
                    z = z + 1;
                }
                
            }
            Console.WriteLine(z);
        }
    }
}
