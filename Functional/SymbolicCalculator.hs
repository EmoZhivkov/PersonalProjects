infixl 4 :+:
infixl 5 :*:, :/:
infixl 6 :^:

data Expr a = Var Char
            | Const a
            | (Expr a) :+: (Expr a)
            | (Expr a) :*: (Expr a)
            | (Expr a) :/: (Expr a)
            | (Expr a) :^: (Expr a)
            deriving (Show, Eq)

simplify :: (Num a, Eq a, Floating a) => Expr a -> Expr a
simplify (Const a :+: Const b) = Const $ a + b
simplify (a       :+: Const 0) = simplify a
simplify (Const 0 :+: a      ) = simplify a

simplify (Const a :*: Const b) = Const $ a * b
simplify (a       :*: Const 1) = simplify a
simplify (Const 1 :*: a      ) = simplify a
simplify (a       :*: Const 0) = Const 0
simplify (Const 0 :*: a      ) = Const 0

simplify (Const 0 :/: a      ) = Const 0
simplify (Const a :/: Const 0) = error "You cannot divide by zero!"
simplify (a       :/: Const 0) = error "You cannot divide by zero!"
simplify (Const a :/: Const b) | a == b = Const 1
simplify (a       :/: Const 1) = simplify a

simplify (Const a :^: Const b)         = Const $ a ** b
simplify (a       :^: Const 1)         = simplify a
simplify (a       :^: Const 0)         = Const 1
simplify ((c :^: Const b) :^: Const a) = c :^: (Const $ a * b)

simplify (Const a :*: Const b :*: expr   ) = (Const $ a * b) :*: (simplify expr)
simplify (Const a :*: expr    :*: Const b) = (Const $ a * b) :*: (simplify expr)
simplify (expr    :*: Const a :*: Const b) = (Const $ a * b) :*: (simplify expr)
simplify (Const a :*: (b :+: c))           = (Const a :*: (simplify b)) :+: (Const a :*: (simplify c))
simplify ((b :+: c) :*: Const a)           = (Const a :*: (simplify b)) :+: (Const a :*: (simplify c))

simplify (a :/: b)  = (simplify a) :/: (simplify b)
simplify (a :^: b)  = (simplify a) :^: (simplify b)
simplify (a :*: b)  = (simplify a) :*: (simplify b)
simplify (a :+: b)  = (simplify a) :+: (simplify b)
simplify x          = id x

negate' :: (Num a) => Expr a -> Expr a
negate'' (Var a)   = (Const (-1)) :*: (Var a)
negate' (Const a) = Const (-a)
negate' (a :+: b) = (negate' a) :+: (negate' b)
negate' (a :*: b) = (negate' a) :*: b
negate' (a :^: b) = Const (-1) :*: a :^: b
negate' (a :/: b) = (negate' a) :/: b

fullSimplify expr = fullSimplify' expr (Const 0)
    where fullSimplify' cur last | cur == last = cur
                                 | otherwise = let cur' = simplify cur
                                               in fullSimplify' cur' cur

mapVar :: (Char -> Expr a) -> Expr a -> Expr a
mapVar f (Var d)   = f d
mapVar _ (Const a) = Const a
mapVar f (a :+: b) = (mapVar f a) :+: (mapVar f b)
mapVar f (a :*: b) = (mapVar f a) :*: (mapVar f b)
mapVar f (a :^: b) = (mapVar f a) :^: (mapVar f b)
mapVar f (a :/: b) = (mapVar f a) :/: (mapVar f b)

plugIn :: Char -> a -> Expr a -> Expr a
plugIn c val = mapVar (\x -> if x == c then Const val else Var x)

evalExpr :: (Num a, Floating a) => Char -> a -> Expr a -> a
evalExpr c x = evalExpr' . plugIn c x

evalExpr' :: (Num a, Floating a) => Expr a -> a
evalExpr' (Const a) = a
evalExpr' (Var   c) = error $ "Variables ("
                              ++ [c] ++
                              ") still exist in formula. Try plugging in a value!"
evalExpr' (a :+: b) = (evalExpr' a) + (evalExpr' b)
evalExpr' (a :*: b) = (evalExpr' a) * (evalExpr' b)
evalExpr' (a :^: b) = (evalExpr' a) ** (evalExpr' b)
evalExpr' (a :/: b) = (evalExpr' a) / (evalExpr' b)




