using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace _11.FiveNumbersWhichIsBigger
{
    class Program
    {
        static void Main(string[] args)
        {
            var a = int.Parse(Console.ReadLine());
            var b = int.Parse(Console.ReadLine());
            var c = int.Parse(Console.ReadLine());
            var d = int.Parse(Console.ReadLine());
            var e = int.Parse(Console.ReadLine());

            if (a > b && a > c && a > d && a > e)
            {
                Console.WriteLine("The biggest number is: " + a);
            }
            else if (b > a && b > c && b > d && b > e)
            {
                Console.WriteLine("The biggest number is: " + b);
            }
            else if (c > a && c > b && c > d && c > e)
            {
                Console.WriteLine("The biggest number is: " + c);
            }
            else if (d > a && d > b && d > c && d > e)
            {
                Console.WriteLine("The biggest number is: " + d);
            }
            else if (e > a && e > b && e > c && e > d)
            {
                Console.WriteLine("The biggest number is: " + e);
            }

        }
    }
}
