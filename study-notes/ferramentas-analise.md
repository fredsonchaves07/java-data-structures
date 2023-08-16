# Ferramentas de análise

- As sete funções mais importantes usadas em análise de algoritmos

## As funções mais utilizadas em análise de algoritmos

### A função constante

- A função mais simples que se possa imaginar `f(n) = c`
- Para qualquer argumento `n`, a função constante atribui um valor `c`. Em outras palavras, não importa o valor de `n` a função sempre atribuirá `c`
- A função constante é útil na análise de algoritmos porque caracteriza o número de passos necessários para executar uma operação básica em um computador, como adicionar dois valores, atribuir um valor para alguma variável ou comparar dois valores

### A função logaritmo

- Definido pela função `f(n) = logbn` para alguma constante `b > 1`
- Uma vez que computadores armazenam inteiros em binário, a base mais comum para a função logaritmo em Ciência da Computação é 2. De fato, essa base é tão comum que tipicamente não é indicada se for 2. Então, será considerado `log n = log2n`

### A função linear

- Outra função simples, mas importante, é a função linear `f(n) = n`
- Esta função aparece na análise de algoritmos sempre que se tem de executar uma operação básica sobre cada um de `n` elementos
- A função linear também representa o melhor tempo de execução que se pode desejar obter para qualquer algoritmo que processa uma coleção de `n` objetos que estão na memória do computador

### A função n-log-n

- Definido por `f(n) = nlogn`
- A função que atribui para uma entrada `n` o valor de `n` multiplicado pelo logaritmo de base 2 de `n`
- Esta função cresce um pouco mais rápido que a função linear e muito mais devagar que a função quadrática

### A função quadrática

- Definido por `f(n) = n2`
- A principal razão de a função quadrática aparecer na análise de algoritmos é que existem vários algoritmos que possuem laços aninhados, em que o laço mais interno executa uma quantidade linear de operações e o laço mais externo é executado um número linear de vezes.

### A função cúbica e ouras polinomiais

- Definido por `f(n) = n3`
- Esta função aparece com menos frequência no contexto da análise de algoritmos do que as funções constante, linear ou quadrática

### A função exponencial

- Definido por `f(n) = bn`
- Na análise de algorimos, a base mais comum para função exponencial é `b = 2`. 
- Por exemplo, se existe um laço que começa executando uma operação e dobra o número de operações executadas a cada iteração, então o número de operações executadas pela n-esima iteração é `2n`

### Comparando as funções

- Seria desejável que os algortmos executassem em tempo linear ou n-log-n. Algortimos com tempos de execução quadráticos ou cúbicos são poucos práticos, mas algoritmos comtempos de execução exponenciais são impraticáveis a não ser para pequenas entradas

  ![BigOGraph](https://github.com/fredsonchaves07/java-datastructures/assets/43495376/06453efd-79d7-40d9-90aa-594523bf5307)

## Análise de algoritmos

- A principal ferramenta de análise envolve a caracterização dos tempos de execução dos algoritmos e das operações sobre as estruturas de dados, sendo que o espaço utilizado também é importante. Tempo de execução é uma medida natural de qualidade, uma vez que o tempo é um recurso precioso

### Estudos experimentais

- Se um algotitmo foi implementado, pode-se estudar seu tempo de execução executando-o sobre diferentes conjuntos de entradas e armazenando o tempo real gasto em cada execução.
- Para determianar esta dependencia, devem ser executados vários experimentos sobre diferentes conjuntos de entrada, com diferentes tamanhos.
- Então é possível visualizar os resultados destes experimentos plotando a performance de cada execução do algoritmo como um ponto com coordenada x igual ao tamanho da entra n
- Apesar dos estudos experimentais sobre os tempos de execução serem úteis, eles tem três grandes limitações:
  - Experimentos só podem ser feitos sobre um conjunto limitado de entradas de teste; consequentemente, são deixados de fora os tempos de execução das entradas não incluídas nos experimentos (e essas entradas podem ser importantes)
  - É difcil comparar os tempos de execução de dois algoritmos, a mesnos que os experimentos sejam executados nos mesmos ambientes de hardware e software
  - É necessário implementar e executar o algoritmo de maneira a estudar seu tempo de execução experimentalmente

### Operações primitivas

- A análise experimental é importante, porém tem suas limitações. Pode-se fazer uma análise diretamente sobre o pseudocódigo de alto nível.
- Define se um conjunto de operações primitivas como as que seguem:
  - Atribuição de valores a variáveis;
  - Chamadas de métodos;
  - Operações aritméticas (por exemplo, adição de dois números);
  - Comparação de dois números;
  - Acesso a um arranjo;
  - Seguimento de uma referência para um objeto;
  - Retorno de um método;

### Notação assintótica

- Em geral, cada passo em uma descrição em pseudocódigo ou implementação em linguagem de alto nível corresponde a um pequeno número de operações primitivas (exceto para chamadas de métodos, naturalmente)
- Na análise de algoritmos é importante cncentra-se na taxa de crescimento do tempo de execução como uma função do tamanho da entrada `n`, obtendo-se um quadro geral do comportamento
- É definido pela anotação O
- As sete funções listadas são as mais comumente usadas em cojunto com a notação O