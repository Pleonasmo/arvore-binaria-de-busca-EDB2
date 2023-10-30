package arvore;

public class Arvore {
    private No raiz;

    public Arvore() {
        this.raiz = null;
    }

    public No buscarElemento(int valor) {
        return buscarElemento(this.raiz, valor);
    }

    public No buscarElemento(No no, int valor) {
        if (no == null || no.getValor() == valor)
            return no;
        if (valor < no.getValor())
            return buscarElemento(no.getFilhoEsquerda(), valor);

        return buscarElemento(no.getFilhoDireita(), valor);
    }

    public void inserirElemento(int valor) {
        this.raiz = inserirElemento(valor, this.raiz);
    }

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

    void removerElemento(int elemento) {

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