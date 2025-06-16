package analiseordenacao;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class Main {

    private static final int[] TAMANHOS = {1000, 10000, 100000, 500000, 1000000};
    private static final int QTD_TAMANHOS = 5;

    private static final long[] SEMENTES = {123, 456, 789, 101, 202};
    private static final int NUMERO_DE_RODADAS = 5;

    public static void main(String[] args) {
        Locale.setDefault(Locale.US);

        System.out.println("Iniciando a analise");

        List<Ordenador> algoritmosParaTestar = new ArrayList<>();

        algoritmosParaTestar.add(new QuickSort());
        algoritmosParaTestar.add(new GnomeSort());

        for (int i = 0; i < algoritmosParaTestar.size(); i++) {
            Ordenador algoritmo = algoritmosParaTestar.get(i);
            imprimirCabecalho(algoritmo);
            for (int j = 0; j < QTD_TAMANHOS; j++) {
                int tamanho = TAMANHOS[j];
                executarAnaliseParaTamanho(algoritmo, tamanho);
            }
        }

        System.out.println("\nAnalise finalizada.");
    }

    private static void executarAnaliseParaTamanho(Ordenador algoritmo, int tamanho) {
        long totalTempo = 0;
        long totalTrocas = 0;
        long totalIteracoes = 0;

        for (int i = 0; i < NUMERO_DE_RODADAS; i++) {
            long semente = SEMENTES[i];
            int[] vetorParaOrdenar = GeradorDeVetores.gerarVetorAleatorio(tamanho, semente);
            Metricas resultado = algoritmo.ordenar(vetorParaOrdenar, tamanho);
            totalTempo += resultado.tempoExecucao;
            totalTrocas += resultado.numeroTrocas;
            totalIteracoes += resultado.numeroIteracoes;
        }

        double mediaTempoMs = (double) (totalTempo / NUMERO_DE_RODADAS) / 1_000_000.0;
        long mediaTrocas = totalTrocas / NUMERO_DE_RODADAS;
        long mediaIteracoes = totalIteracoes / NUMERO_DE_RODADAS;

        System.out.printf("\r%-12d %-18.4f %-22d %-22d\n",
                tamanho, mediaTempoMs, mediaTrocas, mediaIteracoes);
    }

    private static void imprimirCabecalho(Ordenador algoritmo) {
        System.out.println("\n--- Analise do Algoritmo: " + algoritmo.pegarNome() + " ---");
        System.out.printf("%-12s %-18s %-22s %-22s\n",
                "Tamanho", "TempoMedio(ms)", "TrocasMedia", "IteracoesMedia");
        System.out.println("-".repeat(78));
    }
}