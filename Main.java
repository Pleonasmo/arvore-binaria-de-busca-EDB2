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

    public static void main(String[] args) throws IOException {
        String arqLeituraArvores = "Arquivos/arquivo1.txt";
        String arqLeituraFuncoes = "Arquivos/arquivo2.txt";
        ArrayList<Arvore> arvores = new ArrayList<Arvore>();
        ArrayList<String> linhasArqArv = lerArquivo(arqLeituraArvores);
        ArrayList<String> linhasArqFuncoes = lerArquivo(arqLeituraFuncoes);

        for (String arvore : linhasArqArv) {
            String[] nos = arvore.split(" ");
            Arvore nova = new Arvore(Integer.parseInt(nos[0]));
            nova.criarArvore(nos);
            nova.calcularNivel();
            arvores.add(nova);

        }
        JOptionPane.showMessageDialog(null, "Bem vindo, você tem " + arvores.size() + " arvores criadas.", "Welcome",
                1);
        for (String funcao : linhasArqFuncoes) {
            String entradas[] = funcao.split(" ");
            if (entradas[0].equals("CHEIA")) {
                for (Arvore a : arvores) {
                    boolean verificador = a.ehCheia();
                    if (verificador == true) {
                        JOptionPane.showMessageDialog(null,
                                "A árvore é cheia!\n" + a.imprimeArvore(), "Verificar se é cheia", 1);
                    } else {
                        JOptionPane.showMessageDialog(null,
                                "A árvore não é cheia!\n" + a.imprimeArvore(), "Verificar se é cheia",
                                0);

                    }
                }
            }
            if (entradas[0].equals("COMPLETA")) {
                for (Arvore a : arvores) {
                    boolean verificador = a.ehCompleta();
                    if (verificador == true) {
                        JOptionPane.showMessageDialog(null,
                                "A árvore é completa!\n" + a.imprimeArvore(), "Verificar se é completa",
                                1);
                    } else {
                        JOptionPane.showMessageDialog(null,
                                "A árvore não é completa!\n" + a.imprimeArvore(),
                                "Verificar se é completa", 0);

                    }
                }
            }
            if (entradas[0].equals("ENESIMO")) {
                for (Arvore a : arvores) {
                    int enesimoElemento = a.enesimoElemento(Integer.parseInt(entradas[1]));
                    if (enesimoElemento != -1)
                        JOptionPane.showMessageDialog(null,
                                "O enesimo (" + entradas[1] + ") elemento da árvore \n" + a.imprimeArvore() + " é: "
                                        + enesimoElemento,
                                "Enésimo elemento", 1);
                    else
                        JOptionPane.showMessageDialog(null,
                                "Desculpe, não existe esse elemento (" + entradas[1] + ") na árvore \n"
                                        + a.imprimeArvore(),
                                "Enésimo elemento", 0);
                }
            }
            if (entradas[0].equals("INSIRA")) {
                for (Arvore a : arvores) {

                    if (a.inserirElemento(Integer.parseInt(entradas[1])))
                        JOptionPane.showMessageDialog(null,
                                "Elemento " + entradas[1] + " inserido com sucesso!\n" + a.imprimeArvore(),
                                "Inserir elemento",
                                1);
                    else
                        JOptionPane.showMessageDialog(null,
                                "Não foi possivel inserir o elemento, pois ele já existe na árvore", "Inserir elemento",
                                0);
                }
            }
            if (entradas[0].equals("PREORDEM"))
                for (Arvore a : arvores)
                    JOptionPane.showMessageDialog(null,
                            a.imprimeArvore() + "\nPré Ordem: " + a.preOrdem());
            if (entradas[0].equals("IMPRIMA")) {
                for (int i = 1; i < entradas.length - 1; i++) 
                    JOptionPane.showMessageDialog(null,
                            arvores.get(Integer.valueOf(entradas[i]) - 1), "Imprimir", 1);
                
            }
            if (entradas[0].equals("REMOVA")) {
                for (Arvore a : arvores) {
                    a.removerElemento(Integer.parseInt(entradas[1]));

                    JOptionPane.showMessageDialog(null, "Elemento: " + entradas[1] + "\n" + a.imprimeArvore(),
                            "Remover elemento",
                            1);
                }
            }
            if (entradas[0].equals("POSICAO")) {
                for (Arvore a : arvores) {
                    int pElemento = a.posicao(Integer.parseInt(entradas[1]));
                    if (pElemento != -1)
                        JOptionPane.showMessageDialog(null,
                                a.imprimeArvore() + "\nA posição do elemento (" + entradas[1] + ") é de: " + pElemento,
                                "Posição", 1);
                    else
                        JOptionPane.showMessageDialog(null,
                                a.imprimeArvore() + "O elemento " + entradas[1]
                                        + " não existe na árvore.",
                                "Posição", 0);
                }
            }
            if (entradas[0].equals("MEDIANA"))
                for (Arvore a : arvores)
                    JOptionPane.showMessageDialog(null,
                            "Essa função ainda não foi implementada, sentimos muito pelo transtorno :(", "Mediana", 0);
            if (entradas[0].equals("MEDIA")) {
                for (Arvore a : arvores) {
                    double media = a.media(Integer.parseInt(entradas[1]));
                    if (media != -1)
                        JOptionPane.showMessageDialog(null,
                                a.imprimeArvore() + "\n" + "A media a partir do elemento (" + entradas[1] + ") é: "
                                        + media,
                                "Média", 1);
                    else
                        JOptionPane.showMessageDialog(null,
                                a.imprimeArvore() + "\n" + "O elemento " + entradas[1] + " não existe na árvore.",
                                "Média", 0);
                }
            }
            if (entradas[0].equals("BUSCAR"))
                for (Arvore a : arvores) {
                    No no = a.buscarElemento(Integer.parseInt(entradas[1]));
                    if (no == null)
                        JOptionPane.showMessageDialog(null,
                                a.imprimeArvore() + "\n" + "O elemento " + entradas[1] + " não existe na árvore.",
                                "Buscar", 1);
                    else
                        JOptionPane.showMessageDialog(null,
                                a.imprimeArvore() + "\n" + "O elemento " + entradas[1] + " foi encontrado.", "Buscar",
                                0);
                }
        }

    }
}