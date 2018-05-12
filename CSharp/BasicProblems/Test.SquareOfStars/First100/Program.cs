using System;


    class Program
    {
        static void Main(string[] args)
        {
            int i, j;
             for (i = 2; i <= 102; i = i + 1)
            {
                 if(i%2 == 0)
                 {
                     Console.Write(i);
                 }
                 else 
                 {
                     Console.Write(", " + -i + ", ");
                 }
            }
          
        }
    }
