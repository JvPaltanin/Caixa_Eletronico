package exercicios;

import javax.swing.JOptionPane;

/**
 * Programa para simular o funcionamento de um caixa bancário eletrônico.
 * 
 * @author João Victor
 * @since 08/02/2021
 */
public class CaixaEletronico {

	/*
	 * Método principal para executar a classe
	 */
	public static void main(String[] args) {
		// declarando as variáveis
		double saque, resto;
		int n2, n5, n10, n20, n50;

		// pede pro usuário informar o valor que deseja sacar
		saque = Double.parseDouble(JOptionPane.showInputDialog("===== Caixa Eletrônico =====\n"
				+ "Notas disponíveis: 2, 5, 10, 20, 50\n\n" + "Informe o valor que deseja sacar"));

		// calcula o resto da divisão do valor do saque por 1
		resto = saque % 1;

		// verificando se saque menor igual a 0
		if ((saque <= 1) || (saque == 3)) {
			JOptionPane.showMessageDialog(null, "Informe um valor válido!");
		} else if (resto != 0) { // verifica casas decimais a partir do resto da divisão do saque por 1
			JOptionPane.showMessageDialog(null, "Valor tem casas decimais: R$ " + saque);
		} else if (saque > 0) { // saque maior igual a 0

			// calculando a quantidade de notas e subtraindo do valor do saque até ser 0
			n50 = (int) saque / 50;
			saque -= (n50 * 50);

			n20 = (int) saque / 20;
			saque -= (n20 * 20);

			n10 = (int) saque / 10;
			saque -= (n10 * 10);

			n5 = (int) saque / 5;
			saque -= (n5 * 5);

			n2 = (int) saque / 2;
			saque -= (n2 * 2);

			// verifica se falta sacar 1 real
			if (saque == 1) {
				if (n5 >= 1) { // caso o valor do saque restante seja 6 ou 8 transforma em notas de 2
					n5 -= 1;
					n2 += 3;
				} else if (n10 >= 1) { // caso o valor do saque restante seja 11 ou 13 transforma em notas de 2 e 5
					n10 -= 1;
					n5 += 1;
					n2 += 3;
				} else if (n20 >= 1) { // caso o valor do saque restante seja 21 e 23 transforma em notas de 2, 5 e 10
					n20 -= 1;
					n10 += 1;
					n5 += 1;
					n2 += 3;
				} else if (n50 >= 1) { // caso o valor do saque restante seja ou 51 ou 53 transforma em notas de 2
					n50 -= 1;
					n20 += 2;
					n5 += 1;
					n2 += 3;
				}
			}

			// variável declarada vazia para mostrar a mensagem final pro usuário
			String msg = "";
			if (n50 > 0) { // se tiver n50 ele concatena na String
				msg += "\nNotas de R$ 50,00: " + n50;
			}
			if (n20 > 0) { // se tiver n20 ele concatena na String
				msg += "\nNotas de R$ 20,00: " + n20;
			}
			if (n10 > 0) { // se tiver n10 ele concatena na String
				msg += "\nNotas de R$ 10,00: " + n10;
			}
			if (n5 > 0) { // se tiver n5 ele concatena na String
				msg += "\nNotas de R$ 5,00: " + n5;
			}
			if (n2 > 0) { // se tiver n2 ele concatena na String
				msg += "\nNotas de R$ 2,00: " + n2;
			}
			// mostra na tela a mensagem somente com as notas que serão sacadas
			JOptionPane.showMessageDialog(null, msg);

		} else {
			// mostra mensagem de erro na tela
			JOptionPane.showMessageDialog(null, "Informe um valor válido!");
		}
	}

}