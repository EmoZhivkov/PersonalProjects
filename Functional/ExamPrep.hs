data BinTree = EmptyTree | BinTree {root :: Int,
                                    left :: BinTree,
                                    right :: BinTree}
                deriving (Show)

insert :: Int -> BinTree -> BinTree
insert n EmptyTree = BinTree n EmptyTree EmptyTree
insert n (BinTree x left right)
    | x == n = BinTree x left right
    | x > n  = BinTree x (insert n left) right
    | x < n  = BinTree x left (insert n right)

five = 5
four = 4

oopa = x + y
    where x = five
          y = four
