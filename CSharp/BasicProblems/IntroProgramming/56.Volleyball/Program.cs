using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace _56.Volleyball
{
    class Program
    {
        static void Main(string[] args)
        {
            string year = Console.ReadLine().ToLower();
            
            
            var holiday = double.Parse(Console.ReadLine());
            var weekend = double.Parse(Console.ReadLine());
            double games;

            switch (year)
            {
                case "normal":
                    games = (48d - weekend) * 3d/4d + weekend;
                    games = games + holiday * 2d/3d;
                    Console.WriteLine(Math.Floor(games));
                    ; break;
                case "leap":
                    games = (48d - weekend) * 3d/4d + weekend;
                    games = games + holiday * 2d/3d;
                    games = (15d / 100d * games) + games;
                    Console.WriteLine(Math.Floor(games));
                    ; break;
            }
        }
    }
}
