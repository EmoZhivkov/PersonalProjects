using System;
using System.Globalization;


namespace _24.ThousandDaysAfterBirth
{
    class ThousandDaysAfterBirth
    {
        static void Main(string[] args)
        {
            string input = Console.ReadLine();
            string format = "dd-MM-yyyy";
            CultureInfo provider = CultureInfo.InvariantCulture;
            DateTime dayOfbirth = DateTime.ParseExact(input, format, provider);

            

            DateTime thousand = dayOfbirth.AddDays(999);
            Console.WriteLine(thousand.ToString("dd-MM-yyyy"));
        }
    }
}
