using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

//Find the max sequence of increasing elements inside of an array
//Example: {9, 6, 2, 7, 4, 7, 6, 5, 8, 4} -> {2, 4, 7, 8}
namespace ConsoleApp1
{
    class Program
    {
        static void Main()
        {
            int n = int.Parse(Console.ReadLine());
            int[] arr = new int[n];
           
            for (int i = 0; i < n; i++)
            {
                arr[i] = int.Parse(Console.ReadLine());
            }

            int cnt = 0;
            int maxCnt = 0;
            int maxIndex = 0;
            int helper = int.MinValue;
            for (int i = 0; i < n; i++)
            {
                for (int j = i; j < n; j++)
                {
                    if (arr[j] > helper)
                    {
                        helper = arr[j];
                        
                        cnt++;
                    }
                }
                if (cnt > maxCnt)
                {
                    maxCnt = cnt;
                    maxIndex = i;
                }
                cnt = 0;
                helper = int.MinValue;
            }

            int[] arrNew = new int[maxCnt];
            for (int i = maxIndex; i < n; i++)
            {
                if (arr[i] > helper)
                {

                    helper = arr[i];
                    arrNew[cnt] = arr[i];
                    cnt++;
                }
            }


            foreach (int item in arrNew)
            {
                Console.Write(item + " ");
            }
            Console.WriteLine();
            


        }
    }
}

