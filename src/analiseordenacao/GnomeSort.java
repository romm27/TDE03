package analiseordenacao;

import static analiseordenacao.GeradorDeVetores.trocar;

public class GnomeSort implements Ordenador {

    @Override
    public Metricas ordenar(int[] vetor, int tamanho) {
        Metricas metricas = new Metricas();
        long tempoInicio = System.nanoTime();

        int indice = 0;
        while (indice < tamanho) {
            metricas.numeroIteracoes++;

            if (indice == 0 || vetor[indice] >= vetor[indice - 1]) {
                indice++;
            } else {
                trocar(vetor, indice, indice - 1);
                metricas.numeroTrocas++;
                indice--;
            }
        }

        metricas.tempoExecucao = System.nanoTime() - tempoInicio;
        return metricas;
    }

    @Override
    public String pegarNome() {
        return "Gnome Sort";
    }
}