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
            int[] arr = { 1,2,3,4,5};

            int[] arrSorted = SortArray(arr);

            Console.WriteLine(BinarySearch(arrSorted));
        }

        public static int[] SortArray(int[]arr)
        {
            int[] arrSorted = new int[arr.Length];
            int minIndex = 0;
            int helper = int.MaxValue;
            for (int i = 0; i < arr.Length; i++)
            {
                for (int j = 0; j < arr.Length; j++)
                {
                    if (arr[j] < helper)
                    {
                        helper = arr[j];
                        minIndex = j;
                    }
                }

                arrSorted[i] = helper;
                helper = int.MaxValue;
                arr[minIndex] = int.MaxValue;
            }
            return arrSorted;
        }

        public static int BinarySearch(int[]arrSorted)
        {
            int min = 0;
            int max = arrSorted.Length - 1;
            int key = 4;
            int indexKey = 0;
            while (true)
            {
                int mid = (min + max) / 2;
                if (key > arrSorted[mid])
                {
                    min = mid;
                }
                else if (key < arrSorted[mid])
                {
                    max = mid;
                }
                else if (key == arrSorted[mid])
                {
                    indexKey = mid;
                    break;
                }
            }
            return arrSorted[indexKey - 1];
        }
        
    }
}

