using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace _02.Harvest
{
    class Program
    {
        static void Main(string[] args)
        {
            var lozeArea = double.Parse(Console.ReadLine());
            var grapes = double.Parse(Console.ReadLine());
            var wineNeeded = double.Parse(Console.ReadLine());
            var workers = double.Parse(Console.ReadLine());

            double grapesAll = lozeArea * grapes;
            double wine = (40.0 / 100.0) * grapesAll / 2.5;



            if (wine >= wineNeeded)
            {
                
                double left = Math.Ceiling(wine - wineNeeded);
                wine = Math.Floor(wine);
                double perPerson = Math.Ceiling(left / workers);
                Console.WriteLine("Good harvest this year! Total wine: {0} liters.", wine);
                Console.WriteLine("{0} liters left -> {1} liters per person.", left, perPerson);
            }
            else
            {
                wine = Math.Floor(wineNeeded - wine);
                Console.WriteLine("It will be a tough winter! More {0} liters wine needed.", wine);

            }
        }
    }
}
