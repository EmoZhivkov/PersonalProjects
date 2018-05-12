using System;
using System.Collections.Generic;
using System.Globalization;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace ConsoleApplication1
{
    class Program
    {
        static void Main(string[] args)
        {
            string input = Console.ReadLine();
            string format = "dd-MM-yyyy";
            CultureInfo provider = CultureInfo.InvariantCulture;

            DateTime dayOfbirth = DateTime.ParseExact(input, format, provider);
            DateTime answer = dayOfbirth.AddDays(999);

            Console.WriteLine(answer.ToString("dd-MM-yyyy"));
        }
    }
}
