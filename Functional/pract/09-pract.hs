-- l = [1..10]
-- [x | x <- [0..], even x]


cartesian :: [a] -> [b] -> [(a,b)]
cartesian xs ys = [(x, y) | x <- xs, y <- ys]

iterate' :: (a -> a) -> a -> [a]
iterate' f x = []