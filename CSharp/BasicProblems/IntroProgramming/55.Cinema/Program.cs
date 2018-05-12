using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace _55.Cinema
{
    class Program
    {
        static void Main(string[] args)
        {
            string a = Console.ReadLine();
            var r = int.Parse(Console.ReadLine());
            var c = int.Parse(Console.ReadLine());
            int places = r * c;

            switch (a)
            {
                case "Premiere":
                    Console.WriteLine();
                    Console.WriteLine("{0:#.00}", Math.Round(places * 12.00, 2));
                    Console.WriteLine("leva");break;
                case "Normal":
                    Console.WriteLine();
                    Console.WriteLine("{0:#.00}", Math.Round(places * 7.50, 2));
                    Console.WriteLine("leva");break;
                case "Discount":
                    Console.WriteLine();
                    Console.WriteLine("{0:#.00}", Math.Round(places * 5.00, 2));
                    Console.WriteLine("leva");break;
            }
        }
    }
}
