using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace _100.PointOnSegment
{
    class Program
    {
        static void Main(string[] args)
        {
            var first = int.Parse(Console.ReadLine());
            var second = int.Parse(Console.ReadLine());
            var point = int.Parse(Console.ReadLine());

            if (first < second)
            {
                if (point >= first && point <= second)
                {
                    Console.WriteLine("in");
                }
                else 
                {
                    Console.WriteLine("out");
                }
            }
            else
            {
                if (point >= second && point <= first)
                {
                    Console.WriteLine("in");
                }
                else
                {
                    Console.WriteLine("out");
                }
            }

            var diff1 = Math.Abs(first - point);
            var diff2 = Math.Abs(second - point);

            if (diff1 < diff2)
            {
                Console.WriteLine(diff1);
            }
            else
            {
                Console.WriteLine(diff2);
            }
        }
    }
}
