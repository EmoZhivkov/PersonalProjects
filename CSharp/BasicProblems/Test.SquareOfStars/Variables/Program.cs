using System;

    class Program
    {
        static void Main(string[] args)
        {
            
            for (int i = 1; i <= 29; i++)
            {
                for (int j = 1; j <= 29; j++)
                {
                    if (j == i || i == 29)
                    {
                        Console.Write("*");
                    }
                    else
                    {
                        Console.WriteLine(" ");
                    }
                }

                Console.WriteLine();
            }


            for (int i = 1; i <= 29; i++)
            {
                for (int j = 1; j <= 29; j++)
                {
                    if (j == i || i == 29)
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

