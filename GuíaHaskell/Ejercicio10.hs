-- Definir una función que determine si una lista está ordenada de forma ascendente.
esOrdenadaAscendente :: [Int] -> Bool
esOrdenadaAscendente [] = True
esOrdenadaAscendente [x] = True
esOrdenadaAscendente (x:xs) = if x <= head xs
then esOrdenadaAscendente xs
else False

main = print(esOrdenadaAscendente [5, 4, 3, 2, 1])