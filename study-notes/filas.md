# Filas

- Outra esturura de dados fundamental que é semelhante a pilha porém imeplementa o conceito FIFO (Primeiro que entra é o primeiro a siar)
- Existem diversas aplicações da fila como por exemplo em sistemas que tratam as chamadas para uma central de reservas da bilheteria de um cinema por exemplo

## Implementação da fila baseado em arranjos

- A implementação é semelhante da pilha porém usando o conceito de FIFO
- Da mesma forma que a implementação da pilha baseada em arranjo, a única desvantagem real da implementação de fila baseada em arranjo é que se define artificialmente a capacidade da fila em um valor fixo

## Implementação da fila usando uma lista encadeada genérica

- Pode-se implementar de forma eficiente a fila usando uma lista simplesmente encadeada. Por razões de eficiência, definiu-se que a frente da fila seja o início da lista e que o fim da fila seja o final da lista

## Escalonadores round-robin

- Um uso popular de estruturas de dados fila é implementar um escalonador round-robin, no qual se itera por meio deuma coleção de elementos de forma circular e atende-secada elemento executando uma certa ação sobre ele