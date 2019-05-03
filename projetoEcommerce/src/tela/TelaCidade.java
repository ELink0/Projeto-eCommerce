package tela;

import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

import dao.DAOCidade;
import dao.DAOEstado;
import entidade.Cidade;
import entidade.Estado;
import principal.Principal;

public class TelaCidade {
	private Scanner scan = new Scanner(System.in);
	private String menu = " 1 - Inserir \n 2 - Excluir \n 3 - Alterar \n 4 - Consultar \n";
	private Estado estado = new Estado();
	private DAOCidade daocidade = new DAOCidade();
	private Principal principal = new Principal();
	
	public TelaCidade() {
		Cidade cidade = new Cidade();
		DAOEstado daoestado = new DAOEstado();
		Estado estado = new Estado();
		
		String r = "s";
		int op = 0;
		do {
			do {
				System.out.println(menu);
				op = scan.nextInt();
				scan.nextLine();
			}while(op < 1 && op > 4);
			
			if(op == 1) {
				System.out.println("Nome da cidade: ");
				String nome = scan.nextLine();
				cidade.setNome(nome);
				listarCadastrosEstado();
				
				System.out.println("Insira o ID: ");
				long id = scan.nextLong();
				estado.setId(id);
				cidade.setEstado(estado);
				daocidade.inserir(cidade);
				principal.main(null);
			}if (op ==2) {
				listarCadastrosCidade();
				System.out.println("EXCLUIR CADASTRO");
				System.out.println("Insira o id do Estado a ser excluido: ");
				cidade.setId( scan.nextLong() );
				daocidade.excluir(cidade);
				principal.main(null);
			}
			if (op ==3) {
				listarCadastrosCidade();
				System.out.println("ALTERAR CADASTRO");
				System.out.println("Insira o Id do cadastro a ser alterado");	
				cidade.setId(scan.nextLong());
				System.out.println("Novo nome: ");
				cidade.setNome(scan.next());
				
				listarCadastrosEstado();
				System.out.println("Novo Estado, id: ");
				long id = scan.nextLong();
				
				System.out.println("Alterando...");
				
				estado.setId(id);
				cidade.setEstado(estado);
				daocidade.alterar(cidade);
				
				
				principal.main(null);
			}
			
			if(op == 4) {
				listarCadastrosCidade();
				
			}

			
			System.out.println("Deseja realmente continuar? (s/n)");
			
			r = scan.nextLine();
			
		}while(r.contentEquals("s"));
	}
	public void listarCadastrosCidade() {
		
		
		System.out.println("-----------------------------------------");
		System.out.println("LISTAR TODAS CIDADES");
		List<Cidade> cid = daocidade.buscar();
		
		for(Cidade cidade : cid) {
			System.out.println("Id: "+cidade.getId()+" Cidade: "+cidade.getNome()+" Estado: "+cidade.getEstado());
		}
	}
	public void listarCadastrosEstado() {
		DAOEstado daoestado = new DAOEstado();
		Estado estado = new Estado();
		List<Estado> lista = daoestado.buscar();
		
		for (Estado est : lista) {
			System.out.println("Id: "+est.getId()+" Estado: "+est.getNome()+" - "+est.getSigla());
		}
	}


}
