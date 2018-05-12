using System;


namespace _25.Vegetables
{
    class Program
    {
        static void Main(string[] args)
        {
            var veg = decimal.Parse(Console.ReadLine());
            var fru = decimal.Parse(Console.ReadLine());
            var kgVeg = int.Parse(Console.ReadLine());
            var kgFru = int.Parse(Console.ReadLine());

            decimal vegCost = veg * kgVeg;
            decimal fruCost = fru * kgFru;
            decimal answer = (vegCost + fruCost) / (decimal)1.94;
            
            Console.WriteLine(answer);
           
            
        }
    }
}
