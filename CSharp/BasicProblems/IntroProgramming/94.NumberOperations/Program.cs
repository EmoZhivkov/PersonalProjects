using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace _94.NumberOperations
{
    class Program
    {
        static void Main(string[] args)
        {
            var n1 = double.Parse(Console.ReadLine());
            var n2 = double.Parse(Console.ReadLine());
            string function = Console.ReadLine();

            if (function == "+")
            {
                double subirane = n1 + n2;
                if (subirane % 2 == 0)
                {
                    Console.WriteLine(n1+ " " + function+ " " + n2 + " = " + subirane + " - " + "even");
                }
                else 
                {
                    Console.WriteLine(n1+ " " + function+ " " + n2 + " = " + subirane + " - " + "odd");
                }
            }
            else if (function == "-")
            {
                double izvajdane = n1 - n2;
                if (izvajdane % 2 == 0)
                {
                    Console.WriteLine(n1 + " " + function + " " + n2 + " = " + izvajdane + " - " + "even");
                }
                else
                {
                    Console.WriteLine(n1 + " " + function + " " + n2 + " = " + izvajdane + " - " + "odd");
                }
            }
            else if(function == "*")
            {
                double umnojenie = n1 * n2;
                if (umnojenie % 2 == 0)
                {
                    Console.WriteLine(n1 + " " + function + " " + n2 + " = " + umnojenie + " - " + "even");
                }
                else
                {
                    Console.WriteLine(n1 + " " + function + " " + n2 + " = " + umnojenie + " - " + "odd");
                }
            }
            else if (function == "/")
            {
                if (n2 == 0)
                {
                    Console.WriteLine("Cannot divide " + n1 + " by zero");
                }
                else
                {
                    double delenie = n1 / n2;
                    Console.WriteLine(n1 + " / " + n2 + " = " + "{0:F2}", delenie);
                }
            }
            else if (function == "%")
            {
                if (n2 == 0)
                {
                    Console.WriteLine("Cannot divide " + n1 + " by zero");
                }
                else
                {
                    double ostatuk = n1 % n2;
                    Console.WriteLine(n1 + " % " + n2 + " = " + ostatuk);
                }
            }
           

        }
    }
}
