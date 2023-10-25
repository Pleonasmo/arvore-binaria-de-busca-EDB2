import arvore.Arvore;

import java.util.ArrayList;

import javax.swing.JOptionPane;

class Main {
	public static void main(String[] args) {

		ArrayList<Arvore> arvores = new ArrayList();
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
				JOptionPane.showMessageDialog(null, "Essa parte ainda não foi programada - 1");
			}
			if (Integer.parseInt(resposta) == 2) {

				JOptionPane.showMessageDialog(null, "Essa parte ainda não foi programada - 2");

			}

		}

	}
}