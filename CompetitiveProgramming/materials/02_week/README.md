# 1. Meet-in-middle subset modulo
Given a set of integers S and a number M, find the subset where the sum of its elements modulo M is maximal.
|S| <= 38

# 2. String hash compare
You are given a string S and then a number of queries. Each query consists of 4 numbers a1,a2,b1,b2 < |S| and a1<a2 and b1<b2. For each query find whether the substring of S from a1 to a2 is equal to the substring of S from b1 to b2.  
The queries are less than 1000000. |S| <= 100000.

# 3. Suffix array
Given a string S and another one T, find the suffix array of the construction S+'$'+T.

# 4. Suffix automaton
Let S0 = "a";  
S1 = S0+"b"+S0  
S2 = S1+"c"+S1  
...  
S25 = S24+"z"+S24  
Find the number of appearances of string T in Si, where T and i are given to you at the start.  
i <= 25, |T|<=10000.
