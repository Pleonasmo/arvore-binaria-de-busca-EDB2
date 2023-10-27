package arvore;

public class Arvore {
    private No raiz;

    public Arvore(int valor) {
        this.raiz = new No(valor);
        raiz.setNivel(1);
    }

    public int buscarElemento(No no, int elemento) {
        if (no.getValor() == elemento) {
            return 1;
        } else if (no.getFilhoDireita() != null) {

            buscarElemento(no.getFilhoDireita(), elemento);

        } else if (no.getFilhoEsquerda() != null) {

            buscarElemento(no.getFilhoEsquerda(), elemento);

        }
        return 0;
    }

    public Arvore inserirElemento(int elemento, No no, Arvore arvore) {
        System.out.println(no.getValor());
        System.out.println("Elemnteo: " + elemento);
        if (elemento < no.getValor()) {
            System.out.println("Entrou no if esq");
            if (no.getFilhoEsquerda() != null) {
                System.out.println("Entrou no segund if esq");
               return inserirElemento(elemento, no.getFilhoEsquerda(), arvore);
            } else {
                 System.out.println("Entrou no else");
                no.setFilhoEsquerda(new No(elemento));
            }
        }
        if (elemento > no.getValor()) {
            System.out.println("Entrou no if dir");
            if (no.getFilhoDireita() != null) {
                System.out.println("Entrou no segund if dir");
                return inserirElemento(elemento, no.getFilhoDireita(), arvore);
            } else {
                System.out.println("Entrou no else");
                no.setFilhoDireita(new No(elemento));
            }
        }
        System.out.println("Passou dos dois ifs.");
        return arvore;

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