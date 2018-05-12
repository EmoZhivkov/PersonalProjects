using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace _92.PopravkaPlochki
{
    class Program
    {
        static void Main(string[] args)
        {
            //24 April 2016
            var n = double.Parse(Console.ReadLine());
            var w = double.Parse(Console.ReadLine());
            var l = double.Parse(Console.ReadLine());
            var m = double.Parse(Console.ReadLine());
            var o = double.Parse(Console.ReadLine());

            double wholeArea = n * n;
            double benchArea = m * o;
            double areaNeeded = wholeArea - benchArea;
            double plateArea = w * l;
            double plateNeeded = areaNeeded / plateArea;
            double timeNeeded = plateNeeded * 0.2;

            Console.WriteLine(plateNeeded);
            Console.WriteLine(timeNeeded);
        }
    }
}
