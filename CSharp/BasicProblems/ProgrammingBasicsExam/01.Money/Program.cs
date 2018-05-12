using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace _01.Money
{
    class Program
    {
        static void Main(string[] args)
        {
            var bitcoin = double.Parse(Console.ReadLine());
            var chinese = double.Parse(Console.ReadLine());
            var comm = double.Parse(Console.ReadLine());

            var bitLeva = bitcoin * 1168;
            var chineseUSD = chinese * 0.15;
            var usdLeva = chineseUSD * 1.76;
            
            var leva = bitLeva + usdLeva;
            var euro = leva / 1.95;

            var commission = (comm / 100) * euro;

            var final = euro - commission;

            Console.WriteLine(final);
        }
    }
}
