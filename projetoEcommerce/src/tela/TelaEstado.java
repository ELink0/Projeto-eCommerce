
package tela;

import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

import dao.DAOEstado;
import entidade.Estado;
import principal.Principal;

public class TelaEstado {
	private Scanner scan = new Scanner(System.in);
	private String menu = " 1 - Inserir \n 2 - Excluir \n 3 - Alterar \n 4 - Consultar \n";
	private Estado estado = new Estado();
	private DAOEstado dao = new DAOEstado();
	private Principal principal = new Principal();
	
	public TelaEstado() {
		
		String r = "s";
		int op = 0;
		do {
			do {
				System.out.println(menu);
				op = scan.nextInt();
				scan.nextLine();
			}while(op < 1 && op > 4);
			
			if(op == 1) {
				System.out.println("INSERIR NOVO ESTADO \n\n\n\n");
				System.out.println("Nome do estado:");
				String nome = scan.nextLine();
				System.out.println("Sigla do estado:");
				String sigla = scan.nextLine();
				
				estado.setNome(nome);
				estado.setSigla(sigla);
				
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
				estado.setId(scan.nextLong());
				System.out.println("Novo nome: ");
				estado.setNome(scan.next());
				System.out.println("Nova sigla: ");
				estado.setSigla(scan.next());
				
				System.out.println("Alterando...");
				dao.alterar(estado);
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
		List<Estado> est = dao.buscar(); 

		for (Estado estado : est) {
			System.out.println("Id: "+estado.getId()+" Estado: "+estado.getNome()+" - "+estado.getSigla());
		}
		System.out.println("-----------------------------------------");
		
	}
}
