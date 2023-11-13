import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

import javax.swing.JOptionPane;

import arvore.*;

public class Main {

    public static ArrayList lerArquivo(String arq) throws IOException {
        BufferedReader leitor = new BufferedReader(new FileReader(arq));
        ArrayList<String> arvores = new ArrayList<String>();
        String linha = "";
        while (linha != null) {
            linha = leitor.readLine();
            if (linha != null)
                arvores.add(linha);
        }

        leitor.close();
        return arvores;
    }

    public static void imprimirEmOrdem(No no) {
        if (no != null) {
            imprimirEmOrdem(no.getFilhoEsquerda());
            System.out.print(no.getValor() + " ");
            imprimirEmOrdem(no.getFilhoDireita());
        }
    }

    public static void main(String[] args) throws IOException {
        String arqLeituraArvores = "Arquivos/arquivo1.txt";
        String arqLeituraFuncoes = "Arquivos/arquivo2.txt";
        ArrayList<Arvore> arvores = new ArrayList<Arvore>();
        ArrayList<String> linhasArqArv = lerArquivo(arqLeituraArvores);
        ArrayList<String> linhasArqFuncoes = lerArquivo(arqLeituraFuncoes);
        System.out.println(linhasArqArv);
        System.out.println(linhasArqFuncoes);

        for (String arvore : linhasArqArv) {
            System.out.println(arvore);
            String[] nos = arvore.split(" ");
            Arvore nova = new Arvore(Integer.parseInt(nos[0]));
            nova.criarArvore(nos);
            nova.calcularNivel();
            arvores.add(nova);

        }
        JOptionPane.showMessageDialog(null, "Bem vindo, você tem " + arvores.size() + " arvores criadas.");
        for (String funcao : linhasArqFuncoes) {
            String entradas[] = funcao.split(" ");
            System.out.println(entradas[0]);
            if (entradas[0].equals("CHEIA")) {
                for (Arvore a : arvores) {
                    boolean verificador = a.ehCheia();
                    if (verificador == true) {
                        JOptionPane.showMessageDialog(null,
                                "A árvore " + a.imprimeArvore("", a.getRaiz()) + " é cheia!");
                    }
                }
            }
            if (entradas[0].equals("COMPLETA")) {
                for (Arvore a : arvores) {
                    boolean verificador = a.ehCompleta();
                    if (verificador == true) {
                        JOptionPane.showMessageDialog(null,
                                "A árvore " + a.imprimeArvore("", a.getRaiz()) + " é completa!");
                    }
                }
            }
            if (entradas[0].equals("ENESIMO")) {
                for (Arvore a : arvores) {
                    int enesimoElemento = a.enesimoElemento(Integer.parseInt(entradas[1]));
                    System.out.println(enesimoElemento);
                    JOptionPane.showMessageDialog(null,
                            "O enesimo elemento da árvore \n" + a.imprimeArvore() + " é: "
                                    + enesimoElemento);
                }
            }
            if (entradas[0].equals("INSIRA")) {
                for (Arvore a : arvores) {
                    a.inserirElemento(Integer.parseInt(entradas[1]));
                    JOptionPane.showMessageDialog(null,
                            a.imprimeArvore());
                }
            }
            if (entradas[0].equals("PREORDEM"))
                for (Arvore a : arvores)
                    JOptionPane.showMessageDialog(null,
                            a.imprimeArvore() + "\n" + a.preOrdem());
            if (entradas[0].equals("IMPRIMA")) {
                for (int i = 1; i < entradas.length - 1; i++) {
                    System.out.println(i + " " + (Integer.parseInt(entradas[i]) - 1));
                    JOptionPane.showMessageDialog(null,
                            arvores.get(Integer.valueOf(entradas[i]) - 1));
                }
            }
            if (entradas[0].equals("REMOVA")) {
            }
            if (entradas[0].equals("POSICAO")) {
                for (Arvore a : arvores) {
                    int pElemento = a.posicao(Integer.parseInt(entradas[1]));
                    if (pElemento != -1)
                        JOptionPane.showMessageDialog(null,
                                a.imprimeArvore() + "\nA posição do elemento é de: " + pElemento);
                    else
                        JOptionPane.showMessageDialog(null,
                                a.imprimeArvore() + "O elemento " + entradas[1]
                                        + " não existe na árvore.");
                }
            }
            if (entradas[0].equals("MEDIANA"))
                for (Arvore a : arvores)
                    JOptionPane.showMessageDialog(null,
                            a.imprimeArvore() + "\n" + "A mediana da árvore é: " + a.mediana());
            if (entradas[0].equals("MEDIA")) {
                for (Arvore a : arvores)
                    JOptionPane.showMessageDialog(null,
                            a.imprimeArvore() + "\n" + "A media da árvore é: "
                                    + a.media(Integer.parseInt(entradas[1])));

            }
            if (entradas[0].equals("BUSCAR"))
                for (Arvore a : arvores) {
                    No no = a.buscarElemento(Integer.parseInt(entradas[1]));
                    System.out.println(no.getValor());
                    if (no == null)
                        JOptionPane.showMessageDialog(null,
                                a.imprimeArvore() + "\n" + "O elemento " + entradas[1] + " não existe na árvore.");
                    else
                        JOptionPane.showMessageDialog(null,
                                a.imprimeArvore() + "\n" + "O elemento " + entradas[1] + " foi encontrado.");
                }
        }

        Arvore a1 = new Arvore();
        Scanner ler = new Scanner(System.in);

        int i = 1;
        while (i > 0) {
            System.out.println("Digite o valor a ser inserido na árvore:");
            i = ler.nextInt();
            a1.inserirElemento(i);
        }

        imprimirEmOrdem(a1.getRaiz());

        System.out.println("\n\nDigite o elemento que deseja buscar:");
        i = ler.nextInt();
        if (a1.buscarElemento(i) == null)
            System.out.println(i + " não está na árvore!");
        else
            System.out.println(i + " está na árvore!");

        System.out.println("\nDigite o elemento que deseja remover:");
        i = ler.nextInt();
        a1.removerElemento(i);
        imprimirEmOrdem(a1.getRaiz());
        System.out.println("\n");

        ler.close();
        a1.imprimeArvore("", null);
    }

}
