using System;

namespace FindComplement
{
    class Program
    {
        static void Main(string[] args)
        {
            Console.Write("Enter a number: ");
            int n = int.Parse(Console.ReadLine());
            int h = n; //helper element

            //first I check how big should my array 
            int cnt = 0;
            while (n != 0)
            {
                n = n / 2;
                cnt++;
            }
            n = h;

            //we fill the array with the binary number
            int[] arr = new int[cnt];
            cnt = 0;
            while (n != 0)
            {
                if (n % 2 == 1)
                {
                    arr[cnt] = 1;
                }
                else
                {
                    arr[cnt] = 0;
                }
                n = n / 2;
                cnt++;
            }

            //we calculate the complement
            double complement = 0;
            for (int i = 0; i < arr.Length; i++)
            {
                if (arr[i] == 0)
                {
                    complement = complement + Math.Pow(2, i);
                }
            }
            Console.WriteLine("The complement of {0} is {1}.", h, complement);
        }
    }
}
