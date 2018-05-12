using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace _104.SumsStep3
{
    class Program
    {
        static void Main(string[] args)
        {
            var n = int.Parse(Console.ReadLine());
            var sum1 = 0;
            var sum2 = 0;
            var sum3 = 0;

            for (int i = 1; i <= n; i++)
            {
                var y = int.Parse(Console.ReadLine());
                if (i % 3 == 1)
                {
                    sum1 += y;
                }
                if (i % 3 == 2)
                {
                    sum2 += y;
                }
                if (i % 3 == 0)
                {
                    sum3 += y;
                }
            }
            Console.WriteLine("sum1 = {0}",sum1);
            Console.WriteLine("sum2 = {0}", sum2);
            Console.WriteLine("sum3 = {0}", sum3);
        }
    }
}
