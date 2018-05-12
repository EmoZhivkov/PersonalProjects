using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace _57.PointInTheFigure
{
    class Program
    {
        static void Main(string[] args)
        {
            var h = int.Parse(Console.ReadLine());
            var x = int.Parse(Console.ReadLine());
            var y = int.Parse(Console.ReadLine());

            var x1 = h;
            var y1 = 4 * h;

            var x2 = 2 * h;
            var y2 = h;

            var x3 = 0;
            var y3 = h;

            var x4 = 3 * h;
            var y4 = 0;

            if(y == h && x > h && x < 2 * h)
            {
                Console.WriteLine("inside");
            }
            else if ((x == x1 || x == x2) && y >= y2 && y <= y1)
            {
                Console.WriteLine("border");
            }
            else if((y == y1) && x >= x1 && x <= x2)
            {
                Console.WriteLine("border");
            }
            else if((x == x3 || x == x4) && y >= y4 && y <= y3)
            {
                Console.WriteLine("border");
            }
            else if((y == y4 || y == y3) && x >= x3 && x <= x4)
            {
                Console.WriteLine("border");
            }

            else if(x > x1 && x < x2 && y > y2 && y < y1)
            {
                Console.WriteLine("inside");
            }
            else if (x > x3 && x < x4 && y > y4 && y < y3)
            {
                Console.WriteLine("inside");
            }
            else if (x < x1 || x > x2 || y < y2 || y > y1)
            {
                Console.WriteLine("outside");
            }
            else if(x < x3 || x > x4 || y < y4 || y > y3)
            {
                Console.WriteLine("outside");
            }
        }
    }
}
