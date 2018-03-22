using System;

namespace BinarySearchTree
{
    //The binary tree contains nodes which have a value
    //and are connected to the nodes on the left and right
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

    //The binary tree has its own root, Search and Insert methods
    class BinaryTree
    {
        public Node root;

        //The Insert function takes a value and calls the InsertRecursive method
        //with the root Node and a value
        public void Insert(int value)
        {
            root = InsertRecursive(root, value);
        }

        //The SearchTree method takes a value and calls the SearchRecursive method
        //with the root Node and a value
        public bool SearchTree(int value)
        {
            return SearchRecursive(root, value);
        }

        //Recursively inserts the element
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

        //Recursively searches for the element
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

    //Contains the Search method
    class SearchMethod
    {
        //The Search method takes a tree and a value and calls the SearchTree method with the value
        public static bool Search(BinaryTree tree, int value)
        {
            return tree.SearchTree(value);
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

                bool search = BinarySearchTree.SearchMethod.Search(tree, n);

                Console.WriteLine(search);
            }
        }
    }
}