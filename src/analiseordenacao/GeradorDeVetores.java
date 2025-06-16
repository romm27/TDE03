package analiseordenacao;

import java.util.Random;

public class GeradorDeVetores {

    public static int[] gerarVetorAleatorio(int tamanho, long semente) {
        int[] vetor = new int[tamanho];
        Random random = new Random(semente);
        for (int i = 0; i < tamanho; i++) {
            vetor[i] = random.nextInt(tamanho * 10);
        }
        return vetor;
    }

    public static int[] copiarVetor(int[] origem, int tamanho) {
        int[] destino = new int[tamanho];
        for (int i = 0; i < tamanho; i++) {
            destino[i] = origem[i];
        }
        return destino;
    }

    public static void trocar(int[] vetor, int i, int j) {
        int temp = vetor[i];
        vetor[i] = vetor[j];
        vetor[j] = temp;
    }
}