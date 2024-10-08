-- Implementar una función que calcule la suma de los dígitos de un número entero.
sumarDigitos :: Int -> Int
sumarDigitos 0 = 0
sumarDigitos x = x `mod` 10 + sumarDigitos (x `div` 10)

main = print(sumarDigitos 9523) -- Output: 19