using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace _90.CheckPrime
{
    class Program
    {
        static void Main(string[] args)
        {
            var num = int.Parse(Console.ReadLine());
            if (num <= 2)
            {
                Console.WriteLine("Not Prime");
            }
            else
            {
                for (int i = 2; i < num; i++)
                {
                    if (num % i == 0)
                    {
                        Console.WriteLine("Not Prime");
                        return;
                    }
                }
              Console.WriteLine("Prime");
            }
        }
    }
}
