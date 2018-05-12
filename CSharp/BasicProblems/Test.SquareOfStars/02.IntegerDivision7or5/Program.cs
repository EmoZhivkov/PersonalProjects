using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace _02.IntegerDivision7or5
{
    class Program
    {
        static void Main(string[] args)
        {
            var a = int.Parse(Console.ReadLine());
            if (a % 5 == 0 && a % 7 == 0)
            { Console.WriteLine("The can be devided in 5 and 7"); }
            else { Console.WriteLine("The can not be devided in 5 and 7"); }
        }
    }
}
