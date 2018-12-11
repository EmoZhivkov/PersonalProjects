merge :: Ord a => [a] -> [a] -> [a]
merge xs [] = xs
merge [] xs = xs
merge (x:xs) (y:ys)
    | x < y = x : merge xs (y:ys)
    | otherwise = y : merge (x:xs) ys

mergesort :: Ord a => [a] -> [a]
mergesort []     = []
mergesort (x:[]) = [x]
mergesort xs = merge (mergesort firstHalf) (mergesort secondHalf)
    where (firstHalf, secondHalf) = splitAt (length xs `quot` 2) xs

type TvShow = (String, (Int, Int), Int)

lastShow :: [TvShow] -> TvShow





