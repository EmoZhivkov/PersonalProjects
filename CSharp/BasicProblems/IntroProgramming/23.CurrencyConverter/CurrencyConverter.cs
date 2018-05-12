using System;


namespace _23.CurrencyConverter
{
    class CurrencyConverter
    {
        static void Main(string[] args)
        {
            var a = double.Parse(Console.ReadLine());
            string firstCurr = Console.ReadLine();
            string secondCurr = Console.ReadLine();


            double bgnUsd = a / 1.79549;
            double usdBgn = a * 1.79549;

            double bgnEur = a / 1.95583;
            double eurBgn = a * 1.95583;

            double bgnGbp = a / 2.53405;
            double gbpBgn = a * 2.53405;

            double usdEur = 1.79549 / 1.95583 * a;
            double eurUsd = 1.95583 / 1.79549 * a;

            double usdGbp = 1.79549 / 2.53405 * a;
            double gbpUsd = 2.53405 / 1.79549 * a;

            double eurGbp = 1.95583 / 2.53405 * a;
            double gbpEur = 2.53405 / 1.95583 * a;


            if(firstCurr == "BGN" && secondCurr == "USD" )
            {
                Console.WriteLine(Math.Round(bgnUsd, 2) + " USD");
            }
            else if (firstCurr == "USD" && secondCurr == "BGN")
            {
                Console.WriteLine(Math.Round(usdBgn, 2) + " BGN");
            }


            else if (firstCurr == "BGN" && secondCurr == "EUR")
            {
                Console.WriteLine(Math.Round(bgnEur, 2) + " EUR");
            }
            else if (firstCurr == "EUR" && secondCurr == "BGN")
            {
                Console.WriteLine(Math.Round(eurBgn, 2) + " BGN");
            }


            else if (firstCurr == "BGN" && secondCurr == "GBP")
            {
                Console.WriteLine(Math.Round(bgnGbp, 2) + " GBP");
            }
            else if (firstCurr == "GBP" && secondCurr == "BGN")
            {
                Console.WriteLine(Math.Round(gbpBgn, 2) + " BGN");
            }


            else if (firstCurr == "USD" && secondCurr == "EUR")
            {
                Console.WriteLine(Math.Round(usdEur, 2) + " EUR");
            }
            else if (firstCurr == "EUR" && secondCurr == "USD")
            {
                Console.WriteLine(Math.Round(eurUsd, 2) + " USD");
            }


            else if (firstCurr == "USD" && secondCurr == "GBP")
            {
                Console.WriteLine(Math.Round(usdGbp, 2) + " GBP");
            }
            else if (firstCurr == "GBP" && secondCurr == "USD")
            {
                Console.WriteLine(Math.Round(gbpUsd, 2) + " USD");
            }


            else if (firstCurr == "EUR" && secondCurr == "GBP")
            {
                Console.WriteLine(Math.Round(eurGbp, 2) + " GBP");
            }
            else if (firstCurr == "GBP" && secondCurr == "EUR")
            {
                Console.WriteLine(Math.Round(gbpEur, 2) + " EUR");
            }
        }
    }
}
