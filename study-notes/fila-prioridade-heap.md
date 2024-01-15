# Fila de prioridade e Heap

## Fila de prioridade

- É um tipo abstrato de dados para armazenar uma coleção de elementos priorizados que suporta a inserção de elementos arbitrários, mas suporta a remoão de elementos em ordem de prioridade, ou seja, o elemento com prioridade mais altapode ser removido a qualquer momento
- Esse TAD é fundamentalmente diferente das estruturas de dados como pilhas, filas, deques, listas e arvores
- Essas estruturas de dados armazenam elementos em posições específicas, que são frequentemente posições em uma estrutura linear de elementos, determinada pela sequência efetuada de inserções e remoções
- O TAD fila de prioridade armazena elementos de acordo com suas prioridades, e não tem noção de posição
- Uma fila de prioridade é um contêiner de elementos, cada um tendo uma chave associada atribuída no instante em que o elemento é inserido

## Heap

- É um tipo especial de árvore binária, também conhecida como heap binário
- Comumente aplicada em filas de prioridades por causa de sua eficiência para extrair rapidamente os valores mínimo e máximo
- Também é usado no algoritmo de heap sort
- Embora o heap binário seja uma árvore binária, ele não é necessariamente uma árvore binária de busca

### Propriedades

- Uma árvore binária completa, o que significa que todos os níveis da árvore têm filhos à esquerda e à direita (com exceção dos filhos no último nível) e o último nível tem todos os filhos o máximo possível à esquerda. Conhecido como pripriedade de forma
- Um heap binário é um heap mínimo ou um heap máximo. O Heap mínimo permite extrair rapidamente o valor mínimo de uma árvore, enquanto o heap máximo permite extrair rapidamente o valor máximo dela

![image HO0WH2](https://github.com/fredsonchaves07/java-datastructures/assets/43495376/5cae018b-2739-4202-97aa-bbc2225d80cd)
