using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace ConsoleApplication2
{
    class Program
    {
        static void Main(string[] args)
        {
            DateTime d = new DateTime(2003, 12, 30, 15, 30, 15);
            Console.WriteLine("{0:dd/MM/yyyy HH:mm:ss}", d);
            
        }
    }
}
