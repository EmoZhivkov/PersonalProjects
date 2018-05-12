using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace _63.MinNumber
{
    class Program
    {
        static void Main(string[] args)
        {
            var a = int.Parse(Console.ReadLine());
            int min = int.MaxValue;
            for (int i = 0; i < a; i++)
            {
            
                var b = int.Parse(Console.ReadLine());
                if (b < min)
                {
                    min = b;
                }
            }
            Console.WriteLine(min);
        }
    }
}
