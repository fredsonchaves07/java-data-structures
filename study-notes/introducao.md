# Introdução

## O que é estruturas de dados?

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

## Pesquisa binária

- É um algoritmos que realiza a busca dos dados ordenado retornando a sua localização, caso encontrado
- A lista de dados é dividida ao meio que dependendo do valor pode ser procurado no primeiro quadrante ou segundo

![image 2LE6R1](https://user-images.githubusercontent.com/43495376/189700224-0a26d7fe-f6f1-4171-a962-f7ec63e65c8b.png)

- Para uma lista de n números, a pesquisa binária precisa de log2n para retornar o valor correto, enquanto a pesquisa simples precisa de n etapas
- A pesquisa binária deve ser utilizada quando os dados estão ordenados caso contrário ela não será tão eficiente
- Algumas diferenças entre pesquisa binária e simples

![image LCD1S1](https://user-images.githubusercontent.com/43495376/190292049-26310c18-284f-4e6f-a861-e4dce16fbbe1.png)

## Notação Big O

- Define o quão rápido é a execução do algoritmo
- Utilizado para definir perfomance no tempo de execução de um código
- A rapidez de um algoritmo é medido pelo crescimento do número de operações

![image P79ET1](https://user-images.githubusercontent.com/43495376/192899740-24ff1a9e-1650-467d-a5f4-6c1a7b233323.png)

- Alguns exemplos comuns de tempo de execução Big O
    -   O(log n) -> Conhecido como **tempo logaritmo**
    -   O(n) -> Conecido como **tempo linear**
    -   O(n * log n) -> É o tempo de execução de um algoritmo rápido de ordenação como quicksort
    -   O(n2) -> É o tempo de execução de um algoritmo lento de ordenação como por seleção
    -   O(n1) -> É o tempo bastante lento. Como exemplo temos o problema do caixeiro viajante
    
![Captura de tela de 2022-09-28 19-55-21](https://user-images.githubusercontent.com/43495376/192902752-154d691f-197d-4006-ba25-ae0bd62dd308.png)
