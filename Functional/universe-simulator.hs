import System.Random
import Control.Monad.Random

data Particle = HiggsBoson
              | BottomQuark
              | BottomAntiQuark
              | WeakBoson
              | Gluon
              | TauLepton
              | AntiTauLepton
              | CharmQuark
              | CharmAntiQuark
              | ZBoson
              | Photon
              | Muon
              | AntiMuon
              | TopQuark
              | TopAntiQuark
              | DownQuark
              | DownAntiQuark
              | WeirdQuark
              | WeirdAntiQuark
              | Pozitron
              | Electron
              | Neutrino
              | AntiNeutrino
              | UpQuark
              | UpAntiQuark
              deriving (Show)

decomposeHiggsBoson :: Int -> [Particle]
decomposeHiggsBoson number
         | number <= 648000  = [BottomQuark, BottomAntiQuark]
         | number <= 789000  = [WeakBoson, WeakBoson]
         | number <= 877200  = [Gluon, Gluon]
         | number <= 947600  = [TauLepton, AntiTauLepton]
         | number <= 980300  = [CharmQuark, CharmAntiQuark]
         | number <= 996200  = [ZBoson, ZBoson]
         | number <= 998430  = [Photon, Photon]
         | number <= 999540  = [Photon, ZBoson]
         | number <= 999784  = [Muon, AntiMuon]
         | number <= 1000000 = [TopQuark, TopAntiQuark]

decomposeWeakBoson :: Int -> [Particle]
decomposeWeakBoson number
         | number <= 333333  = [Pozitron, Neutrino]
         | number <= 666666  = [AntiMuon, Neutrino]
         | number <= 1000000 = [AntiTauLepton, Neutrino]

decomposeZBoson :: Int -> [Particle]
decomposeZBoson number
         | number <= 206000  = [Neutrino, AntiNeutrino]
         | number <= 240000  = [Electron, Pozitron]
         | number <= 274000  = [Muon, AntiMuon]
         | number <= 308000  = [TauLepton, TauLepton]
         | number <= 460000  = [DownQuark, DownAntiQuark]
         | number <= 612000  = [WeirdQuark, WeirdAntiQuark]
         | number <= 764000  = [BottomQuark, BottomAntiQuark]
         | number <= 882000  = [UpQuark, UpAntiQuark]
         | number <= 1000000 = [CharmQuark, CharmAntiQuark]

decomposeTopQuark :: Int -> [Particle]
decomposeTopQuark number
            | number <= 333333  = [WeakBoson, DownQuark]
            | number <= 666666  = [WeakBoson, WeirdQuark]
            | number <= 1000000 = [WeakBoson, BottomQuark]

decomposeTopAntiQuark :: Int -> [Particle]
decomposeTopAntiQuark number
             | number <= 333333  = [WeakBoson, DownAntiQuark]
             | number <= 666666  = [WeakBoson, WeirdAntiQuark]
             | number <= 1000000 = [WeakBoson, BottomAntiQuark]

decomposeParticle :: Particle -> (Int -> [Particle])
decomposeParticle HiggsBoson   = decomposeHiggsBoson
decomposeParticle WeakBoson    = decomposeWeakBoson
decomposeParticle ZBoson       = decomposeZBoson
decomposeParticle TopQuark     = decomposeTopQuark
decomposeParticle TopAntiQuark = decomposeTopAntiQuark

getParticleStability :: Particle -> Int
getParticleStability HiggsBoson   = 433
getParticleStability WeakBoson    = 500000
getParticleStability ZBoson       = 500000
getParticleStability TopQuark     = 129500
getParticleStability TopAntiQuark = 129500

isParticleActive :: Particle -> Bool
isParticleActive HiggsBoson   = True
isParticleActive WeakBoson    = True
isParticleActive ZBoson       = True
isParticleActive TopQuark     = True
isParticleActive TopAntiQuark = True
isParticleActive _            = False

getOnlyActive :: [Particle] -> [Particle]
getOnlyActive xs = filter isParticleActive xs
-- filter :: (a -> Bool) -> [a] -> [a]

getOnlyStable :: [Particle] -> [Particle]
getOnlyStable xs = filter (not . isParticleActive) xs

getRandomIntAndGenerator :: StdGen -> (Int, StdGen)
getRandomIntAndGenerator givenGen = (a, nextGen)
    where
        (a, nextGen) = randomR (1, 1000000) givenGen

getNthGenerator :: Int -> StdGen -> StdGen
getNthGenerator 0 g = next
          where
               (_, next) = getRandomIntAndGenerator g
getNthGenerator n g = getNthGenerator (n-1) next
          where
               (_, next) = getRandomIntAndGenerator g

decompose :: StdGen -> Particle -> [Particle]
decompose gen p = if randInt <= getParticleStability p
                  then decomposeParticle p randomDecompose
                  else [p]
                where
                    (randInt, nextGen)   = getRandomIntAndGenerator gen
                    (randomDecompose, _) = getRandomIntAndGenerator nextGen

decomposeAll :: StdGen -> [Particle] -> [Particle]
decomposeAll g (p:xs) = foldl (\ nv v -> ((decompose (getNthGenerator (length nv) g) v) ++ nv )) (decompose g p) xs

decomposeUntilChange :: StdGen -> Int -> [Particle] -> [Particle]
decomposeUntilChange g prevN xs = do
                         if currLen /= prevN
                         then xs
                         else (stables ++ (decomposeUntilChange next currALen (decomposeAll g actives)))
                    where
                         actives   = getOnlyActive xs
                         stables   = getOnlyStable xs
                         currLen   = length xs
                         currALen  = length actives
                         (_, next) = getRandomIntAndGenerator g

simulateHiggsBoson :: Int -> [Particle] -> IO()
simulateHiggsBoson n xs = if (length actives) == 0
               then do
                    print n
                    print xs
               else do
                    g <- newStdGen
                    print n
                    print xs
                    simulateHiggsBoson (n+1) (decomposeUntilChange g currLen xs)
          where actives = getOnlyActive xs
                currLen = length xs

main :: IO ()
main = do
    simulateHiggsBoson 1 [HiggsBoson]






