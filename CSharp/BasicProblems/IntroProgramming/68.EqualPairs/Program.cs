using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace _68.EqualPairs
{
    class Program
    {
        static void Main(string[] args)
        {
            int count = int.Parse(Console.ReadLine());
            int currSum = 0;
            int prevSum = 0;
            int diff = 0;
            int maxDiff = 0;


            for (int i = 0; i < count; i++)
            {
                prevSum = currSum;
                currSum = 0;

                var num = int.Parse(Console.ReadLine());
                var num1 = int.Parse(Console.ReadLine());

                currSum = currSum + num + num1;

                if (i != 0)
                {
                    diff = Math.Abs(currSum - prevSum);
                    if (diff != 0 && diff > maxDiff)
                    {
                        maxDiff = diff;
                    }
                }
               
            }
            if (currSum == prevSum || count == 1)
            {
                Console.WriteLine("Yes, value=" + currSum);
            }
            else
            {
                Console.WriteLine("No, maxdiff=" + maxDiff);
            }
            
            
        }
    }
}
