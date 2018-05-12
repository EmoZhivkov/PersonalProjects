using System;


namespace _32.BonusScore
{
    class Program
    {
        static void Main(string[] args)
        {
            var a = int.Parse(Console.ReadLine());
            double b = 0;
            
            if (a <= 100)
            { b = b + 5; }
            else if (a > 1000)
            { b = b + (10.0 / 100 * a); }
            else if (a > 100)
            { b = b + (20.0/100 * a); }
            

            if (a % 2==0)
            { b = b + 1; }
            else if (a % 10 == 5)
            { b = b + 2; }

            Console.WriteLine(b);
            Console.WriteLine(b + a);
        }
    }
}
