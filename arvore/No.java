package arvore;

public class No {
    private int valor;
    private No filhoDireita, filhoEsquerda;
    private int nivel, alturaNo;

    No(int valor) {
        this.valor = valor;
    }

    public int getValor() {
        return this.valor;
    }

    public void setValor(int valor) {
        this.valor = valor;
    }

    public No getFilhoDireita() {
        return this.filhoDireita;
    }

    public void setFilhoDireita(No filhoDireita) {
        this.filhoDireita = filhoDireita;
    }

    public No getFilhoEsquerda() {
        return this.filhoEsquerda;
    }

    public void setFilhoEsquerda(No filhoEsquerda) {
        this.filhoEsquerda = filhoEsquerda;
    }

    public int getNivel() {
        return this.nivel;
    }

    public void setNivel(int nivel) {
        this.nivel = nivel;
    }

    public int getAlturaNo() {
        return this.alturaNo;
    }

    public void setAlturaNo(int alturaNo) {
        this.alturaNo = alturaNo;
    }

}
