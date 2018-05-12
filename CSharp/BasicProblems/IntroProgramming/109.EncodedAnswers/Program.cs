using System;


namespace _109.EncodedAnswers
{
    class Program
    {
        static void Main(string[] args)
        {
            var n = int.Parse(Console.ReadLine());
            if (n < 1 || n > 30)
            {

            }
            else
            {
                string a;
                string b;
                string c;
                string d;

                string all = null;

                long answA = 0;
                long answB = 0;
                long answC = 0;
                long answD = 0;
                for (int i = 1; i <= n; i++)
                {
                    var answer = long.Parse(Console.ReadLine());

                    if (answer % 4 == 0)
                    {
                        a = "a ";
                        answA += 1;
                        all = all + a;
                    }
                    else if (answer % 4 == 1)
                    {
                        b = "b ";
                        answB += 1;
                        all = all + b;
                    }
                    else if (answer % 4 == 2)
                    {
                        c = "c ";
                        answC += 1;
                        all = all + c;
                    }
                    else if (answer % 4 == 3)
                    {
                        d = "d ";
                        answD += 1;
                        all = all + d;
                    }
                }
                Console.WriteLine(all);
                Console.WriteLine("Answer A: {0}", answA);
                Console.WriteLine("Answer B: {0}", answB);
                Console.WriteLine("Answer C: {0}", answC);
                Console.WriteLine("Answer D: {0}", answD);
            }
        }

    }
}
