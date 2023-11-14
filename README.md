# arvore-binaria-de-busca-EDB2
Repositório para versionar o desenvolvimento do projeto da 2ª unidade de Estrutura de Dados Básicas 2.

Frequentemente, uma estrutura de dados suporta quase todas as operações que precisamos. Quando
não é caso, podemos aumentar a estrutura pela adição de informações e/ou operações. Neste
projeto, vocês devem implementar uma árvore binária de busca (ABB) aumentada que guarde
valores int e que suporte, além das operações convencionais de busca, inserção e remoção, as
operações elencadas a seguir:
1. int enesimoElemento (int n): retorna o n-ésimo elemento (contando a partir de 1) do percurso
em ordem (ordem simétrica) da ABB.
2. int posicao (int x): retorna a posição ocupada pelo elemento x em um percurso em ordem
simétrica na ABB (contando a partir de 1).
3. int mediana (): retorna o elemento que contém a mediana da ABB. Se a ABB possuir um
número par de elementos, retorne o menor dentre os dois elementos medianos.
4. double média (int x): retorna a média aritmética dos nós da árvore que x é a raiz.
5. boolean ehCheia (): retorna verdadeiro se a ABB for uma árvore binária cheia e falso, caso
contrário.
6. boolean ehCompleta (): retorna verdadeiro se a ABB for uma árvore binária completa.
7. String pre_ordem (): retorna uma String que contém a sequência de visitação (percorrimento)
da ABB em pré-ordem.
8. void imprimeArvore (int s): se “s” igual a 1, o método imprime a árvore no formato 1, “s”
igual a 2, imprime no formato 2.

Algumas operações descritas poderia ser facilmente implementada utilizando um percurso em
ordem simétrica e, talvez, armazenando resultados em um vetor. Entretanto, esse procedimento é
ineficiente. Ao invés disso, vamos melhorar o desempenho dessas operações aumentando
os nós da ABB, isto é, armazenando informações extras em cada nó da árvore que simplificarão as
operações. Uma informação pode ser a quantidade de nós nas subárvores à direita e à
esquerda. Outras informações necessárias, se for o caso, devem ser identificadas por
vocês. Seu algoritmo deve receber dois arquivos como parâmetros. O primeiro, contém uma
descrição da ABB que será utilizada e é denominado arquivo de entrada da ABB. O arquivo de
entrada da ABB contém uma sequência de valores inteiros separados por um espaço, os valores a
serem armazenados na árvore. O segundo arquivo, denominado arquivo de comandos, contém uma
sequência de operações (uma operação por linha) a serem realizadas pelo seu algoritmo.

# INSTRUÇÕES PARA EXECUÇÃO:
Os arquivos do tipo .txt com as árvores e as operações devem estar na pasta "Arquivos" do
projeto, que guarda os arquivos de texto que serão lidos pelo programa.

O arquivo com as árvores deve esta nomeado como "arquivo1.txt".
O arquivo com as funções deve esta nomeado como "arquivo2.txt".
# Atenção: 
O programa aceita mais de uma árvore, porém, ela devem estar separadas.
Exemplo: 
        30 40 50 60 83 73
        87 98 09 92 03 94

Árvore 1: 30 40 50 60 83 73
Árvore 2: 87 98 09 92 03 94

# Antes da execução é necessário verificar se possui o JRE na maquina


$ java -jar nomedoarquivo.jar