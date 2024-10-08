-- Implementar una función que obtenga los elementos en posiciones pares de una lista.
esPar :: Int -> Bool
esPar x = if x `mod` 2 == 0
then True
else False

miFilter :: (Int -> Bool) -> [Int] -> [Int]
miFilter f [] = []
miFilter f (x:xs) = if f x
then x : miFilter f xs
else miFilter f xs

main = print(miFilter esPar [1, 2, 3, 4, 5, 6])