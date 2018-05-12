using System;



    class Stars
    {
        static void Main(string[] args)
        {
            for(int i = 1; i <= 10; i++)
            {
                var row = new string('*', i);
                Console.WriteLine(row);
            }
        }
    }

