using System;

namespace BinarySearchTree
{
    class Node
    {
        public int value;
        public Node left;
        public Node right;
    }

    class BinaryTree
    {
        public Node Insert(Node root, int value)
        {
            if (root == null)
            {
                root = new Node();
                root.value = value;
            }
            else if (value < root.value)
            {
                root.left = Insert(root.left, value);
            }
            else 
            {
                root.right = Insert(root.right, value);
            }
            return root;
        }

        public bool Search(Node root, int x)
        {
            if (root == null)
            {
                return false;
            }
            else if (root.value == x)
            {
                return true;
            }
            else if (root.value < x)
            {
                return Search(root.right, x);
            }
            else
            {
                return Search(root.left, x);
            }
            
        }
    }

    class BinarySearchTree
    {
        static void Main(string[] args)
        {
            Node root = null;
            BinaryTree tree = new BinaryTree();
            root = tree.Insert(root, 15);
            root = tree.Insert(root, 31);
            root = tree.Insert(root, 7);
            root = tree.Insert(root, 10);
            root = tree.Insert(root, 3);
            root = tree.Insert(root, 9);
            root = tree.Insert(root, 1);
            root = tree.Insert(root, 20);

            int n = 100;

            while(n != 0)
            {
                n = int.Parse(Console.ReadLine());

                bool search = tree.Search(root, n);

                Console.WriteLine(search);
            }
        }
    }
}
