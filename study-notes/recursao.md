# Recursão

- Uma outra forma de obter repetição de elementos
- Ocorre quando uma função chama a si mesmo
- Qual a vantagem do uso da recursão? Embora a implementação recursiva da função fatorial seja mais simples que a versão iterativa, nesse caso não existe nenhuma razão determinante para se preferir a versão recursiva sobre a iterativa
- Para alguns problemas, entretando, a implementação recursiva pode ser consideravelmente mais simples e mais fácil de entender do que a versão iterativa
- Essa abordagem pode levar a descrições de algoritmos mais legíveis e ainda manter a eficiência

## Recursão Linear

- A forma mais simples de recursão na qual um método é definido de maneira a fazer, no máximo, uma chamada recursiva toda vez que é ativado.
- Esse tipo de recursão é útil quando se analisam os problemas de algoritmo em termos do primeiro ou do último elemento mais um conjunto restante que tem a mesma estrutura do conjunto original
- Um dos exemplos que utiliza a recursão linear

```java
    public static int linearSum(int[] numbers, int size) {
        if (size == 1) return numbers[0];
        return linearSum(numbers, size - 1) + numbers[size - 1];
    }
```

- Esse exemplo demonstra uma propriedade importante que todo o método recursivo deve respeitar - O método termina.
- Garante-se essa propriedade escrevendo uma sentença não recursiva para o caso n = 1
- Em diversas situações, a recursão é uma ferramenta útil para projetar algoritmos que têm definições curtas e elegantes. Mas essa utilidade tem um custo. Quande se usa um algoritmo recursivo para resolver um problema, gasta-se uma certa quanditade de memória para manter o estado de cada chamada recursiva ativa
- Quando a memória do computador está escasa, em alguns casos é interessante ser capaz de derivar um algoritmo não recursivo a partir de um recursivo
- Podemos usar a estrutura de dados pilha para converter um algoritmo recursivo em um não recursivo

## Recursão binária

- Quando um algoritmo faz duas chamadas recursivas, diz-se que usa recursão binária. Estas chamadas podem, por exemplo, ser usadas para resolver duas metades do mesmo problema
- Quando se usa recursão binária, deve-se primeiro tentar particionar completamente o problema em dois ou é preciso está convencido de que sucessivas chamadas recursivas são realmente necessárias

## Recursão múltipla

- Use-se a recursão multipla quando um método pode fazer várias chamadas recursivas em um número potencialmente maior que dois.
- Uma das aplicações mais comuns deste tipo de recursão é quando se deseja enumerar várias configurações visando resolver um quebra-cabeça combinatório
- 