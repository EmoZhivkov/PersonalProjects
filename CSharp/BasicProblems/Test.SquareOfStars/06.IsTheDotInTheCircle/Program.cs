using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace _06.IsTheDotInTheCircle
{
    class Program
    {
        static void Main(string[] args)
        {
            var x = int.Parse(Console.ReadLine());
            var y = int.Parse(Console.ReadLine());
            
            if (x*x + y*y <= 25 && x<=5 && x>=-1 && y<=5 && y>=1)
            {
                Console.WriteLine("The point is in the circle and jhjh");
            }
            else { Console.WriteLine("The point is outside the circle or jhjh"); }
        }
    }
}
