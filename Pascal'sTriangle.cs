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
            int rows = int.Parse(Console.ReadLine());
            long[][] pascal = new long[rows][];
            //Insert the arrays in the jagged array
            for (int i = 1; i <= rows; i++)
            {
                pascal[i - 1] = new long[i];
            }
            //Make the first and last elements equal to 1
            for (int i = 0; i < rows; i++)
            {
                for (int j = 0; j < i + 1; j++)
                {
                    pascal[i][0] = 1;
                    if (j == i)
                    {
                        pascal[i][j] = 1;
                    }
                }
            }
            //Calculate the middle elements
            for (int i = 0; i < rows; i++)
            {
                for (int j = 0; j < i + 1; j++)
                {
                    if (j != 0 && j != i)
                    {
                        pascal[i][j] = pascal[i - 1][j - 1] + pascal[i - 1][j];
                    }
                }
            }
            //Output the Pascal Triangle with the correct formatting
            for (int i = 0; i < rows; i++)
            {
                for (int h = 0; h < rows - 1 - i; h++)
                {
                    Console.Write("  ");
                }

                for (int j = 0; j < i +1; j++)
                {

                    Console.Write(pascal[i][j] + "   ");
                    
                }
                Console.WriteLine();
            }

            //the only problem is that we do not print the triangle 
        }
    }
}

