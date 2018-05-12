using System;

    class Program
    {
        static void Main(string[] args)
        {
            var n = int.Parse(Console.ReadLine());
            for (int i = 1; i <= n; i++)
            {
                for (int j = 1; j <= n; j++)
                {
                    if (i == 1 || j == 1 || i == n || j == n || i == n/2 + 1 || j == n/2 + 1 || i + j == n + 1 || i == j)
                    {
                        Console.Write("*");
                    }
                    else
                    {
                        Console.Write(" ");
                    }
                }
                    
                    Console.WriteLine();
            }
        }
    }

