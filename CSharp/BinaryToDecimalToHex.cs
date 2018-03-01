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
            int num = int.Parse(Console.ReadLine());

            int final = num;

            int cnt = 0;
            while (num != 0)
            {
                num = num / 10;


                cnt++;
            }

            int[] arr = new int[cnt];

            for (int i = 0; i < cnt; i++)
            {
                int helper = 0;
                helper = final % 10;
                final = final / 10;
                arr[i] = helper;
            }
            //Devide the inputed number in digits and add them in an array in reverse 
            double decimalNumber = 0;
            double powerOfTwo;
            for (int i = 0; i < cnt; i++)
            {
                powerOfTwo = Math.Pow(2, i);
                if (arr[i] == 1)
                {
                    decimalNumber = decimalNumber + powerOfTwo;
                }
            }

            int h = (int)decimalNumber;
            int c = 0;
            while (h > 0)
            {
                h = h / 16;
                c++;
            }
            int[] arr1 = new int[c];

            int numberDec = (int)decimalNumber;

            int remainder = 0;
            for (int i = 0; i < c; i++)
            {
                remainder = numberDec % 16;
                numberDec = numberDec / 16;
                arr1[c - i - 1] = remainder;
            }
            for (int i = 0; i < c; i++)
            {
                if (arr1[i] >= 0 && arr1[i] <= 9)
                {
                    Console.Write(remainder);
                }
                else if (arr1[i] == 10)
                {
                    Console.Write("A");
                }
                else if (arr1[i] == 11)
                {
                    Console.Write("B");
                }
                else if (arr1[i] == 12)
                {
                    Console.Write("C");
                }
                else if (arr1[i] == 13)
                {
                    Console.Write("D");
                }
                else if (arr1[i] == 14)
                {
                    Console.Write("E");
                }
                else if (arr1[i] == 15)
                {
                    Console.Write("F");
                }
            }
            Console.WriteLine();
            
        }
    }
}
