using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace _54.AnimalType
{
    class Program
    {
        static void Main(string[] args)
        {
            string a = Console.ReadLine();
            switch (a)
            {
                case "dog":
                    Console.WriteLine("mammal"); break;
                case "snake":
                    Console.WriteLine("reptile"); break;
                case "crocodile":
                    Console.WriteLine("reptile"); break;
                case "tortoise":
                    Console.WriteLine("reptile"); break;
                default:
                    Console.WriteLine("unknown"); break;

            }
        }
    }
}
