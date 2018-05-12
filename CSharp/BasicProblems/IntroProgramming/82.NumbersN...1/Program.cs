using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace _82.NumbersN._._._1
{
    class Program
    {
        static void Main(string[] args)
        {
            var n = int.Parse(Console.ReadLine());

            for (int i = n; i >= 1; i = i - 1)
            {
                Console.WriteLine(i);
            }
        }
    }
}
