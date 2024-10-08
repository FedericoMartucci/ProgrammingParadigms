-- Definir una función que calcule el máximo común divisor de dos números.
calcularMCD :: Int -> Int -> Int
calcularMCD x 0 = x
calcularMCD x y = calcularMCD y (x `mod` y)

main = print(calcularMCD 2366 273) -- Output: 91