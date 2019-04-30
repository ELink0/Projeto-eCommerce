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
				
				cliente.setNome(nome);
				cliente.setSigla(sigla);
				
				dao.inserir(estado);
			}if (op ==2) {
				//exibir todos os cadastros
				listarCadastros();
				//perguntar para id para excluir
				System.out.println("EXCLUIR CADASTRO");
				System.out.println("Insira o id do Estado a ser excluido: ");
				estado.setId( scan.nextLong() );
				dao.excluir(estado);
				principal.main(null);
			}
			if (op ==3) {
				listarCadastros();
				//perguntar id para alterar
				System.out.println("ALTERAR CADASTRO");
				System.out.println("Insira o Id do cadastro a ser alterado");	
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
	
	//Só para fazer a listar todos os cadastros em operações
	public void listarCadastros() {
		System.out.println("-----------------------------------------");
		System.out.println("LISTAR TODOS ESTADOS");
		List<Estado> est = dao.buscar(); //estudar melhor o percorrer da lista

		for (Estado estado : est) {
			System.out.println("Id: "+estado.getId()+" Estado: "+estado.getNome()+" - "+estado.getSigla());
		}
		System.out.println("-----------------------------------------");
		
	}
	}

}
