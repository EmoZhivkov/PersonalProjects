using System;

    class Program
    {
        static void Main(string[] args)
        {
            var n = int.Parse(Console.ReadLine());
            if (n <= 100 && n >= 2)
            {
                for (int i = 1; i <= n; i++)
                {   
                    for (int j = 1; j <= n; j++)
                    {
                        if (i == 1 || j == 1 || i == n || j == n)
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
    }

