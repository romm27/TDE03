# Análise de Desempenho de Algoritmos de Ordenação

## 1. Visão Geral do Projeto

Este projeto consiste na implementação e análise de desempenho de dois algoritmos de ordenação: **Gnome Sort** e **Quick Sort**. O objetivo é comparar empiricamente a eficiência de diferentes algoritmos.

A análise foi realizada em Java, seguindo as restrições do professor, como a proibição de uso de funções prontas do java como .length.

As métricas avaliadas foram:
*   **Tempo de execução (em milissegundos)**
*   **Número médio de trocas**
*   **Número médio de iterações/comparações**

Os testes foram executados em vetores de inteiros gerados aleatoriamente, com tamanhos de 1.000, 10.000, 100.000, 500.000 e 1.000.000. Cada cenário foi executado 5 vezes com sementes diferentes para garantir a robustez dos resultados.

## 2. Algoritmos Estudados

### Gnome Sort
Um algoritmo de ordenação simples, similar ao Insertion Sort. Ele funciona movendo um elemento para sua posição correta através de uma série de trocas consecutivas, movendo-se para frente quando a ordem está correta e para trás para corrigir quando encontra uma inversão. Sua simplicidade resulta em uma complexidade de tempo de **O(n²)**.

### Quick Sort
Um algoritmo de ordenação altamente eficiente que utiliza a estratégia "dividir para conquistar". Ele seleciona um elemento como pivô e particiona o vetor de forma que todos os elementos menores que o pivô fiquem à sua esquerda e os maiores à sua direita. O processo é então aplicado recursivamente às sub-listas. Sua complexidade média de tempo é de **O(n log n)**.

## 3. Tecnologias Utilizadas

*   **Java (JDK 24):** Para a implementação dos algoritmos e coleta de dados.
*   **Python 3:** Para a geração dos gráficos a partir dos dados coletados.
*   **Pandas & Matplotlib:** Bibliotecas Python utilizadas para ler os dados do arquivo CSV e criar as visualizações.

## 4. Como Reproduzir os Resultados

### Geração dos Dados (Java)
O código-fonte Java para a análise está disponível neste repositório. Para reproduzir os dados:
1.  Compile todas as classes do pacote `analiseordenacao`.
2.  Execute a classe `Main`.
    ```bash
    # Exemplo de compilação e execução via terminal
    javac analiseordenacao/*.java
    java analiseordenacao.Main
    ```
**Aviso:** A execução completa dos testes pode levar um tempo considerável, especialmente devido ao desempenho do Gnome Sort. Em um Macbook Pro M4 a execução final do Gnome Sort levou em torno de 30 minutos!

### Geração dos Gráficos (Python)
Os gráficos apresentados neste relatório foram gerados a partir do arquivo `resultados.csv` utilizando o script `gerador_graficos.py`, que também se encontra neste repositório. O script utiliza as bibliotecas Python `pandas` e `matplotlib`.

## 5. Resultados

Os dados coletados da execução completa dos testes estão consolidados na tabela abaixo.

| Algoritmo | Tamanho | Tempo Médio (ms) | Média de Trocas | Média de Iterações |
| :--- | ---:| ---:| ---:| ---:|
| Quick Sort | 1,000 | 0.1082 | 5,597 | 10,766 |
| Quick Sort | 10,000 | 0.4530 | 81,096 | 154,598 |
| Quick Sort | 100,000 | 4.8330 | 1,110,002 | 2,032,390 |
| Quick Sort | 500,000 | 30.7010 | 6,322,648 | 11,822,982 |
| Quick Sort | 1,000,000 | 54.2814 | 12,974,989 | 25,087,492 |
| Gnome Sort | 1,000 | 1.2818 | 250,403 | 501,806 |
| Gnome Sort | 10,000 | 41.2910 | 24,971,520 | 49,953,040 |
| Gnome Sort | 100,000 | 4,221.1875 | 2,502,133,237 | 5,004,366,474 |
| Gnome Sort | 500,000 | 101,077.9680 | 62,482,893,519 | 124,966,287,038 |
| Gnome Sort | 1,000,000 | 410,790.9448 | 250,007,971,294 | 500,016,942,588 |

### Gráficos Gerados

Os gráficos abaixo utilizam uma **escala logarítmica** em ambos os eixos (log-log) para permitir a visualização da enorme diferença de desempenho entre os algoritmos.

**Gráfico 1: Tempo de Execução vs. Tamanho do Vetor**
![Image](https://github.com/user-attachments/assets/e5168ec4-3bf3-4c8f-af90-d6068681ec41)

**Gráfico 2: Número de Trocas vs. Tamanho do Vetor**
![Image](https://github.com/user-attachments/assets/908c26a2-f703-4512-ad08-cbbbe0dc90d5)

**Gráfico 3: Número de Iterações vs. Tamanho do Vetor**
![Image](https://github.com/user-attachments/assets/e009fb77-9679-4136-8b61-8cd290a662ad)

## 6. Análise e Conclusão

Os resultados experimentais confirmam a teoria da complexidade desses algoritmos.

*   O **Quick Sort** demonstrou uma escalabilidade excelente, com um crescimento de desempenho próximo ao linear (linearítmico, O(n log n)), como pode ser observado pela linha quase reta no gráfico log-log. Ele foi capaz de ordenar um milhão de elementos em aproximadamente **54 milissegundos**.
*   O **Gnome Sort**, por outro lado, apresentou um crescimento explosivo e quadrático (O(n²)). O tempo para ordenar um milhão de elementos foi de **410.790 milissegundos**, o que equivale a **6 minutos e 50 segundos**. Este contraste de desempenho — milissegundos contra minutos para a mesma tarefa — ilustra perfeitamente a importância da escolha de um algoritmo eficiente.

Conclui-se que, enquanto algoritmos simples como o Gnome Sort são úteis para fins didáticos, algoritmos eficientes como o Quick Sort são essenciais para o desenvolvimento de sistemas performáticos e escaláveis no mundo real.


## 7. Autor

*   **Giovanni Galarda Strasser**


## 8. Vídeo de Apresentação

*   **Link para o Vídeo:** [https://youtu.be/U99JO5vLces](https://youtu.be/U99JO5vLces)

