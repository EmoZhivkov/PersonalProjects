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
            
            int n = int.Parse(Console.ReadLine());
            int helper = n;
            int h = 0;
            while (helper > 0)
            {
                helper = helper / 2;
                h++;
            }

            int[] arr = new int[h];
            int cnt = 0;
            while (n > 0)
            {
                if (n%2 == 0)
                {
                    arr[cnt] = 0;
                }
                else
                {
                    arr[cnt] = 1;
                }
                n = n / 2;
                cnt++;
            }

            for (int i = h -1; i >= 0; i--)
            {
                Console.Write(arr[i]);
            }
            Console.WriteLine();
            
        }   
    }
}
