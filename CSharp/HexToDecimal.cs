using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace ConsoleApp1
{
    class Program
    {
        static void Main()
        {
            string hex = Console.ReadLine();
            double sum = 0;
            int helper = 0;
            for (int i = 0; i < hex.Length; i++)
            {
                helper = hex.Length - i - 1;
                if (hex[i] == '0')
                {

                }
                else if (hex[i] == '1')
                {
                    sum = sum + 1 * Math.Pow(16, helper);
                }
                else if (hex[i] == '2')
                {
                    sum = sum + 2 * Math.Pow(16, helper);
                }
                else if (hex[i] == '3')
                {
                    sum = sum + 3 * Math.Pow(16, helper);
                }
                else if (hex[i] == '4')
                {
                    sum = sum + 4 * Math.Pow(16, helper);
                }
                else if (hex[i] == '5')
                {
                    sum = sum + 5 * Math.Pow(16, helper);
                }
                else if (hex[i] == '6')
                {
                    sum = sum + 6 * Math.Pow(16, helper);
                }
                else if (hex[i] == '7')
                {
                    sum = sum + 7 * Math.Pow(16, helper);
                }
                else if (hex[i] == '8')
                {
                    sum = sum + 8 * Math.Pow(16, helper);
                }
                else if (hex[i] == '9')
                {
                    sum = sum + 9 * Math.Pow(16, helper);
                }
                else if (hex[i] == 'A')
                {
                    sum = sum + 10 * Math.Pow(16, helper);
                }
                else if (hex[i] == 'B')
                {
                    sum = sum + 11 * Math.Pow(16, helper);
                }
                else if (hex[i] == 'C')
                {
                    sum = sum + 12 * Math.Pow(16, helper);
                }
                else if (hex[i] == 'D')
                {
                    sum = sum + 13 * Math.Pow(16, helper);
                }
                else if (hex[i] == 'E')
                {
                    sum = sum + 14 * Math.Pow(16, helper);
                }
                else if (hex[i] == 'F')
                {
                    sum = sum + 15 * Math.Pow(16, helper);
                }
            }
            Console.WriteLine(sum);
        }
    }
}

