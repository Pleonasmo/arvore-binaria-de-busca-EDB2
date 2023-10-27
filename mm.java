import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import arvore.Arvore;

class mm {

	public static String lerArquivo(String arq) throws IOException {
		BufferedReader leitor = new BufferedReader(new FileReader(arq));


		String linha = "";
	
			linha = leitor.readLine();
		
		leitor.close();
		return linha;
	}

	public static void main(String[] args) throws IOException {

		// Arvore a = new Arvore(50);
		// a.getRaiz().setFilhoDireita(new No(60));
		// a.getRaiz().setAlturaNo(3);
		// a.getRaiz().getFilhoDireita().setNivel(2);
		// a.getRaiz().getFilhoDireita().setAlturaNo(2);
		// a.getRaiz().setFilhoEsquerda(new No(40));
		// a.getRaiz().getFilhoEsquerda().setNivel(2);
		// a.getRaiz().getFilhoEsquerda().setAlturaNo(2);
		// a.getRaiz().getFilhoEsquerda().setFilhoEsquerda(new No(35));
		// a.getRaiz().getFilhoEsquerda().getFilhoEsquerda().setNivel(3);
		// a.getRaiz().getFilhoEsquerda().getFilhoEsquerda().setAlturaNo(1);
		// a.getRaiz().getFilhoEsquerda().setFilhoDireita(new No(42));
		// a.getRaiz().getFilhoEsquerda().getFilhoDireita().setAlturaNo(1);
		// a.getRaiz().getFilhoEsquerda().getFilhoDireita().setNivel(3);
		// a.getRaiz().getFilhoDireita().setFilhoEsquerda(new No(70));
		// a.getRaiz().getFilhoDireita().getFilhoEsquerda().setNivel(3);
		// a.getRaiz().getFilhoDireita().getFilhoEsquerda().setAlturaNo(1);

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
			
			essa.inserirElemento(Integer.parseInt(nos[contador++]), essa.getRaiz());
		}

		String resposta;
		String opcoes[] = { "Criar nova arvore", "Listar arvores disponiveis" };
		while (true) {
			resposta = JOptionPane.showInputDialog("Bem vindo ao simulador de árvore!\nVocê tem " + arvores.size()
					+ " arvores criadas." + "\nDeseja criar uma nova árvore ou listar árvores existentes?\n\n"
					+ "1 - Criar nova arvore\n2 - Listar arvores disponiveis");
			if (resposta == null) {

				int r = JOptionPane.showConfirmDialog(null, "Deseja encerrar o programa?", "Encerrar", 0);
				if (r == JOptionPane.YES_OPTION) {
					break;
				}
			}

			if (Integer.parseInt(resposta) == 1) {
				int valor = Integer.parseInt(JOptionPane.showInputDialog("Informe a raiz da arvore: "));
				Arvore arvore = new Arvore(valor);
				while (true) {
					valor = Integer
							.parseInt(JOptionPane.showInputDialog("Deseja inserir mais um valor na árvore? ", 0));
					if (valor == JOptionPane.YES_OPTION) {

					} else {
						break;
					}
				}
			}
			if (Integer.parseInt(resposta) == 2) {

				String arv = essa.imprimeArvore("", essa.getRaiz());
				JOptionPane.showMessageDialog(null, arv);

			}

		}

	}
}