-- Task 3
type Segment = (Integer, Integer, Integer)
type Fugue = [Segment]

durationOfSegment :: Segment -> Double
durationOfSegment (tact, size, tempo) = ((fromInteger tact :: Double) * (fromInteger size :: Double))/ (fromInteger tempo :: Double)

duration :: Fugue -> Double
duration []     = 0
duration (x:xs) = durationOfSegment x + duration xs

isSegmentBigger :: Segment -> Segment -> Bool
isSegmentBigger (tact1, size1, tempo1) (tact2, size2, tempo2) = durationOfSegment (tact1, size1, tempo1) > durationOfSegment (tact2, size2, tempo2) && tempo1 < tempo2

quickSortByDurationAndTempo :: Fugue -> Fugue
quickSortByDurationAndTempo (x:[]) = [x]
quickSortByDurationAndTempo (x:xs) = quickSortByDurationAndTempo ( filter (not . isSegmentBigger x) xs ) ++ [x] ++ quickSortByDurationAndTempo (filter (isSegmentBigger x) xs)

longestLowest :: Fugue -> Segment
longestLowest fugue = head sortedFugue
    where sortedFugue = quickSortByDurationAndTempo fugue

