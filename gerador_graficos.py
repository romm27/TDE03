import pandas as pd
import matplotlib.pyplot as plt
import matplotlib.ticker as mticker

def criar_grafico(df, y_coluna, y_rotulo, titulo, nome_arquivo):
    """
    Cria um gráfico a partir dos dados fornecidos e o salva como uma imagem.
    Usa escala logarítmica e força os marcadores do eixo X.
    """
    print(f"Gerando grafico: {titulo}...")
    
    df_gnome = df[df['Algoritmo'] == 'Gnome Sort']
    df_quick = df[df['Algoritmo'] == 'Quick Sort']
    
    # Pega os valores únicos de tamanho para usar como marcadores no eixo X
    tamanhos_eixo_x = df['Tamanho'].unique()

    plt.style.use('seaborn-v0_8-whitegrid')
    fig, ax = plt.subplots(figsize=(10, 6))

    ax.plot(df_gnome['Tamanho'], df_gnome[y_coluna], marker='o', linestyle='-', label='Gnome Sort')
    ax.plot(df_quick['Tamanho'], df_quick[y_coluna], marker='s', linestyle='-', label='Quick Sort')

    ax.set_yscale('log')
    ax.set_xscale('log')

    # --- ALTERAÇÃO PRINCIPAL AQUI ---
    # Força o eixo X a ter um marcador para cada ponto de dados de tamanho
    ax.set_xticks(tamanhos_eixo_x)

    # Formata os números dos eixos para serem legíveis
    ax.xaxis.set_major_formatter(mticker.FuncFormatter(lambda y, _: '{:,.0f}'.format(y)))
    ax.yaxis.set_major_formatter(mticker.FuncFormatter(lambda y, _: '{:,.0f}'.format(y)))

    # Adiciona os títulos e legendas
    ax.set_title(titulo, fontsize=16)
    ax.set_xlabel('Tamanho do Vetor (N)', fontsize=12)
    ax.set_ylabel(y_rotulo, fontsize=12)
    ax.legend(title='Algoritmo', fontsize=10)
    
    # Rotaciona os marcadores do eixo X se eles ficarem muito apertados
    plt.xticks(rotation=30, ha='right')

    plt.savefig(nome_arquivo, dpi=300, bbox_inches='tight')
    plt.close(fig)

# --- Bloco Principal de Execução ---
if __name__ == "__main__":
    try:
        dados_df = pd.read_csv('resultados.csv', na_values='N/A')

        colunas_metricas = ['TempoMedio(ms)', 'TrocasMedia', 'IteracoesMedia']
        for col in colunas_metricas:
            dados_df[col] = pd.to_numeric(dados_df[col], errors='coerce')

        criar_grafico(dados_df, 
                      'TempoMedio(ms)', 'Tempo Medio (ms)', 
                      'Tempo de Execucao vs. Tamanho do Vetor', 'grafico_tempo.png')

        criar_grafico(dados_df, 
                      'TrocasMedia', 'Numero Medio de Trocas', 
                      'Numero de Trocas vs. Tamanho do Vetor', 'grafico_trocas.png')

        criar_grafico(dados_df, 
                      'IteracoesMedia', 'Numero Medio de Iteracoes', 
                      'Numero de Iteracoes vs. Tamanho do Vetor', 'grafico_iteracoes.png')
                      
        print("\nGraficos gerados com sucesso!")
        print("Verifique os arquivos: grafico_tempo.png, grafico_trocas.png, grafico_iteracoes.png")

    except FileNotFoundError:
        print("ERRO: O arquivo 'resultados.csv' não foi encontrado.")
        print("Por favor, certifique-se de que ele esta na mesma pasta que este script.")
    except Exception as e:
        print(f"Ocorreu um erro inesperado: {e}")