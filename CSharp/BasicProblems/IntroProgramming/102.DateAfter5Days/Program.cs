using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace _102.DateAfter5Days
{
    class Program
    {
        static void Main(string[] args)
        {
            var date = int.Parse(Console.ReadLine());
            var month = int.Parse(Console.ReadLine());
            var afterdays = date + 5;

            if (month == 01 ||
                month == 03 ||
                month == 05 ||
                month == 07 ||
                month == 08 ||
                month == 10)
            {
                //31 days
                if (afterdays > 31)
                {
                    afterdays -= 31;
                    month++;
                }
            }
            else if (month == 04 ||
                     month == 06 ||
                     month == 09 ||
                     month == 11)
            {
                //30 days
                if (afterdays > 30)
                {
                    afterdays -= 30;
                    month++;
                }
            }
            else if (month == 02)
            {
                //28 days
                if (afterdays > 28)
                {
                    afterdays -= 28;
                    month++;
                }
            }
            else if (month == 12)
            {
                if (afterdays > 31)
                {
                    afterdays -= 31;
                    month = 1;
                }
            }
            Console.WriteLine("{0}.{1:00}", afterdays, month);
        }
    }
}
