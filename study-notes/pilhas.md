# Pilhas

- É uma coleção de objetos que são inseridos e retirados de acorodo com o príncipio de que o último que entra é o primeiro que sai (LIFO)
- O nome pilha deriva-se da metáfora de uma pilha de pratos em uma cantina
- São utilizadas em diversos tipos de aplicação

## Implementação de uma pilha baseada em arranjos

- Pode-se implementar uma pilha armazenando-se seus elementos em um arranjo
- A implementação é simples e eficiente, porém tem um aspecto negativo. Ela deve assumir um limite superior fixo que define a capacidade máxima da pilha
- Uma aplicação real pode precisar de muito ou menos espaço, que no caso, pode ocorrer despedício ou falta de memória

## Implementação de uma pilha usando lista encadeada genérica

- A pilha pode ser implementada usando uma lista na qual o topo da pilha é o último nodo adicionado da lista