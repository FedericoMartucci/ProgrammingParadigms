-- Escribir una función que obtenga el enésimo número de la secuencia de Fibonacci.
-- O(n)
fibonacci2 :: Int -> Int
fibonacci2 n = fibHelper 0 1 n
  where
    fibHelper a b 0 = a
    fibHelper a b n = fibHelper b (a + b) (n - 1)

-- O(n^2)
fibonacci :: Int -> Int
fibonacci 0 = 1
fibonacci 1 = 1
fibonacci x = fibonacci (x - 1) + fibonacci (x - 2)

main = print(fibonacci 50) -- Output: 5