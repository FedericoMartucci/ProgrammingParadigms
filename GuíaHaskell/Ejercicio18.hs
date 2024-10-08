-- Definir una función que elimine los duplicados de una lista.
filtraIguales :: Int -> [Int] -> [Int]
filtraIguales x [] = []
filtraIguales x (y:ys) = if x == y
then filtraIguales x ys
else y: filtraIguales x ys
 
miFilter :: (Int -> [Int] -> [Int]) -> Int -> [Int] -> [Int]
miFilter f x [] = []
miFilter f x y = f x y

eliminarDuplicados :: [Int] -> [Int]
eliminarDuplicados [] = []
eliminarDuplicados (x:xs) = x : eliminarDuplicados (miFilter filtraIguales x xs)

main = print(eliminarDuplicados [1, 2, 3, 4, 5, 2, 3, 6, 7, 8, 1, 9, 10, 6, 5]) -- Output: [1, 2, 3, 4, 5, 6, 7, 8, 9, 10]