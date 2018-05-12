using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace _95.CleverLilly
{
    class Program
    {
        static void Main(string[] args)
        {
            var years = int.Parse(Console.ReadLine());
            double washPrice = double.Parse(Console.ReadLine());
            var toyPrice = int.Parse(Console.ReadLine());

            int money = 0;
            int toys = 0;
            
            for (int i = 1; i <= years; i++)
            {
                if (i % 2 == 0)
                {
                    money += 10 * i / 2;
                }
                else
                {
                    toys += 1;
                }
            }

            int toyMoney = toys * toyPrice;
            int all = toyMoney + money - (years / 2);

            if (all >= washPrice)
            {
                Console.WriteLine("Yes! {0:0.00}", all - washPrice);
            }
            else 
            {
                Console.WriteLine("No! {0:0.00}", washPrice - all);
            }
        }
    }
}
