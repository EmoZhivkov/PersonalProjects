using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace _61.SumNumbers
{
    class Program
    {
        static void Main(string[] args)
        {
            var a = int.Parse(Console.ReadLine());
            int sum = 0;

            for (int i = 0; i < a; i++)
            {
                var b = int.Parse(Console.ReadLine());
                sum = sum + b;
            }
            Console.WriteLine(sum);
        }
    }
}
