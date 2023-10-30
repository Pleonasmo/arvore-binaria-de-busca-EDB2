import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

import javax.swing.JOptionPane;

import arvore.Arvore;
import arvore.No;

public class Main {

    public static String lerArquivo(String arq) throws IOException {
        BufferedReader leitor = new BufferedReader(new FileReader(arq));

        String linha = "";

        linha = leitor.readLine();

        leitor.close();
        return linha;
    }

    public static void imprimirEmOrdem(No no) {
        if (no != null) {
            imprimirEmOrdem(no.getFilhoEsquerda());
            System.out.print(no.getValor() + " ");
            imprimirEmOrdem(no.getFilhoDireita());
        }
    }

    public static void main(String[] args) throws IOException {
        // String arqLeituraArvores = "Arquivos/arquivo1.txt";
        // String arqLeituraFuncoes = "Arquivos/arquivo2.txt";

        // String linhasArq = lerArquivo(arqLeituraArvores);
        // System.out.println(linhasArq);
        // Arvore essa;

        // ArrayList<Arvore> arvores = new ArrayList<>();

        // int contador = 0;
        // String[] nos = linhasArq.split(" ");
        // System.out.println(Integer.parseInt(nos[contador]));
        // essa = new Arvore(Integer.parseInt(nos[contador]));
        // for (String no : nos) {
        // System.out.println("Entrou aqui - for");
        // essa = essa.inserirElemento(Integer.parseInt(nos[contador++]),
        // essa.getRaiz(), essa);
        // }

        // String arv = essa.imprimeArvore("", essa.getRaiz());
        // JOptionPane.showMessageDialog(null, arv);

        Arvore a1 = new Arvore();
        Scanner ler = new Scanner(System.in);

        int i = 1;
        while (i > 0) {
            System.out.println("Digite o valor a ser inserido na árvore:");
            i = ler.nextInt();
            a1.inserirElemento(i);
        }

        imprimirEmOrdem(a1.getRaiz());

    }

}
