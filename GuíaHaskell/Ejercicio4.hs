-- Definir una función maximoDeTres que devuelve el máximo de sus argumentos enteros
maximoDeTres :: Int -> Int -> Int -> Int
maximoDeTres x y z = if x > y && x > z
then x
else if y > x && y > z
then y
else z

main = print( maximoDeTres 0 0 0 )