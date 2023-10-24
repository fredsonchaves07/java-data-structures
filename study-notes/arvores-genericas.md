# Arvores genéricas

- Estruturas do tipo árvore, são, na verdade, uma ruptura em organização de dados, pois permitem a implementação de uma gama de algoritmos muito mais rapidamente do que usando estruturas de dados lineares, como listas
- Árvores também oferecem uma forma natural de organizar os dados, e consequentemente, tornaram-se estruturas ubíquas em sistemas de arquivos, interfaces gráficas com o usuário, banco de dados, sites da web e outros sistemas computacionais.
- Uma árvore é um tipo abstrato de dados que armazena elementos de maneira hierarquica. Com exceção do elemento do topo, cada elemento da árvrore tem um elemento pai e zero ou mais elementos filhos

## Altura e profundidade

- A profundidade de um node de uma arvore é o número de ancestrais excluindo o próprio node
- A profundidade da raiz de T é zero
- A altura de um nodo é definida recursivamente
  - Se um nodo é externo, então a altura é zero
  - Em qualquer outro caso, a altura do node é mais a altura máxima dos filhos do node
- A altura de uma árvore não vazia é igual a profundidade máxima dos nodos externos da arvore

## Caminhamento prefixado

- O caminhamento de uma árvore T é uma forma sistemática de acessar ou visitar todos os nodos de T
- Em um caminhamento prefixado de uma árvore T, a raiz de T é visitado primeiro e, então, as subárvores, cujas raízes são seus filhos, são pecorridas recursivamente
- Se a árvore está ordenada, então as subarvores são pecorridas de acordo com a ordem dos filhos
- O caminhamento prefixado é útil para produzir uma ordenação linear dos nodos de uma árvore, na qual os pais devem aparecer antes dos filhos na ordenação
- Tais ordenações tem diferentes aplicações e é uma forma eficiente de se pecorrer todos os nodos de uma árvote
- 