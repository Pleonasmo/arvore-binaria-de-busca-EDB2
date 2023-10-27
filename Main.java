import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import arvore.Arvore;

public class Main {

    public static String lerArquivo(String arq) throws IOException {
        BufferedReader leitor = new BufferedReader(new FileReader(arq));

        String linha = "";

        linha = leitor.readLine();

        leitor.close();
        return linha;
    }

    public static void main(String[] args) throws IOException {
        String arqLeituraArvores = "Arquivos/arquivo1.txt";
        String arqLeituraFuncoes = "Arquivos/arquivo2.txt";

        String linhasArq = lerArquivo(arqLeituraArvores);
        System.out.println(linhasArq);
        Arvore essa;

        ArrayList<Arvore> arvores = new ArrayList<>();

        int contador = 0;
        String[] nos = linhasArq.split(" ");
        System.out.println(Integer.parseInt(nos[contador]));
        essa = new Arvore(Integer.parseInt(nos[contador]));
        for (String no : nos) {
System.out.println("Entrou aqui - for");
            essa = essa.inserirElemento(Integer.parseInt(nos[contador++]), essa.getRaiz(), essa);
        }

        String arv = essa.imprimeArvore("", essa.getRaiz());
        JOptionPane.showMessageDialog(null, arv);

    }

}
