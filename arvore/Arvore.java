package arvore;

import javax.swing.tree.TreeNode;

public class Arvore {
    private No raiz;

    public Arvore() {
        this.raiz = null;
    }

    public Arvore(int raiz) {
        this.raiz = new No(raiz);
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
    public boolean inserirElemento(int valor) {
        return inserirElemento(this.raiz, valor);

    }

    // função recursiva de inserção de elemento
    boolean inserirElemento(No no, int valor) {
        Boolean t = false;
        if (no == null) {
            t = true; // Inserção bem-sucedida
        } else {
            // Realizamos a inserção recursiva
            if (valor < no.getValor()) {
                // Inserir na subárvore esquerda
                t = inserirElemento(no.getFilhoEsquerda(), valor);
                if (t) {
                    if (no.getFilhoEsquerda() == null) {
                        no.setFilhoEsquerda(new No(valor));
                        return true; // Inserção bem-sucedida
                    }
                }
            } else if (valor > no.getValor()) {
                // Inserir na subárvore direita
                t = inserirElemento(no.getFilhoDireita(), valor);
                if (t) {
                    if (no.getFilhoDireita() == null) {
                        no.setFilhoDireita(new No(valor));
                        return true; // Inserção bem-sucedida
                    }
                }
            }
        }
        atualizar();
        return t; // Valor já existe na árvore
    }

    public void atualizar() {
        calcularNivel();
        calcularQuantNos(this.raiz);
        calcularQtdFilhos(this.raiz);
    }

    // função raiz de remoção de elemento:
    public void removerElemento(int valor) {
        this.raiz = removerElemento(valor, raiz);
        atualizar();
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

    public int enesimoElemento(int n) {
        return enesimoElemento(this.raiz, n);
    }

    public int enesimoElemento(No no, int n) {
        if (no == null)
            return -1;
        if (no.getQtdFilhosEsquerda() >= n) {
            return enesimoElemento(no.getFilhoEsquerda(), n);
        } else {
            if (n == 1)
                return no.getValor();
            if (no.getQtdFilhosEsquerda() == n - 1)
                return no.getValor();
            return enesimoElemento(no.getFilhoDireita(), n - no.getQtdFilhosEsquerda() - 1);
        }
    }

    public double mediana() {
        if (this.raiz.getQtdFihosDireita() + this.raiz.getQtdFilhosEsquerda() % 2 == 0) {

        }
        return 0;
    }

    public int posicao(int x) {
        return posicao(x, this.raiz);
    }

    // Ainda p testar
    public int posicao(int x, No no) {
        if (no == null)
            return -1;
        if (x == no.getValor())
            return 1;

        int pos = posicao(x, no.getFilhoEsquerda());
        if (pos != -1)
            return pos;
        else
            return posicao(x, no.getFilhoDireita()) + 1 + calcularQuantNos(raiz.getFilhoEsquerda());
    }

    double soma(No no) {
        if (no == null)
            return 0;
        double valor = (no.getValor() + soma(no.getFilhoEsquerda()) + soma(no.getFilhoDireita()));
        return valor;
    }

    public double media(int x) {
        No no = buscarElemento(x);
        if(no != null)
     {   int quantNos = (no.getQtdFilhosEsquerda() + no.getQtdFihosDireita() + 1);
        if (quantNos != 0)
            return soma(no) / quantNos;

        return 0;
    }else{
        return -1;
    }
    }

    public boolean ehCheia() {
        return ehCheia(this.raiz);
    }

    public boolean ehCheia(No no) {
        if (no == null)
            return true;
        if ((no.getFilhoEsquerda() != null && no.getFilhoDireita() != null) ||
                (no.getFilhoEsquerda() == null && no.getFilhoDireita() == null))
            return ehCheia(no.getFilhoEsquerda()) && ehCheia(no.getFilhoDireita());
        return false;
    }

    public boolean ehCompleta() {
        int quantNos = calcularQuantNos(this.raiz);
        return ehCompleta(this.raiz, quantNos, 0);
    }

    public boolean ehCompleta(No no, int quantNos, int indice) {
        if (no == null)
            return true;
        if (no != null && indice > quantNos)
            return false;

        return ehCompleta(no.getFilhoEsquerda(), quantNos, 1 + indice * 2)
                && ehCompleta(no.getFilhoDireita(), quantNos, 2 + indice * 2);
    }

    public String preOrdem() {
        return preOrdem("", this.raiz);
    }

    public String preOrdem(String a, No no) {
        String arvore = a + " " + no.getValor();
        if (no.getFilhoEsquerda() != null)
            arvore = preOrdem(arvore, no.getFilhoEsquerda());
        if (no.getFilhoDireita() != null)
            arvore = preOrdem(arvore, no.getFilhoDireita());
        return arvore;
    }

    String organizarTraco(No no) {
        char[] valor = Integer.toString(no.getValor()).toCharArray(), linha = new char[40];
        int contagem = 0, proporcao = 6;
        for (int i = 0; i < linha.length; i++) {
            linha[i] = '-';
            if (((no.getNivel() - 1) * proporcao) <= i && i < (((no.getNivel() - 1) * proporcao) + valor.length)) {
                linha[i] = valor[contagem];
                contagem++;
            }
            if (i < ((no.getNivel() - 1) * proporcao))
                linha[i] = ' ';

        }
        String arv = "";
        for (int i = 0; i < linha.length; i++)
            arv += linha[i];
        arv += "\n";
        return arv;

    }

    public String imprimeArvore() {
        return imprimeArvore("", this.raiz);
    }

    public String imprimeArvore(String a, No no) {
        String arvore = organizarTraco(no);

        if (no.getFilhoDireita() != null)
            arvore += imprimeArvore(arvore, no.getFilhoDireita());
        if (no.getFilhoEsquerda() != null)
            arvore += imprimeArvore(arvore, no.getFilhoEsquerda());
        return arvore;
    }

    public void criarArvore(String[] nos) {
        for (int i = 1; i < nos.length; i++)
            inserirElemento(Integer.parseInt(nos[i]));
    }

    public void calcularNivel() {
        calcularNivel(this.raiz, 1);
    }

    public void calcularNivel(No no, int nivel) {
        no.setNivel(nivel);
        if (no.getFilhoEsquerda() != null)
            calcularNivel(no.getFilhoEsquerda(), nivel + 1);
        if (no.getFilhoDireita() != null)
            calcularNivel(no.getFilhoDireita(), nivel + 1);
    }

    public void calcularQtdFilhos(No no) {
        if (no == null)
            return;
        calcularQtdFilhos(no.getFilhoEsquerda());
        no.setQtdFilhosEsquerda(no.getFilhoEsquerda() != null
                ? (no.getFilhoEsquerda().getQtdFihosDireita() + no.getFilhoEsquerda().getQtdFilhosEsquerda() + 1)
                : 0);
        calcularQtdFilhos(no.getFilhoDireita());
        no.setQtdFihosDireita(no.getFilhoDireita() != null
                ? (no.getFilhoDireita().getQtdFihosDireita() + no.getFilhoDireita().getQtdFilhosEsquerda() + 1)
                : 0);
    }

    public int calcularQuantNos(No no) {
        if (no == null)
            return 0;
        return 1 + calcularQuantNos(no.getFilhoEsquerda()) + calcularQuantNos(no.getFilhoDireita());
    }

}