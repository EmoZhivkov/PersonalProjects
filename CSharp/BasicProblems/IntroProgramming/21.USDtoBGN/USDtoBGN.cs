using System;


namespace _21.USDtoBGN
{
    class USDtoBGN
    {
        static void Main(string[] args)
        {
            var usd = double.Parse(Console.ReadLine());
            var bgn = 1.79549 * usd;
            Console.WriteLine(Math.Round(bgn, 2) + " BGN");
        }
    }
}
