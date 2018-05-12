using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace _75.ChristmasTree
{
    class Program
    {
        static void Main(string[] args)
        {
            var n = int.Parse(Console.ReadLine());

            for (int i = 0; i <= n; i++)
            {
                string spaces = new string (' ', n - i);
                string stars = new string('*', i);
                string line = " | ";

                Console.Write(spaces + stars + line + stars + spaces);


                Console.WriteLine();
            }
        }
    }
}
