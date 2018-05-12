using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace _51.FruitShop
{
    class Program
    {
        static void Main(string[] args)
        {
            string fruit = Console.ReadLine().ToLower();
            string day = Console.ReadLine().ToLower();
            var a = double.Parse(Console.ReadLine());
            double price = 0;

            if (day == "sunday" || day == "saturday")
            {
                if (fruit == "banana")
                {
                    price = a * 2.70;
                    Console.WriteLine(price);
                }
                else if (fruit == "apple")
                {
                    price = a * 1.25;
                    Console.WriteLine(price);
                }
                
                else if (fruit == "orange")
                {
                    price = a * 0.90;
                    Console.WriteLine(price);
                }
                else if (fruit == "grapefruit")
                {
                    price = a * 1.60;
                    Console.WriteLine(price);
                }
                else if (fruit == "kiwi")
                {
                    price = a * 3.00;
                    Console.WriteLine(price);
                }
                else if (fruit == "pineapple")
                {
                    price = a * 5.60;
                    Console.WriteLine(price);
                }
                else if (fruit == "grapes")
                {
                    price = a * 4.20;
                    Console.WriteLine(price);
                }
            }
            else if (day == "monday" || day == "tuesday" || day == "wednesday" || day == "thursday" || day == "friday")
            {
                if (fruit == "banana")
                {
                    price = a * 2.50;
                    Console.WriteLine(price);
                }
                else if (fruit == "apple")
                {
                    price = a * 1.20;
                    Console.WriteLine(price);
                }
                
                else if (fruit == "orange")
                {
                    price = a * 0.85;
                    Console.WriteLine(price);
                }
                else if (fruit == "grapefruit")
                {
                    price = a * 1.45;
                    Console.WriteLine(price);
                }
                else if (fruit == "kiwi")
                {
                    price = a * 2.70;
                    Console.WriteLine(price);
                }
                else if (fruit == "pineapple")
                {
                    price = a * 5.50;
                    Console.WriteLine(price);
                }
                else if (fruit == "grapes")
                {
                    price = a * 3.85;
                    Console.WriteLine(price);
                }
                else
                {
                    Console.WriteLine("error");
                }
            }
            else
            {
                Console.WriteLine("error");
            }
            
            
        }
    }
}
