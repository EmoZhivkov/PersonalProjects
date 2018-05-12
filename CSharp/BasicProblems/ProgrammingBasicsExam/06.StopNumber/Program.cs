using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace _06.StopNumber
{
    class Program
    {
        static void Main(string[] args)
        {
            var first = int.Parse(Console.ReadLine());
            var second = int.Parse(Console.ReadLine());
            var stop = int.Parse(Console.ReadLine());
            var num = 0;

            for (int i = second; i >= first; i--)
            {
                
                if (i % 2 == 0 && i % 3 == 0)
                {
                    num = i;
                    if(num == stop)
                    {
                        break;
                    }
                    Console.Write(num + " ");

                }
            }
            Console.WriteLine();
        }
    }
}
