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