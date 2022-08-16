# Fundamentos de Estrutura de Dados

## Introdução

- Organização de dados em memória
- Mecanismos de organização de dados que atendem diferentes requisitos de processamento
- Presentes em diversos meios tecnológicos
- Principais estruturas de dados básicas:
  - Arrays;
  - LinkedList
  - CircularLinkedList
  - DoublyLinkedList
  - Stack
  - Deque
  - Tree

## Usando Arrays

- Por padrão utilizamos os arrays quando queremos definir um conjunto de elementos
- Variável dinâmica que armazena alguns dados de mesmo tipo
- O Java possui uma implementação padrão do array
- É definido geralmente pelo uso de `[]`  que pode ser acessado por indices
- Como exemplo, utilizamos uma aplicação que armazena dados de pontuação de jogadores
![Captura de tela de 2022-08-10 20-50-19](https://user-images.githubusercontent.com/43495376/184044967-9c62c3c8-fad3-43e0-8082-4aa5ff806f43.png)

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