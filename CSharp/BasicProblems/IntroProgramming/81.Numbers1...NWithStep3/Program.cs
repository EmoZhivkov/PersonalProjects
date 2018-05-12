using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace _81.Numbers1._._.NWithStep3
{
    class Program
    {
        static void Main(string[] args)
        {
            var n = int.Parse(Console.ReadLine());

            for (int i = 1; i <= n; i = i + 3)
            {
                Console.WriteLine(i);
            }
        }
    }
}
