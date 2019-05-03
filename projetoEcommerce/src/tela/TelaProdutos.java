package tela;

import java.util.List;
import java.util.Scanner;

import dao.DAOProdutos;
import entidade.Produtos;
import entidade.Estado;
import principal.Principal;

public class TelaProdutos {
	private Scanner scan = new Scanner(System.in);
	private String menu = " 1 - Inserir Produtos \n 2 - Excluir Produtos \n 3 - Alterar Produtos \n 4 - Consultar Produtos \n";
	private Produtos produtos = new Produtos();
	private DAOProdutos dao = new DAOProdutos();
	private Principal principal = new Principal();
	
	public TelaProdutos() {
		String r = "s";
		int op = 0;
		do {
			do {
				System.out.println(menu);
				op = scan.nextInt();
				scan.nextLine();
			}while(op < 1 && op > 4);
			
			if(op == 1) {
				System.out.println("INSERIR NOVO PRODUTO \n\n\n\n");
				System.out.println("Nome: ");
				produtos.setNome(scan.next());
				System.out.println("Quantidade: ");
				produtos.setQuantidade(scan.next());
				System.out.println("Preco: ");
				produtos.setPreco(scan.next());
				
				dao.inserir(produtos);
			}if (op ==2) {
				listarCadastros();
				System.out.println("EXCLUIR CADASTRO DE CLIENTE");
				System.out.println("ID do Cliente: ");
				produtos.setId( scan.nextLong() );
				dao.excluir(produtos);
				principal.main(null);
			}
			if (op ==3) {
				listarCadastros();
				System.out.println("ALTERAR CADASTRO DE PRODUTO");
				System.out.println("ID do Cliente: ");	
				produtos.setId(scan.nextLong());
				System.out.println("Nome do cliente: ");
				produtos.setNome(scan.next());
				System.out.println("Quantidade: ");
				produtos.setQuantidade(scan.next());
				System.out.println("Preço: ");
				produtos.setPreco(scan.next());
				
				System.out.println("Alterando...");
				dao.alterar(produtos);
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
		System.out.println("LISTAR TODOS OS CLIENTES");
		List<Produtos> est = dao.buscar();

		for (Produtos produtos : est) {
			System.out.println("Id: "+produtos.getId()+" \nNome: "+produtos.getNome()+" \nQuantidade: "+produtos.getQuantidade()+" \n Preço: "+produtos.getPreco());
		}
		System.out.println("-----------------------------------------");
		
	}
}
