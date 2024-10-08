-- Escribir una función que cuente la cantidad de elementos en una lista.
-- contarElementos :: [Int] -> Int
contarElementos [] = 0
contarElementos (x:xs) = 1 + contarElementos xs

main = print(contarElementos ['a', 'b', 'c'])