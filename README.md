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
