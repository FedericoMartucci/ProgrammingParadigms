-- Definir una función que encuentre el elemento mínimo en una lista.
buscarMinimo :: Int -> [Int] -> Int
buscarMinimo x (y:ys) = if x < y
then minimo (x : ys)
else minimo (y : ys)

minimo [] = 0
minimo [x] = x
minimo (x:xs) = buscarMinimo x xs

main = print(minimo [23, 84, 5, 10, 5, 99, 5, 55]) -- Output: 5

{-
 Solucion con currying:
minimo :: Int -> Int -> Int
minimo x y = if x < y
then x
else y

buscar :: (Int -> Int -> Int) -> [Int] -> Int
buscar f [] = 0
buscar f [x] = x
buscar f (x:y:ys) = buscar f (f x y : ys)

buscarMinimo :: [Int] -> Int
buscarMinimo x = buscar minimo x

main = print(buscarMinimo [23, 84, 5, 10, 1, 99, 5, 55]) -- Output: 5

-}