package arvore;

public class Arvore {
    private No raiz;

    public Arvore() {
        this.raiz = null;
    }

    // função raiz de busca de elemento
    public No buscarElemento(int valor) {
        return buscarElemento(this.raiz, valor);
    }

    // função recursiva de busca de elemento
    public No buscarElemento(No no, int valor) {
        if (no == null || no.getValor() == valor)
            return no;
        if (valor < no.getValor())
            return buscarElemento(no.getFilhoEsquerda(), valor);

        return buscarElemento(no.getFilhoDireita(), valor);
    }

    // função raiz de inserção de elemento
    public void inserirElemento(int valor) {
        this.raiz = inserirElemento(valor, this.raiz);
    }

    // função recursiva de inserção de elemento
    public No inserirElemento(int valor, No no) {
        if (no == null) {
            no = new No(valor);
            return no;
        } else if (valor < no.getValor())
            no.setFilhoEsquerda(inserirElemento(valor, no.getFilhoEsquerda()));
        else if (valor > no.getValor())
            no.setFilhoDireita(inserirElemento(valor, no.getFilhoDireita()));

        return no;
    }

    // função raiz de remoção de elemento:
    public void removerElemento(int valor) {
        this.raiz = removerElemento(valor, raiz);
    }

    // função para encontrar nó com menor valor da subárvore onde o parametro "no" é
    // raiz:
    public int menorValor(No no) {
        int menor = no.getValor();
        while (no.getFilhoEsquerda() != null) {
            menor = no.getFilhoEsquerda().getValor();
            no = no.getFilhoEsquerda();
        }

        return menor;
    }

    // função recursiva de remoção de elemento:
    public No removerElemento(int valor, No no) {
        if (no == null)
            return no;
        if (valor < no.getValor())
            no.setFilhoEsquerda(removerElemento(valor, no.getFilhoEsquerda()));
        if (valor > no.getValor())
            no.setFilhoDireita(removerElemento(valor, no.getFilhoDireita()));
        else {
            if (no.getFilhoEsquerda() == null)
                return no.getFilhoDireita();
            else if (no.getFilhoDireita() == null)
                return no.getFilhoEsquerda();

            no.setValor(menorValor(no.getFilhoDireita()));
            no.setFilhoDireita(removerElemento(valor, no.getFilhoDireita()));
        }

        return no;
    }

    int enesimoElemento(int n) {
        return 0;
    }

    int posicao(int x) {
        return 0;
    }

    int mediana() {
        return 0;
    }

    double media(int x) {
        return 0;
    }

    Boolean ehCheia() {
        return null;
    }

    Boolean ehCompleta() {
        return null;
    }

    String preOrdem() {
        return null;
    }

    String organizarTraco(No no) {
        char[] valor = Integer.toString(no.getValor()).toCharArray();
        int contagem = 0, proporcao = 6;
        char[] linha = new char[40];
        for (int i = 0; i < linha.length; i++) {
            linha[i] = '-';
            if (((no.getNivel() - 1) * proporcao) <= i && i < (((no.getNivel() - 1) * proporcao) + valor.length)) {
                linha[i] = valor[contagem];
                contagem++;
            }

            if (i < ((no.getNivel() - 1) * proporcao)) {
                linha[i] = ' ';
            }
        }
        String arv = "";

        for (int i = 0; i < linha.length; i++) {
            arv += linha[i];
        }
        arv += "\n";
        return arv;

    }

    public String imprimeArvore(String a, No no) {
        String arvore = a;

        arvore = organizarTraco(no);
        if (no.getFilhoDireita() != null) {
            arvore += imprimeArvore(arvore, no.getFilhoDireita());
        }
        if (no.getFilhoEsquerda() != null) {
            arvore += imprimeArvore(arvore, no.getFilhoEsquerda());
        }
        return arvore;

    }

    public No getRaiz() {
        return this.raiz;
    }

    public void setRaiz(No raiz) {
        this.raiz = raiz;
    }

}