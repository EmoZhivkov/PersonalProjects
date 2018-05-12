using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace _03.MatchTickets
{
    class Program
    {
        static void Main(string[] args)
        {
            var money = double.Parse(Console.ReadLine());
            string ticket = Console.ReadLine();
            var people = double.Parse(Console.ReadLine());
            double transBudget = 0.00;
            var ticketPrice = 0.00;
            var moneyLeft = 0.00;


            if (ticket == "Normal")
            {
                ticketPrice = 249.99;
            }
            else
            {
                ticketPrice = 499.99;
            }



            if (people >= 1 && people <= 4)
            {
                transBudget = (75.0 / 100.0) * money;
            }
            else if (people >= 5 && people <= 9)
            {
                transBudget = (60.0 / 100.0) * money;
            }
            else if (people >= 10 && people <= 24)
            {
                transBudget = (50.0 / 100.0) * money;
            }
            else if (people >= 25 && people <= 49)
            {
                transBudget = (40.0 / 100.0) * money;
            }
            else if (people >= 50)
            {
                transBudget = (25.0 / 100.0) * money;
            }

            moneyLeft = money - transBudget;
            var allTicket = ticketPrice * people;

            var diff = Math.Abs(moneyLeft - allTicket);

            if (moneyLeft >= allTicket)
            {
                Console.WriteLine("Yes! You have {0:f2} leva left.", diff);
            }
            else
            {
                Console.WriteLine("Not enough money! You need {0:f2} leva.", diff);
            }

        }
    }
}
