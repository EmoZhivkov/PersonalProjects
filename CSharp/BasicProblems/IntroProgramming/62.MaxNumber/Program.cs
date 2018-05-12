using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace _62.MaxNumber
{
    class Program
    {
        static void Main(string[] args)
        {
            var a = int.Parse(Console.ReadLine());
            int max = int.MinValue;
            for (int i = 0; i < a; i++)
            {
                var b = int.Parse(Console.ReadLine());
                if (b > max)
                {
                    max = b;
                }
            }
            Console.WriteLine(max);
        }
    }
}
