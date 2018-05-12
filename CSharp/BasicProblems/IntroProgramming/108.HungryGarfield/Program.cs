using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace _108.HungryGarfield
{
    class Program
    {
        static void Main(string[] args)
        {
            var money =     decimal.Parse(Console.ReadLine());
            var exchRate = decimal.Parse(Console.ReadLine());
            var pizzaPrice = decimal.Parse(Console.ReadLine());
            var lasagnaPrice = decimal.Parse(Console.ReadLine());
            var sandwichPrice = decimal.Parse(Console.ReadLine());
            var pizzaQuantity = decimal.Parse(Console.ReadLine());
            var lasagnaQuantity = decimal.Parse(Console.ReadLine());
            var sandwichQuantity = decimal.Parse(Console.ReadLine());


            decimal pizza = (pizzaPrice / exchRate) * pizzaQuantity;
            decimal lasagna = (lasagnaPrice / exchRate) * lasagnaQuantity;
            decimal sandwich = (sandwichPrice / exchRate) * sandwichQuantity;

            decimal all = pizza + lasagna + sandwich;

            decimal diff = Math.Abs(money - all);

            if (all <= money)
            {
                Console.WriteLine("Garfield is well fed, John is awesome. Money left: ${0:f2}.", diff);
            }
            else
            {
                Console.WriteLine("Garfield is hungry. John is a badass. Money needed: ${0:f2}.", diff);
            }
            

        }
    }
}
