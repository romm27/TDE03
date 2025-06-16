package analiseordenacao;

public interface Ordenador {
    Metricas ordenar(int[] vetor, int tamanho);
    String pegarNome();
}