# Fundamentos de Estrutura de Dados


## Métodos do `java.util` para Arrays e Números randomicos

- Java provê uma classe estática `java.util.Arrays` para executar tarefas comuns nos arrays
- Alguns dos métodos utilizados

### `equals(A, B)`

- Retorna `true` se o array A é igual ao array B
- É considerado 2 elementos para comparação

### `fill(A, x)`

- Preenche os espaçamentos de um array com o dado x desde que o array A permita o armazenamento deste tipo de valor

### `copyOf(A, n)`

- Retorna um array de tamanho n onde os elementos de A é copiado para um novo array retornado
- Esta matriz é copiada de A, onde k = min{n, A.length}
- Se n > A.length, então os últimos n − A.length elementos do array serão copiados com valores padrão. 0 para int e null para objetos

### `copyOfRange(A, s, t)`

- Retorna um array de tamanho t - s tal que cada elemento é copiado em ordem de A[s] até A[t - 1] onde s < t, preenchido com `copyOf()` se t > A.length

### `toString()`

- Retorna a representação em formato de String de um array
- Começando com "[" e terminando com "]"
- Os elementos são separados por ","
- A representação de cada elemento A[i] é obtida pelo método `String.valueOf(A[i])` retornando o elemento como string ou null como referência nula

### `sort()`

- Ordena os elementos de um array com base em uma ordenação natural
- Os elementos devem ser comparaveis

### `binarySearch(A, x)`

- Busca por um array ordenado A para um valor x.
- Retorna o index onde foi encontrado ou o indice onde o valor x pode ser inserido

