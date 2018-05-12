using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace _85.Sequence2k_1
{
    class Program
    {
        static void Main(string[] args)
        {
            var n = int.Parse(Console.ReadLine());
            var number = 1;

            while(number <= n)
            {
                Console.WriteLine(number);
                number = 2 * number + 1;
            }
        }
    }
}
