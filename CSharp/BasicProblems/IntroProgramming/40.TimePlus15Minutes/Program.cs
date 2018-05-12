using System;

namespace _40.TimePlus15Minutes
{
    class Program
    {
        static void Main(string[] args)
        {
            var hours = int.Parse(Console.ReadLine());
            var minutes = int.Parse(Console.ReadLine());

            minutes = minutes + 15;

            if (minutes > 59)
            {
                hours = hours + 1;
                minutes = minutes - 60;
            }

            if (hours > 23)
            {
                hours = 0;
            }


            Console.WriteLine("{0}:{1:D2}", hours, minutes);
        }
    }
}
