using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace _76.Sunglasses
{
    class Program
    {
        static void Main(string[] args)
        {
            var n = int.Parse(Console.ReadLine());
            string stars = new string('*', 2 * n);
            string glass = new string('/', 2 * n - 2);
            string spaces = new string(' ', n);
            string line = new string('|', n);
            int frameRow = 0;
            if (n % 2 == 0)
            {
                frameRow = (n - 1) / 2; 
            }
            else
            {
                frameRow = n / 2;
            }
            Console.WriteLine(stars + spaces + stars);

            for (int row = 1; row <= n - 2; row++)
            {
                Console.Write("*" + glass + "*");
                

                if (row == frameRow)
                {
                    
                    Console.Write(line);
                    
                }
                else
                {
                    Console.Write(spaces);
                }

                Console.Write("*" + glass + "*");
                Console.WriteLine();   
            }

            Console.WriteLine(stars + spaces + stars);
        }
    }
}
