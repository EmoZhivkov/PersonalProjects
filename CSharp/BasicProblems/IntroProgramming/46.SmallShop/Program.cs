using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace _46.SmallShop
{
    class Program
    {
        static void Main(string[] args)
        {
            string product = Console.ReadLine();
            string city = Console.ReadLine();
            var a = double.Parse(Console.ReadLine());
            double price = 0;

            if (city == "Sofia")
            {
                if (product == "coffee")
                {
                    price = a * 0.50;
                }
                else if (product == "water")
                {
                    price = a * 0.80;
                }
                else if (product == "beer")
                {
                    price = a * 1.20;
                }
                else if (product == "sweets")
                {
                    price = a * 1.45;
                }
                else if (product == "peanuts")
                {
                    price = a * 1.60;
                }
            }
            else if (city == "Plovdiv")
            {
                if (product == "coffee")
                {
                    price = a * 0.40;
                }
                else if (product == "water")
                {
                    price = a * 0.70;
                }
                else if (product == "beer")
                {
                    price = a * 1.15;
                }
                else if (product == "sweets")
                {
                    price = a * 1.30;
                }
                else if (product == "peanuts")
                {
                    price = a * 1.50;
                }
            }
            else if (city == "Varna")
            {
                if (product == "coffee")
                {
                    price = a * 0.45;
                }
                else if (product == "water")
                {
                    price = a * 0.70;
                }
                else if (product == "beer")
                {
                    price = a * 1.10;
                }
                else if (product == "sweets")
                {
                    price = a * 1.35;
                }
                else if (product == "peanuts")
                {
                    price = a * 1.55;
                }
            }
            Console.WriteLine(price);
        }
    }
}
