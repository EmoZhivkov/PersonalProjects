using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace _73.SquareFrame
{
    class Program
    {
        static void Main(string[] args)
        {
            var n = int.Parse(Console.ReadLine());

            Console.Write("+");
                for (int i = 1; i <= n - 2; i++)
                {
                    Console.Write(" -");
                }
            Console.WriteLine(" +");

            for (int y = 1; y <= n - 2; y++)
            {
                Console.Write("|");
                for (int i = 1; i <= n - 2; i++)
                {
                    Console.Write(" -");
                }
                Console.WriteLine(" |");
            }

            Console.Write("+");
                for (int i = 1; i <= n - 2; i++)
                {
                    Console.Write(" -");
                }
            Console.WriteLine(" +");
            

            
        }
    }
}
