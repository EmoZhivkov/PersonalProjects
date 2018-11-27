-- l = [1..10]
-- [x | x <- [0..], even x]


cartesian :: [a] -> [b] -> [(a,b)]
cartesian xs ys = [(x, y) | x <- xs, y <- ys]

iterate' :: (a -> a) -> a -> [a]
iterate' f x = x : iterate' f (f x)

nats' :: [Integer]
nats' = iterate' succ 0

divides :: Integer -> Integer -> Bool
divides x y = (mod y x) == 0

divisors :: Integer -> [Integer]
divisors x = [ y | y <- [1..x], divides y x ]

isPrime :: Integer -> Bool
isPrime x = divisors x == [1, x]

primes :: [Integer]
primes = [x | x <- [1..], isPrime x]

eratosthenes :: [Integer] -> [Integer]
eratosthenes (x:xs) = x : eratosthenes (filter (\a -> not (divides x a)) xs)

primes' :: [Integer]
primes' = eratosthenes [2..]

partitionPos :: Integer -> [(Integer, Integer)]
partitionPos n = [(x, n - x) | x <- [1..n - 1]]

--partitionPos n = [(x,y) | x <- [1..n], y <- [1..n], x + y == n]
positive2Tuples :: [(Integer, Integer)]
positive2Tuples = concat [ (partitionPos x) | x <- [1..]]

fact :: Integer -> Integer
fact 1 = 1
fact n = n * fact (n - 1)

facts :: [Integer]
facts = [(fact x) | x <- [1..]]

fib :: Integer -> Integer
fib 0 = 0
fib 1 = 1
fib 2 = 1
fib n = fib (n - 2) + fib (n - 1)

fibs :: [Integer]
fibs = map fib nats'

foldl' :: (b -> a -> b) -> b -> [a] -> b
foldl' _ nv [] = nv
foldl' f nv (x:xs) = foldl' f (f nv x) xs

scanl' :: (b -> a -> b) -> b -> [a] -> [b]
scanl' _ nv [] = [nv]
scanl' f nv (x:xs) = nv : (scanl' f (f nv x) xs)