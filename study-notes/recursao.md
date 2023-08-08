# Recurs�o

- Uma outra forma de obter repeti��o de elementos
- Ocorre quando uma fun��o chama a si mesmo
- Qual a vantagem do uso da recurs�o? Embora a implementa��o recursiva da fun��o fatorial seja mais simples que a vers�o iterativa, nesse caso n�o existe nenhuma raz�o determinante para se preferir a vers�o recursiva sobre a iterativa
- Para alguns problemas, entretando, a implementa��o recursiva pode ser consideravelmente mais simples e mais f�cil de entender do que a vers�o iterativa
- Essa abordagem pode levar a descri��es de algoritmos mais leg�veis e ainda manter a efici�ncia

## Recurs�o Linear

- A forma mais simples de recurs�o na qual um m�todo � definido de maneira a fazer, no m�ximo, uma chamada recursiva toda vez que � ativado.
- Esse tipo de recurs�o � �til quando se analisam os problemas de algoritmo em termos do primeiro ou do �ltimo elemento mais um conjunto restante que tem a mesma estrutura do conjunto original
- Um dos exemplos que utiliza a recurs�o linear

```java
    public static int linearSum(int[] numbers, int size) {
        if (size == 1) return numbers[0];
        return linearSum(numbers, size - 1) + numbers[size - 1];
    }
```

- Esse exemplo demonstra uma propriedade importante que todo o m�todo recursivo deve respeitar - O m�todo termina.
- Garante-se essa propriedade escrevendo uma senten�a n�o recursiva para o caso n = 1
- Em diversas situa��es, a recurs�o � uma ferramenta �til para projetar algoritmos que t�m defini��es curtas e elegantes. Mas essa utilidade tem um custo. Quande se usa um algoritmo recursivo para resolver um problema, gasta-se uma certa quanditade de mem�ria para manter o estado de cada chamada recursiva ativa
- Quando a mem�ria do computador est� escasa, em alguns casos � interessante ser capaz de derivar um algoritmo n�o recursivo a partir de um recursivo
- Podemos usar a estrutura de dados pilha para converter um algoritmo recursivo em um n�o recursivo

## Recurs�o bin�ria

- Quando um algoritmo faz duas chamadas recursivas, diz-se que usa recurs�o bin�ria. Estas chamadas podem, por exemplo, ser usadas para resolver duas metades do mesmo problema
- Quando se usa recurs�o bin�ria, deve-se primeiro tentar particionar completamente o problema em dois ou � preciso est� convencido de que sucessivas chamadas recursivas s�o realmente necess�rias

## Recurs�o m�ltipla

- Use-se a recurs�o multipla quando um m�todo pode fazer v�rias chamadas recursivas em um n�mero potencialmente maior que dois.
- Uma das aplica��es mais comuns deste tipo de recurs�o � quando se deseja enumerar v�rias configura��es visando resolver um quebra-cabe�a combinat�rio
- 