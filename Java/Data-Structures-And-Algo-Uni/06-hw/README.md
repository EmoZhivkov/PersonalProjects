# First

The height of a binary tree is the number of edges between the tree's root and its furthest leaf. For example, the following binary tree is of height :

image
Function Description

Complete the getHeight or height function in the editor. It must return the height of a binary tree as an integer.

getHeight or height has the following parameter(s):

root: a reference to the root of a binary tree.
Note -The Height of binary tree with single node is taken as zero.

Input Format

The first line contains an integer , the number of nodes in the tree.
Next line contains  space separated integer where th integer denotes node[i].data.

Note: Node values are inserted into a binary search tree before a reference to the tree's root node is passed to your function. In a binary search tree, all nodes on the left branch of a node are less than the node value. All values on the right branch are greater than the node value.

Constraints



Output Format

Your function should return a single integer denoting the height of the binary tree.

Sample Input

image

Sample Output

3
Explanation

The longest root-to-leaf path is shown below:

image

There are  nodes in this path that are connected by  edges, meaning our binary tree's .

# Second

You are given a pointer to the root of a binary tree. Print the top view of the binary tree.
Top view means when you look the tree from the top the nodes, what you will see will be called the top view of the tree. See the example below.
You only have to complete the function.
For example :

   1
    \
     2
      \
       5
      /  \
     3    6
      \
       4
Top View : 1 -> 2 -> 5 -> 6

Input Format

You are given a function,

void topView(node * root) {

}
Constraints

1 Nodes in the tree  500

Output Format

Print the values on a single line separated by space.

Sample Input

   1
    \
     2
      \
       5
      /  \
     3    6
      \
       4
Sample Output

1 2 5 6

Explanation

   1
    \
     2
      \
       5
      /  \
     3    6
      \
       4
From the top only nodes 1,2,5,6 will be visible.

# Third

Дадено е двоично дърво с корен връх 1. Операцията pred(i, k) връща k-тия предшественик на върха i, като pred(i, 0) = i, pred(i, 1) = parent(i), pred(i, 2) = parent(parent(i)) и т.н. По зададеното двоично дърво и множество от заявки pred(i, k), за всяка заявка на нов ред изведете k-тия предшественик на върха i.

Input Format

На първия ред е зададено числото N - броя на върховете в дървото. На всеки от следващите N - 1 реда е зададена двойка x_j y_j съотвестваща на ребро в дървото, като върховете са номерирани с числата от 1 до N. На следващия ред е зададено числото Q - броя на заявките. Следват Q реда, като на всеки ред е зададена двойката i k, за която трябва да изведете pred(i, k).

Constraints

1 <= N <= 500 000

1 <= Q <= 500 000

pred(i, k) винаги ще съществува(тоест k <= depth(i))

Output Format

Изведете Q реда, като i-тия ред трябва да съдържа отговора на i-тата заявка

**Пример: **

Вход:

7
1 2
1 7
2 5
2 6
4 6
3 6
3
6 2
4 2
7 1
Изход:

1
2
1
Обяснение:

image

pred(6, 2) = parent(parent(6)) = parent(2) = 1

pred(4, 2) = parent(parent(4)) = parent(6) = 2

pred(7, 1) = parent(7) = 1
