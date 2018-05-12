using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace _99.Bricks
{
    class Program
    {
        static void Main(string[] args)
        {
            var bricks = double.Parse(Console.ReadLine());
            var workers = double.Parse(Console.ReadLine());
            var cart = double.Parse(Console.ReadLine());

            var trip = workers * cart;
            var trips = Math.Ceiling(bricks / trip);

            Console.WriteLine(trips);
        }
    }
}
