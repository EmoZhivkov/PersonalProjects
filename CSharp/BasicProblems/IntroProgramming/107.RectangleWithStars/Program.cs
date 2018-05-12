using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace _107.RectangleWithStars
{
    class Program
    {
        static void Main(string[] args)
        {
            var n = int.Parse(Console.ReadLine());

            Console.WriteLine(new string('%', 2 * n));

            if (n % 2 == 0)
            {
                for (int i = 1; i <= n / 2 - 1; i++)
                {
                    Console.Write("%");
                    Console.Write(new string(' ', 2 * n - 2));
                    Console.WriteLine("%");
                }

                Console.Write("%");
                Console.Write(new string(' ', n - 2));
                Console.Write("**");
                Console.Write(new string(' ', n - 2));
                Console.WriteLine("%");

                for (int i = 1; i <= n / 2 - 1; i++)
                {

                    Console.Write("%");
                    Console.Write(new string(' ', 2 * n - 2));
                    Console.WriteLine("%");
                }
            }
            else
            {
                for (int i = 1; i <= n / 2; i++)
                {
                    Console.Write("%");
                    Console.Write(new string(' ', 2 * n - 2));
                    Console.WriteLine("%");
                }

                Console.Write("%");
                Console.Write(new string(' ', n - 2));
                Console.Write("**");
                Console.Write(new string(' ', n - 2));
                Console.WriteLine("%");

                for (int i = 1; i <= n / 2; i++)
                {

                    Console.Write("%");
                    Console.Write(new string(' ', 2 * n - 2));
                    Console.WriteLine("%");
                }
            }

            Console.WriteLine(new string('%', 2 * n));
        }
    }
}
