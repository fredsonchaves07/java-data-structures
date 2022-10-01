# Arrays e Listas

## Usando Arrays

- Por padrão utilizamos os arrays quando queremos definir um conjunto de elementos
- Variável dinâmica que armazena alguns dados de mesmo tipo
- O Java possui uma implementação padrão do array
- É definido geralmente pelo uso de `[]`  que pode ser acessado por indices
- Como exemplo, utilizamos uma aplicação que armazena dados de pontuação de jogadores
  ![Captura de tela de 2022-08-10 20-50-19](https://user-images.githubusercontent.com/43495376/184044967-9c62c3c8-fad3-43e0-8082-4aa5ff806f43.png)
- Um array os dados estão armazenados contiguamente (Um ao lado da outra) na memória
- Complexidade do array:
  - Leitura: O(1)
  - Inserção: O(n)
  - Deleção: O(n)
- Para as operações de leitura e deleção os arrays são ruim tendo em vista que é necessário o deslocamento dos elementos no array

## Usando Listas encadeadas
- É um conjunto de elementos que não necessáriamente precisam ser armazenados contiguamente
- Um elemento possui endereço que aponta para outro elemento
- A inserção de dados é similar um array
- Complexidade da lista encadeada:
  - Leitura: O(n)
  - Inserção: O(1)
  - Deleção: O(1)
- As listas encadeadas são melhores caso quisessemos inserir elementos. Tanto no final como também no meio da lista
- A deleção também é melhor em listas encadeadas. Basta alterar a referencia do próximo elemento

## Acesso aleatório e sequencial
- Os arrays permitem acesso aleatório dos dados
- As listas encadeadas permitem o acesso sequencial