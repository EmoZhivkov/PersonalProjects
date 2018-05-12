using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace _43.TransportPrice
{
    class Program
    {
        static void Main(string[] args)
        {
            var km = int.Parse(Console.ReadLine());
            string time = Console.ReadLine();


            double taxi = 0;
            if (time == "day")
            {
                taxi = 0.79 * km + 0.70;
            }
            else if (time == "night")
            {
                taxi = 0.90 * km + 0.70;
            }

            double bus = 0.09 * km;
            double train = 0.06 * km;


            if (km < 20)
            {
                Console.WriteLine(taxi);
            }
            else if (km >= 100)
            {
                Console.WriteLine(train);
            }
            else if (km >= 20)
            {
                Console.WriteLine(bus);
            }
        }
    }
}
