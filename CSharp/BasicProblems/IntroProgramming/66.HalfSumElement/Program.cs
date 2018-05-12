using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace _66.HalfSumElement
{
    class Program
    {
        static void Main(string[] args)
        {
            var count = int.Parse(Console.ReadLine());
            double sum = 0;
            double max = int.MinValue;
            
            for (int i = 0; i < count; i++)
            {
                var num = int.Parse(Console.ReadLine());
                sum = sum + num;
                if (num > max)
                {
                    max = num;
                }
            }
            
            
            if (max == Math.Round(sum / 2))
            {
                Console.WriteLine("Yes");
                Console.WriteLine("Sum = " + max);
            }
            else
            {
                double diff = sum - max;
                Console.WriteLine("No");
                Console.WriteLine("Diff = " + Math.Abs(max - diff));
            }
        }
    }
}
