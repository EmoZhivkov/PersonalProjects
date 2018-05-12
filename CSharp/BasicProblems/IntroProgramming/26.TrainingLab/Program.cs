using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace _26.TrainingLab
{
    class Program
    {
        static void Main(string[] args)
        {
            var h = decimal.Parse(Console.ReadLine())*100;
            var w = decimal.Parse(Console.ReadLine())*100 - 100;
            var row = Math.Floor(h / 120);
            var place = Math.Floor(w / 70);
            var answer = row * place - 3;
            if(h >= 3 || w >= h || 100 >= w)
            {
                Console.WriteLine(answer);
            }
            else 
            {}
        }
    }
}
