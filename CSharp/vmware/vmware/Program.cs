using System;

namespace BinarySearchTree
{
    class Node
    {
        private int value;
        private Node left;
        private Node right;

        public Node(int v)
        {
            this.value = v;
            this.left = null;
            this.right = null;
        }
        public int Value
        {
            get { return this.value; }
            set { this.value = value; }
        }
        public Node Left
        {
            get { return this.left; }
            set { this.left = value; }
        }
        public Node Right
        {
            get { return this.right; }
            set { this.right = value; }
        }
    }

    class BinaryTree
    {
        public Node root;

        public void Insert(int value)
        {
            root = InsertRecursive(root, value);
        }

        public bool Search(int value)
        {
            return SearchRecursive(root, value);
        }

        private Node InsertRecursive(Node current, int value)
        {
            if (current == null)
            {
                return new Node(value);
            }
            else if (value <= current.Value)
            {
                current.Left = InsertRecursive(current.Left, value);
            }
            else
            {
                current.Right = InsertRecursive(current.Right, value);
            }
            return current;
        }

        private bool SearchRecursive(Node current, int value)
        {
            if (current == null)
            {
                return false;
            }
            else if (current.Value == value)
            {
                return true;
            }
            else if (current.Value < value)
            {
                return SearchRecursive(current.Right, value);
            }
            else
            {
                return SearchRecursive(current.Left, value);
            }

        }
    }
}

namespace _Program
{ 
    class Program
    {
        static void Main(string[] args)
        {

            BinarySearchTree.BinaryTree tree = new BinarySearchTree.BinaryTree();
            tree.Insert(15);
            tree.Insert(31);
            tree.Insert(7);
            tree.Insert(7);
            tree.Insert(3);
            tree.Insert(3);
            tree.Insert(1);
            tree.Insert(20);

            int n = 100;

            while (n != 0)
            {
                n = int.Parse(Console.ReadLine());

                bool search = tree.Search(n);

                Console.WriteLine(search);
            }
        }
    }
}