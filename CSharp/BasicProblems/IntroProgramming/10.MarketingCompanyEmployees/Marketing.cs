using System;



    class Marketing
    {
        static void Main(string[] args)
        {
            Console.Write("First Name: ");
                string firstName = Console.ReadLine();
                Console.WriteLine();
            Console.Write("Last Name: ");
                string lastName = Console.ReadLine();
                Console.WriteLine();
            Console.Write("Age: ");
                byte age = byte.Parse(Console.ReadLine());
                Console.WriteLine();
            Console.Write("Sex(m or f): ");
                char sex = char.Parse(Console.ReadLine());
                Console.WriteLine();
            Console.Write("Personal Employee Number: ");
                uint employeeNumber = uint.Parse(Console.ReadLine());
                Console.WriteLine();
        }
    }

