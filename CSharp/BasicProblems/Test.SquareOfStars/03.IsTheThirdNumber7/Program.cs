using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace _03.IsTheThirdNumber7
{
    class Program
    {
        static void Main(string[] args)
        {
            var a = int.Parse(Console.ReadLine());
            var b = a / 100;
            if (b%10 == 7)
            { Console.WriteLine("The Third Number is 7"); }
            else { Console.WriteLine("The Third Number is not 7"); }
        }
    }
}
