-- Escribir una función que calcule el factorial de un número.
factorial :: Int -> Int
factorial x = foldl (*) 1 [1..x]

main = print( factorial 6 )