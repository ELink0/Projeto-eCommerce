package tela;

import java.util.List;
import java.util.Scanner;

import dao.DAOCliente;
import entidade.Cliente;
import entidade.Estado;
import principal.Principal;

public class TelaCliente {
	private Scanner scan = new Scanner(System.in);
	private String menu = " 1 - Inserir \n 2 - Excluir \n 3 - Alterar \n 4 - Consultar \n";
	private Cliente cliente = new Cliente();
	private DAOCliente dao = new DAOCliente();
	private Principal principal = new Principal();
	
	public TelaCliente() {
		String r = "s";
		int op = 0;
		do {
			do {
				System.out.println(menu);
				op = scan.nextInt();
				scan.nextLine();
			}while(op < 1 && op > 4);
			
			if(op == 1) {
				System.out.println("INSERIR NOVO CLIENTE \n\n\n\n");
				System.out.println("Nome do cliente: ");
				cliente.setNome(scan.next());
				System.out.println("Telefone: ");
				cliente.setTelefone(scan.next());
				System.out.println("CPF: ");
				cliente.setCpf(scan.next());
				System.out.println("RG: ");
				cliente.setRg(scan.next());
				System.out.println("Endereço: ");
				cliente.setEndereco(scan.next());
				
				dao.inserir(cliente);
			}if (op ==2) {
				listarCadastros();
				System.out.println("EXCLUIR CADASTRO DE CLIENTE");
				System.out.println("ID do Cliente: ");
				cliente.setId( scan.nextLong() );
				dao.excluir(cliente);
				principal.main(null);
			}
			if (op ==3) {
				listarCadastros();
				System.out.println("ALTERAR CADASTRO DE CLIENTE");
				System.out.println("ID do Cliente: ");	
				cliente.setId(scan.nextLong());
				System.out.println("Nome do cliente: ");
				cliente.setNome(scan.next());
				System.out.println("Telefone: ");
				cliente.setTelefone(scan.next());
				System.out.println("CPF: ");
				cliente.setCpf(scan.next());
				System.out.println("RG: ");
				cliente.setRg(scan.next());
				System.out.println("Endereço: ");
				cliente.setEndereco(scan.next());
				
				System.out.println("Alterando...");
				dao.alterar(cliente);
				principal.main(null);
				
			}
			
			
			if(op == 4) {
				listarCadastros();
				
			}

			
			System.out.println("Deseja realmente continuar? (s/n)");
			
			r = scan.nextLine();
			
		}while(r.contentEquals("s"));
	}
	
	public void listarCadastros() {
		System.out.println("-----------------------------------------");
		System.out.println("LISTAR TODOS ESTADOS");
		List<Cliente> est = dao.buscar();

		for (Cliente cliente : est) {
			System.out.println("Id: "+cliente.getId()+" \nEstado: "+cliente.getNome()+" \nTelefone: "+cliente.getTelefone()+" \n CPF: "+cliente.getCpf()+" \nRG: "+cliente.getRg());
		}
		System.out.println("-----------------------------------------");
		
	}
}
