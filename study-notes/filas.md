# Filas

- Outra esturura de dados fundamental que � semelhante a pilha por�m imeplementa o conceito FIFO (Primeiro que entra � o primeiro a siar)
- Existem diversas aplica��es da fila como por exemplo em sistemas que tratam as chamadas para uma central de reservas da bilheteria de um cinema por exemplo

## Implementa��o da fila baseado em arranjos

- A implementa��o � semelhante da pilha por�m usando o conceito de FIFO
- Da mesma forma que a implementa��o da pilha baseada em arranjo, a �nica desvantagem real da implementa��o de fila baseada em arranjo � que se define artificialmente a capacidade da fila em um valor fixo

## Implementa��o da fila usando uma lista encadeada gen�rica

- Pode-se implementar de forma eficiente a fila usando uma lista simplesmente encadeada. Por raz�es de efici�ncia, definiu-se que a frente da fila seja o in�cio da lista e que o fim da fila seja o final da lista

## Escalonadores round-robin

- Um uso popular de estruturas de dados fila � implementar um escalonador round-robin, no qual se itera por meio deuma cole��o de elementos de forma circular e atende-secada elemento executando uma certa a��o sobre ele