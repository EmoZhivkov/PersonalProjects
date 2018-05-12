using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace _53.TradeComissions
{
    class Program
    {
        static void Main(string[] args)
        {
            string city = Console.ReadLine().ToLower();
            var sales = double.Parse(Console.ReadLine());
            double answer;
            switch (city)
            {
                case "sofia":
                    if (sales >= 0 && sales <= 500)
                    {
                        answer = Math.Round(sales * 5 / 100, 2);
                        Console.WriteLine("{0:0.00}", answer);
                    }
                    else if (sales > 500 && sales <= 1000)
                    {
                        answer = Math.Round(sales * 7 / 100, 2);
                        Console.WriteLine("{0:0.00}", answer);
                    }
                    else if (sales > 1000 && sales <= 10000)
                    {
                        answer = Math.Round(sales * 8 / 100, 2);
                        Console.WriteLine("{0:0.00}", answer);
                    }
                    else if (sales > 10000)
                    {
                        answer = Math.Round(sales * 12 / 100, 2);
                        Console.WriteLine("{0:0.00}", answer);
                    }
                    else if (sales < 0)
                    {
                        Console.WriteLine("error");
                    }
                    ; break;
                case "varna":
                    if (sales >= 0 && sales <= 500)
                    {
                        answer = Math.Round(sales * 4.5 / 100, 2);
                        Console.WriteLine("{0:0.00}", answer);
                    }
                    else if (sales > 500 && sales <= 1000)
                    {
                        answer = Math.Round(sales * 7.5 / 100, 2);
                        Console.WriteLine("{0:0.00}", answer);
                    }
                    else if (sales > 1000 && sales <= 10000)
                    {
                        answer = Math.Round(sales * 10 / 100, 2);
                        Console.WriteLine("{0:0.00}", answer);
                    }
                    else if (sales > 10000)
                    {
                        answer = Math.Round(sales * 13 / 100, 2);
                        Console.WriteLine("{0:0.00}", answer);
                    }
                    else if (sales < 0)
                    {
                        Console.WriteLine("error");
                    }
                    ; break;
                case "plovdiv":
                    if (sales >= 0 && sales <= 500)
                    {
                        answer = Math.Round(sales * 5.5 / 100, 2);
                        Console.WriteLine("{0:0.00}", answer);
                    }
                    else if (sales > 500 && sales <= 1000)
                    {
                        answer = Math.Round(sales * 8 / 100, 2);
                        Console.WriteLine("{0:0.00}", answer);
                    }
                    else if (sales > 1000 && sales <= 10000)
                    {
                        answer = Math.Round(sales * 12 / 100, 2);
                        Console.WriteLine("{0:0.00}", answer);
                    }
                    else if (sales > 10000)
                    {
                        answer = Math.Round(sales * 14.5 / 100, 2);
                        Console.WriteLine("{0:0.00}", answer);
                    }
                    else if (sales < 0)
                    {
                        Console.WriteLine("error");
                    }
                    ; break;
                default: Console.WriteLine("error"); break;
            }

        }
    }
}
