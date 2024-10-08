-- Definir una función menor que devuelve el menor de sus dos argumentos enteros
menor :: Int -> Int -> Int
menor x y = if x > y
then y
else x

main = print( menor 4 6 )