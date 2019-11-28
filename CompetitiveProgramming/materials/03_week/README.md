# Longest common prefix (LCP)  
In this example indexing starts from 1.  
## I. Let {SA} be the suffix array of string S
For this example SA contains the full suffix and not just the index of the starting character.  
## II. Let i ∈ ℕ, i < |SA|
SA[i]   = (a1,a2,a3,a4,a5...ak,ak+1,ak+2...)  
SA[i+1] = (b1,b2,b3,b4,b5...bk,bk+1,bk+2...)  
## III. Calculate the lcp of SA[i],SA[i+1]
lcp[i] = k, which means that the first k characters of SA[i] are equal to SA[i+1] or more formally  
a1=b1 ∧ a2=b2 ∧ a3=b3... ∧ ak=bk
## IV. Let j ∈ ℕ: j < |SA| ∧ a1+SA[i] = SA[j]
### 1)
SA[j] &nbsp;&nbsp; &nbsp;= (a2,a3,a4,a5...ak,ak+1,ak+2...)  
SA[j+1] = (a2,a3,a4,a5...ak,c,d...)  
SA[j+2] = (a2,a3,a4,a5...ak,e,f...)  
.  
.  
.  
SA[j+p] = (b2,b3,b4,b5...bk,g,h...)  
### 2)
SA[j] is the next suffix in the string after i, but the j_th in the suffix array.  
SA[j+p] is the next suffix in the string after i+1, but the j+p_th in the suffix array. It is not guaranteed  
that p is 1 because other strings may be lexicographically smaller than this suffix and simultaniously bigger  
than SA[j].  
### 3)
Since we already know that the letters up to index k are equal for each suffix in the range SA[j]:SA[j+p] and  
the array is sorted lexic., this means that the lcp for each of the suffixes in the range SA[i]:SA[j+p-1] is at least k-1.  
lcp[j] ≥ lcp[i]-1  
This fact allows us to calculate the lcp of each suffix in linear time.
