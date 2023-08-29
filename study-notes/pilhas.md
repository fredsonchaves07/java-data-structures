# Pilhas

- � uma cole��o de objetos que s�o inseridos e retirados de acorodo com o pr�ncipio de que o �ltimo que entra � o primeiro que sai (LIFO)
- O nome pilha deriva-se da met�fora de uma pilha de pratos em uma cantina
- S�o utilizadas em diversos tipos de aplica��o

## Implementa��o de uma pilha baseada em arranjos

- Pode-se implementar uma pilha armazenando-se seus elementos em um arranjo
- A implementa��o � simples e eficiente, por�m tem um aspecto negativo. Ela deve assumir um limite superior fixo que define a capacidade m�xima da pilha
- Uma aplica��o real pode precisar de muito ou menos espa�o, que no caso, pode ocorrer desped�cio ou falta de mem�ria

## Implementa��o de uma pilha usando lista encadeada gen�rica

- A pilha pode ser implementada usando uma lista na qual o topo da pilha � o �ltimo nodo adicionado da lista