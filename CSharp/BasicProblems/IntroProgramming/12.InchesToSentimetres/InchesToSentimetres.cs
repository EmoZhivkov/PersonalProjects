using System;


namespace _12.InchesToSentimetres
{
    class InchesToSentimetres
    {
        static void Main(string[] args)
        {
            Console.Write("Inches = ");
            var inch = double.Parse(Console.ReadLine());
            var sent = inch * 2.54;
            Console.WriteLine("Sentimetres = " + sent);

        }
    }
}
