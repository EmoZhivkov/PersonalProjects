using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace _65.VowelsSum
{
    class Program
    {
        static void Main(string[] args)
        {
            string text = Console.ReadLine();
            int sum = 0;
            for (int i = 0; i < text.Length; i++)
            {
                char ch = text[i];
                switch (ch)
                {
                    case 'a':
                        sum = sum + 1; break;
                    case 'e':
                        sum = sum + 2; break;
                    case 'i':
                        sum = sum + 3; break;
                    case 'o':
                        sum = sum + 4; break;
                    case 'u':
                        sum = sum + 5; break;
                }
            }
            Console.WriteLine(sum);
            
        }
    }
}
