using System;

namespace _42.NumberZeroTo100ToText
{
    class Program
    {
        static void Main(string[] args)
        {
            var a = double.Parse(Console.ReadLine());

            var b = a % 10;
            string first = null;
            string c = null;

            if (a == 11)
            { first = "eleven"; }
            else if (a == 12)
            { first = "twelve"; }
            else if (a == 13)
            { first = "thirteen"; }
            else if (a == 14)
            { first = "fourteen"; }
            else if (a == 15)
            { first = "fifteen"; }
            else if (a == 16)
            { first = "sixteen"; }
            else if (a == 17)
            { first = "seventeen"; }
            else if (a == 18)
            { first = "eighteen"; }
            else if (a == 19)
            { first = "nineteen"; }


            if (a >= 20 && a < 30)
            { first = "twenty"; }
            else if (a == 10)
            { first = "ten"; }
            else if (a >= 30 && a < 40)
            { first = "thirty"; }
            else if (a >= 40 && a < 50)
            { first = "fourty"; }
            else if (a >= 50 && a < 60)
            { first = "fifty"; }
            else if (a >= 60 && a < 70)
            { first = "sixty"; }
            else if (a >= 70 && a < 80)
            { first = "seventy"; }
            else if (a >= 80 && a < 90)
            { first = "eighty"; }
            else if (a >= 90 && a < 100)
            { first = "ninety"; }
            else if (a == 100)
            { first = "one hundred"; }
            

            if (b == 1)
            { c = "one"; }
            else if (b == 2)
            { c = "two"; }
            else if (b == 3)
            { c = "three"; }
            else if (b == 4)
            { c = "four"; }
            else if (b == 5)
            { c = "five"; }
            else if (b == 6)
            { c = "six"; }
            else if (b == 7)
            { c = "seven"; }
            else if (b == 8)
            { c = "eight"; }
            else if (b == 9)
            { c = "nine"; }

            if (a == 0)
            { Console.WriteLine("zero"); }
            else if (a < 0 || a > 100)
            { Console.WriteLine("invalid number"); }
            else if (a >= 10 && a < 20 || a % 10 == 0)
            { Console.WriteLine(first); }
            else if (a >= 20)
            { Console.WriteLine(first + " " + c); }
            else if (a < 10)
            { Console.WriteLine(c); }
            
        }
    }
}
