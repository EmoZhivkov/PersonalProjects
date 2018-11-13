null' :: [a] -> Bool
null' [] = True
null' (_:_) = False

head' :: [a] -> a
head' []    = error "The list is empty"
head' (x:_) = x

tail' :: [a] -> [a]
tail' []     = error "The list is empty"
tail' (x:xs) = xs

take' :: Integer -> [a] -> [a]
take' 0 xs     = []
take' n []     = []
take' n (x:xs) = x : take' (n - 1) xs

drop' :: Integer -> [a] -> [a]
drop' 0 xs  = xs
drop' n []  = []
drop' n (x:xs) = drop' (n - 1) xs

(!) :: [a] -> Integer -> a
[]    ! n = error "Prost li si veee"
(x:_) ! 0 = x
(x:xs) ! n = xs ! (n - 1)

length' :: [a] -> Integer
length' []     = 0
length' (_:xs) = 1 + length' xs

rev :: [a] -> [a]
rev xs = helper xs []
    where helper :: [a] -> [a] -> [a]
          helper [] xs     = xs
          helper (x:xs) ys = helper xs (x:ys)


map' :: (a -> b) -> [a] -> [b]
map' f []     = []
map' f (x:xs) = ((f x) : map' f xs)



