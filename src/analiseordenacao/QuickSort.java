package analiseordenacao;

import static analiseordenacao.GeradorDeVetores.trocar;

public class QuickSort implements Ordenador {

    @Override
    public Metricas ordenar(int[] vetor, int tamanho) {
        Metricas metricas = new Metricas();
        long tempoInicio = System.nanoTime();

        ordenacaoRapidaRecursiva(vetor, 0, tamanho - 1, metricas);

        metricas.tempoExecucao = System.nanoTime() - tempoInicio;
        return metricas;
    }

    @Override
    public String pegarNome() {
        return "Quick Sort";
    }

    private void ordenacaoRapidaRecursiva(int[] vetor, int inicio, int fim, Metricas metricas) {
        if (inicio < fim) {
            int indicePivo = particionar(vetor, inicio, fim, metricas);
            ordenacaoRapidaRecursiva(vetor, inicio, indicePivo - 1, metricas);
            ordenacaoRapidaRecursiva(vetor, indicePivo + 1, fim, metricas);
        }
    }

    private int particionar(int[] vetor, int inicio, int fim, Metricas metricas) {
        int pivo = vetor[fim];
        int i = (inicio - 1);

        for (int j = inicio; j < fim; j++) {
            metricas.numeroIteracoes++;
            if (vetor[j] < pivo) {
                i++;
                trocar(vetor, i, j);
                metricas.numeroTrocas++;
            }
        }
        trocar(vetor, i + 1, fim);
        metricas.numeroTrocas++;
        return i + 1;
    }
}