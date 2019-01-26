import System.Random
import Control.Monad (replicateM)

import Data.List
import System.IO

-- Int
-- Float
-- Double
-- Bool - True or False
-- Char
-- Tuple

always5 :: Int
always5 = 5
sumOfNums = sum [1..1000]

num9 = 9 :: Int
sqrtOf9 = sqrt(fromIntegral num9)

primeNumbers = [3,5,7,11]
morePrime = primeNumbers ++ [13,17,19]

revPrime = reverse morePrime

first = [1,2,3,4,5]
second = [6,7,8,9,10]

mainName = do
    putStrLn "What's your name?"
    name <- getLine
    putStrLn ("Hello " ++ name)

addMe :: Int -> Int -> Int
addMe first second = first + second

addTuples :: (Int,Int) -> (Int,Int) -> (Int, Int)
addTuples (x,y) (x1, y1) = (x + x1, y + y1)

factorial 0 = 1
factorial n = n * factorial (n - 1)

isOdd :: Int -> Bool
isOdd n
    | n `mod` 2 == 0 = False
    | otherwise = True

whatGrade :: Int -> String
whatGrade age
    | (age >= 5) && (age <= 6) = "Kindergarden"
    | otherwise = "NoPEEE"

batAvgRating :: Double -> Double -> String
batAvgRating hits atBats
    | avg <= 0.200 = "Terrible"
    | avg <= 0.250 = "Average Player"
    | otherwise = "You are a superstar"
    where avg = hits / atBats

getListItems :: [Int] -> String
getListItems (x:[]) = show x
getListItems (x:xs) = show x ++ ", " ++ getListItems xs


data BaseballPlayer = Pitcher
                    | Catcher
                    | Infielder
                    | Outfielder
                deriving Show

barryBonds :: BaseballPlayer -> Bool
barryBonds Outfielder = True

data Customer = Customer String String Double
    deriving Show

tomSmith :: Customer
tomSmith = Customer "Tom Smith" "123 Main" 20.50

getBalance :: Customer -> Double
getBalance (Customer _ _ balance) = balance

data Shape = Circle Float Float Float
           | Rectandle Float Float


area :: Shape -> Float
area (Circle _ _ r) = pi * r ^ 2
area (Rectandle a b) = a * b

sumValue = putStrLn (show (1 + 2))
sumValue1 = putStrLn . show $ 1 + 2

data Employee = Employee {
    name :: String,
    position :: String,
    idNum :: Int
} deriving (Eq, Show)

samSmith = Employee {name = "Sam Smith", position = "lawnmower", idNum = 122334}
gosho = Employee {name = "Gosho", position = "janitor", idNum = 223}

data ShirtSize = S | M | L | XL

instance Eq ShirtSize where
    S == S = True
    M == M = True
    L == L = True
    XL == XL = True
    _ == _ = False


instance Show ShirtSize where
    show S = "Small"
    show M = "Medium"
    show L = "Large"
    show XL = "Extra Large"


sayHello = do
    putStrLn "WHat"
    name <- getLine
    putStrLn $ "Hello " ++ name

writeToFile = do
    theFile <- openFile "test.txt" WriteMode
    hPutStrLn theFile $ "Random line of text"
    hClose theFile

readFromFile = do
    theFile <- openFile "test.txt" ReadMode
    textInFile <- hGetContents theFile
    putStrLn textInFile
    hClose theFile




