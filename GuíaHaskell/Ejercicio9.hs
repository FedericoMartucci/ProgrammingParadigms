-- Implementar una función que invierta una lista.
invertirLista :: [Int] -> [Int]
invertirLista [] = []
invertirLista (x:xs) = (invertirLista xs) ++ [x]

invertirLista2 :: [Int] -> [Int]
invertirLista2 = reverse

main = print( invertirLista [1, 2, 3, 4, 5, 6] )