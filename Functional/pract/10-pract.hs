--syntactic sugar
type Point = (Double, Double)

newtype Natural = Natural Integer
    deriving(Show)

natural::Integer -> Natural
natural x = if x < 0 then error "Nats can't be less then 0"
                     else Natural x

--enum
data Language = Haskell
              | Ruby
              | Python
    deriving(Show)


type FN = Int
type StudentName = String

data Student = Stud FN StudentName Language
    deriving(Show)

doingWellInLife :: Student -> Bool
doingWellInLife (Stud 823823 _ _) = False
doingWellInLife (Stud fn name lang) = fn < 1000000 && name == "Georgi"

data IntList = Nil
            | Cons Int IntList
        deriving(Show)


mapInt :: (Int -> Int) -> IntList -> IntList
mapInt _ Nil = Nil
mapInt f (Cons x xs) = Cons (f x) (mapInt f xs)

data CalcExpr = Number Integer
              | Succ CalcExpr
              | Pred CalcExpr
              | Add CalcExpr CalcExpr
              | Sub CalcExpr CalcExpr
              | Pow CalcExpr CalcExpr
              | If CalcExpr CalcExpr CalcExpr
    deriving(Show)

eval :: CalcExpr -> Integer
eval (Number n) = n
eval (Succ n)   = (eval n) + 1
eval (Pred n)   = (eval n) - 1
eval (Add l r)  = (eval l) + (eval r)
eval (Sub l r)  = (eval l) - (eval r)
eval (Pow n p)  = (eval n) ^ (eval p)
eval (If cond zero num) = if (eval cond) == 0 then (eval zero) else (eval num)

type Name = String
-- Implies (Const True) (Const False)
-- Implies (Var "X") (Var "Y")
data Prop = Const Bool
          | Var Name
          | Not Prop
          | And Prop Prop
          | Or Prop Prop
          | Implies Prop Prop
    deriving(Show)



boolExprEq :: Prop -> Prop -> Bool
boolExprEq (Const x) (Const y)                           = x == y
boolExprEq (Var first) (Var second)                      = first == second
boolExprEq (Not first) (Not second)                      = (boolExprEq first second)
boolExprEq (And first second) (And third fourth)         = (boolExprEq first third) && (boolExprEq second fourth)
boolExprEq (Or first second) (Or third fourth)           = (boolExprEq first third) && (boolExprEq second fourth)
boolExprEq (Implies first second) (Implies third fourth) = 




