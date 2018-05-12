using System;


namespace _30.GreaterNumber
{
    class Program
    {
        static void Main(string[] args)
        {
            var a = int.Parse(Console.ReadLine());
            var b = int.Parse(Console.ReadLine());

            if (a > b)
            { Console.WriteLine(a); }
            else if ( b >= a )
            { Console.WriteLine(b); }
            
        }
    }
}
