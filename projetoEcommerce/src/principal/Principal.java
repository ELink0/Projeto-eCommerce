package principal;

import java.util.Scanner;

import tela.TelaEstado;
import tela.TelaCidade;
import tela.TelaCliente;

public class Principal {
	public static void main(String args[]) {
		Scanner scan = new Scanner(System.in);
		System.out.println("1 - Gerenciar Estados");
		System.out.println("2 - Gerenciar Cidades");
		System.out.println("3 - Gerenciar Clientes");
		System.out.println("4 - Gerenciar Produtos");
		int op = scan.nextInt();
		scan.nextLine();
		
		if(op == 1) {
			TelaEstado estado = new TelaEstado();
		}
		if (op == 2) {
			TelaCidade cidade = new TelaCidade();
		}
		if (op == 3) {
			TelaCliente cliente = new TelaCliente();
		}
		if (op == 4) {
			TelaProdutos produtos = new TelaProdutos();
		}
	}
	
}
