-- Implementar una función que calcule el área de un círculo dado su radio.
potencia :: Float -> Int -> Float
potencia x 0 = 1
potencia x y = x * potencia x (y - 1)

calcularArea :: Float -> Float
calcularArea x = pi * potencia x 2

main = print( calcularArea  1.2 )