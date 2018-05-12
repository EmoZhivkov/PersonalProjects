using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace _101.PointInFigure
{
    class Program
    {
        static void Main(string[] args)
        {
            var x = int.Parse(Console.ReadLine());
            var y = int.Parse(Console.ReadLine());

            if (
                (y == -5 && x >= 4 && x <= 10) ||
                (y == 3 && x >= 4 && x <= 10) ||
                (x == 2 && y >= -3 && y <= 1) ||
                (x == 12 && y >= -3 && y <= 1) ||
                (y == -3 && x >= 2 && x <= 4) ||
                (y == 1 && x >= 2 && x <= 4) ||
                (y == -3 && x >= 10 && x <= 12) ||
                (y == 1 && x >= 10 && x <= 12) ||
                (x == 4 && y >= -5 && y <= -3) ||
                (x == 10 && y >= -5 && y <= -3) ||
                (x == 4 && y >= 1 && y <= 3) ||
                (x == 10 && y >= 1 && y <= 3) ||
                (x >= 4 && x <= 10 && y >= -5 && y <= 3) ||
                (x >= 2 && x <= 12 && y >= -3 && y <= 1)
               )
            {
                Console.WriteLine("in");
            }
            else
            {
                Console.WriteLine("out");
            }
        }
    }
}
