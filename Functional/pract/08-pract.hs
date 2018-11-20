apply :: (a -> b) -> a -> b
apply f x = f x

applyTwice :: (a -> a) -> a -> a
applyTwice f x = f (f x)

compose :: (b -> c) -> (a -> b) -> a -> c
compose f g x = f (g x)

filter' :: (a -> Bool) -> [a] -> [a]
filter' f [] = []
filter' f (x:xs) =
        if  f x
            then x : filter' f xs
            else filter' f xs

partition' :: (a -> Bool) -> [a] -> ([a],[a])
partition' f [] = ([],[])
partition' f xs = (filter' f xs, filter' (not . f) xs)

quickSort :: [Integer] -> [Integer]
quickSort []     = []
quickSort (p:xs) = (quickSort lesser) ++ [p] ++ (quickSort greater)
            where (lesser, greater) = partition' (< p) xs

foldl' :: (a -> b -> b) -> b -> [a] -> b
foldl' f nv []     = nv
foldl' f nv (x:xs) = foldl' f (f x nv) xs

foldr' :: (a -> b -> b) -> b -> [a] -> b
foldr' f nv []     = nv
foldr' f nv (x:xs) = f x (foldr' f nv xs)

map' :: (a -> b) -> [a] -> [b]
map' f []     = []
map' f (x:xs) = f x : map' f xs