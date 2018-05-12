using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace _64.LeftAndRightSum
{
    class Program
    {
        static void Main(string[] args)
        {
            var count = int.Parse(Console.ReadLine());
            int leftSum = 0;
            int rightSum = 0;

            for (int i = 0; i < count * 2; i++)
            {
                var num = int.Parse(Console.ReadLine());

                if (i < count)
                {
                    leftSum = leftSum + num;
                }
                else
                {
                    rightSum = rightSum + num;
                }
            }
            if (leftSum == rightSum)
            {
                Console.WriteLine("Yes, sum = " + rightSum);
            }
            else
            {
                Console.WriteLine("No, diff = " + Math.Abs(leftSum - rightSum));
            }
        }
    }
}
