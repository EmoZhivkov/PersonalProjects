using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace _93.SleepingCatTom
{
    class Program
    {
        static void Main(string[] args)
        {
            var restDays = int.Parse(Console.ReadLine());

            var playRest = restDays * 127;
            var playWork = (365 - restDays) * 63;
            var playMinutes = playRest + playWork;

            int diff = Math.Abs(playMinutes - 30000);
            int hours = diff / 60;
            int min = diff % 60;

            if (playMinutes > 30000)
            {
                Console.WriteLine("Tom will run away");
                Console.WriteLine("{0} hours and {1} minutes more for play", hours, min);
            }
            else
            {
                Console.WriteLine("Tom sleeps well");
                Console.WriteLine("{0} hours and {1} minutes less for play", hours, min);
            }
        }
    }
}
