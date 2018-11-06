f x = x + 1

--fact n = if n == 0 then 1 else n * fact (n - 1)

fact' 0 = 1
fact' n = n * fact' (n - 1)

fib 0 = 0
fib 1 = 1
fib x = fib (x - 1) + fib (x - 2)

myPlus 0 y = y
myPlus x y = myPlus (x - 1) (y + 1)

myPlus' x y
    | x == 0    = y
    | otherwise = myPlus (x - 1) (y + 1)

myProduct x y
    |