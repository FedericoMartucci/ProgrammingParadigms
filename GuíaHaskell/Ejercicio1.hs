{-
    Dado dos números enteros A y B, implemente una función que retorne la división entera de ambos por el método de las restas sucesivas
-}

dividir :: Int -> Int -> Int
dividir a 0 = -1
dividir a b = if a >= b
then 1 + dividir (a - b) b
else 0

main = print( dividir 25 0)