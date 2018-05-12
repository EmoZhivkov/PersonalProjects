using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace _04.BackToThePast
{
    class Program
    {
        static void Main(string[] args)
        {
            var money = double.Parse(Console.ReadLine());
            var year = double.Parse(Console.ReadLine());

            

            var evenYear = 0.0;
            var oddYear = 0.0;

            for (int i = 1800; i <= year; i++)
            {
                if(i % 2 == 0)
                {
                    evenYear += 12000;
                }
                else
                {
                    var howOld = 18 + i - 1800;
                    oddYear = oddYear + 12000 + howOld * 50;
                }
            }

            var spent = evenYear + oddYear;
            var moneyLeft = Math.Abs(money - (evenYear + oddYear));

            if(spent <= money)
            {
                Console.WriteLine("Yes! He will live a carefree life and will have {0:f2} dollars left.", moneyLeft);
            }
            else
            {
                Console.WriteLine("He will need {0:f2} dollars to survive.", moneyLeft);
            }
        }
    }
}
