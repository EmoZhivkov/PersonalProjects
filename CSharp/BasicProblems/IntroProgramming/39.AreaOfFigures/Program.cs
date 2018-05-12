using System;

namespace _39.AreaOfFigures
{
    class Program
    {
        static void Main(string[] args)
        {
            

            string shape = Console.ReadLine();
            var a = double.Parse(Console.ReadLine());

            if (shape == "square")
            {
                Console.WriteLine(a * a);
                
            }
            else if (shape == "circle")
            {
                Console.WriteLine(Math.PI * a * a);

            }
            else
            {
                var b = double.Parse(Console.ReadLine());

                if (shape == "rectangle")
                {
                    Console.WriteLine(a * b);
                }
                else if (shape == "triangle")
                {
                    Console.WriteLine(a * b / 2);
                }
            }
        }
    }
}
