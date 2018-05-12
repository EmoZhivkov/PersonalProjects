using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace _67.OddEvenPosition
{
    class Program
    {
        static void Main(string[] args)
        {
            var count = int.Parse(Console.ReadLine());
            
            double oddSum = 0.0;
            double evenSum = 0.0;
            double maxOdd = int.MinValue;
            double minOdd = int.MaxValue;

            double maxEven = int.MinValue;
            double minEven = int.MaxValue;


            for (int i = 1; i <= count; i++)
            {
                var num = double.Parse(Console.ReadLine());

                if (i % 2 != 0)
                {
                    oddSum = oddSum + num;
                    if (num > maxOdd)
                    {
                        maxOdd = num;
                    }

                    if (num < minOdd)
                    {
                        minOdd = num;
                    }
                }

                if (i % 2 == 0)
                {
                    evenSum = evenSum + num;
                    if (num > maxEven)
                    {
                        maxEven = num;
                    }

                    if (num < minEven)
                    {
                        minEven = num;
                    }
                }


            }

            if (count == 0)
            {
                Console.WriteLine("OddSum=" + oddSum + ",");
                Console.WriteLine("OddMin=" + "No" + ",");
                Console.WriteLine("OddMax=" + "No" + ",");

                Console.WriteLine("EvenSum=" + evenSum + ",");
                Console.WriteLine("EvenMin=" + "No" + ",");
                Console.WriteLine("EvenMax=" + "No");
            }
            else if (count == 1)
            {
                Console.WriteLine("OddSum=" + oddSum + ",");
                Console.WriteLine("OddMin=" + minOdd + ",");
                Console.WriteLine("OddMax=" + maxOdd + ",");

                Console.WriteLine("EvenSum=" + evenSum + ",");
                Console.WriteLine("EvenMin=" + "No" + ",");
                Console.WriteLine("EvenMax=" + "No");
            }
            else
            {
                Console.WriteLine("OddSum=" + oddSum + ",");
                Console.WriteLine("OddMin=" + minOdd + ",");
                Console.WriteLine("OddMax=" + maxOdd + ",");

                Console.WriteLine("EvenSum=" + evenSum + ",");
                Console.WriteLine("EvenMin=" + minEven + ",");
                Console.WriteLine("EvenMax=" + maxEven);
            }
        }
    }
}
