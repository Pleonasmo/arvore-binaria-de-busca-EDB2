import arvore.*;

import java.util.ArrayList;

import javax.swing.JOptionPane;

class Main {
	public static void main(String[] args) {
		Arvore a = new Arvore(50);
		a.getRaiz().setFilhoDireita(new No(60));
		a.getRaiz().setAlturaNo(3);
		a.getRaiz().getFilhoDireita().setNivel(2);
		a.getRaiz().getFilhoDireita().setAlturaNo(2);
		a.getRaiz().setFilhoEsquerda(new No(40));
		a.getRaiz().getFilhoEsquerda().setNivel(2);
		a.getRaiz().getFilhoEsquerda().setAlturaNo(2);
		a.getRaiz().getFilhoEsquerda().setFilhoEsquerda(new No(35));
		a.getRaiz().getFilhoEsquerda().getFilhoEsquerda().setNivel(3);
		a.getRaiz().getFilhoEsquerda().getFilhoEsquerda().setAlturaNo(1);
		a.getRaiz().getFilhoEsquerda().setFilhoDireita(new No(42));
		a.getRaiz().getFilhoEsquerda().getFilhoDireita().setAlturaNo(1);
		a.getRaiz().getFilhoEsquerda().getFilhoDireita().setNivel(3);
		a.getRaiz().getFilhoDireita().setFilhoEsquerda(new No(70));
		a.getRaiz().getFilhoDireita().getFilhoEsquerda().setNivel(3);
		a.getRaiz().getFilhoDireita().getFilhoEsquerda().setAlturaNo(1);

		ArrayList<Arvore> arvores = new ArrayList();
		arvores.add(a);
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
						valor = Integer.parseInt(JOptionPane.showInputDialog("Informe o valor: "));
						arvore.inserirElemento(valor, arvore.getRaiz());
					} else {
						break;
					}
				}
			}
			if (Integer.parseInt(resposta) == 2) {
				JOptionPane.showInputDialog(null, "Informe a árvore que deseja acessar:");

				String arv = a.imprimeArvore("", a.getRaiz());
				JOptionPane.showMessageDialog(null, arv);

			}

		}

	}
}