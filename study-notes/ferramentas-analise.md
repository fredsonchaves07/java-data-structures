# Ferramentas de an�lise

- As sete fun��es mais importantes usadas em an�lise de algoritmos

## As fun��es mais utilizadas em an�lise de algoritmos

### A fun��o constante

- A fun��o mais simples que se possa imaginar `f(n) = c`
- Para qualquer argumento `n`, a fun��o constante atribui um valor `c`. Em outras palavras, n�o importa o valor de `n` a fun��o sempre atribuir� `c`
- A fun��o constante � �til na an�lise de algoritmos porque caracteriza o n�mero de passos necess�rios para executar uma opera��o b�sica em um computador, como adicionar dois valores, atribuir um valor para alguma vari�vel ou comparar dois valores

### A fun��o logaritmo

- Definido pela fun��o `f(n) = logbn` para alguma constante `b > 1`
- Uma vez que computadores armazenam inteiros em bin�rio, a base mais comum para a fun��o logaritmo em Ci�ncia da Computa��o � 2. De fato, essa base � t�o comum que tipicamente n�o � indicada se for 2. Ent�o, ser� considerado `log n = log2n`

### A fun��o linear

- Outra fun��o simples, mas importante, � a fun��o linear `f(n) = n`
- Esta fun��o aparece na an�lise de algoritmos sempre que se tem de executar uma opera��o b�sica sobre cada um de `n` elementos
- A fun��o linear tamb�m representa o melhor tempo de execu��o que se pode desejar obter para qualquer algoritmo que processa uma cole��o de `n` objetos que est�o na mem�ria do computador

### A fun��o n-log-n

- Definido por `f(n) = nlogn`
- A fun��o que atribui para uma entrada `n` o valor de `n` multiplicado pelo logaritmo de base 2 de `n`
- Esta fun��o cresce um pouco mais r�pido que a fun��o linear e muito mais devagar que a fun��o quadr�tica

### A fun��o quadr�tica

- Definido por `f(n) = n2`
- A principal raz�o de a fun��o quadr�tica aparecer na an�lise de algoritmos � que existem v�rios algoritmos que possuem la�os aninhados, em que o la�o mais interno executa uma quantidade linear de opera��es e o la�o mais externo � executado um n�mero linear de vezes.

### A fun��o c�bica e ouras polinomiais

- Definido por `f(n) = n3`
- Esta fun��o aparece com menos frequ�ncia no contexto da an�lise de algoritmos do que as fun��es constante, linear ou quadr�tica

### A fun��o exponencial

- Definido por `f(n) = bn`
- Na an�lise de algorimos, a base mais comum para fun��o exponencial � `b = 2`. 
- Por exemplo, se existe um la�o que come�a executando uma opera��o e dobra o n�mero de opera��es executadas a cada itera��o, ent�o o n�mero de opera��es executadas pela n-esima itera��o � `2n`

### Comparando as fun��es

- Seria desej�vel que os algortmos executassem em tempo linear ou n-log-n. Algortimos com tempos de execu��o quadr�ticos ou c�bicos s�o poucos pr�ticos, mas algoritmos comtempos de execu��o exponenciais s�o impratic�veis a n�o ser para pequenas entradas