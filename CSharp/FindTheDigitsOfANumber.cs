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
                arr[cnt - i - 1] = helper;
            }

            for (int i = 0; i < cnt; i++)
            {
                Console.Write(arr[i] + " ");
            }
            Console.WriteLine();
        }
    }
}
