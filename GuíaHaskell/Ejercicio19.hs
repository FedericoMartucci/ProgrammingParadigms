-- Implementar una función que obtenga el producto de todos los elementos de una lista.
productoLista :: [Int] -> Int
productoLista [] = 1
productoLista (x:xs) = x * productoLista xs

-- Forma sencilla: foldl (*) 1 [1, 2, 3, 4, 5, 6]
main = print(productoLista [1, 2, 3, 4, 5, 6]) -- Output: 720