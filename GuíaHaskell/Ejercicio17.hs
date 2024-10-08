-- Implementar una función que verifique si una cadena de texto es un palíndromo.
esPalindromo :: [Char] -> Bool
esPalindromo [] = True
esPalindromo [x] = True
esPalindromo (x:xs) = if x == last xs
then esPalindromo (init xs)
else False


main = print(esPalindromo "neuquen")