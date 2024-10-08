-- Definir una función que determine si un número es par o impar.
esPar:: Int -> Bool
esPar x = if x `mod` 2 == 0
then True
else False

main = print( esPar 3 )