package dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;

import entidade.Cliente;
import fabrica.Fabrica;

public class DAOCliente {
	private EntityManager gerenciador; //responsável em gerenciar entidade, possui CRUD, representa a conexao com o BD
	private EntityTransaction transacao;
	
	public Cliente inserir(Cliente cliente) {
		try {
			
			EntityManagerFactory fabrica = Fabrica.get();
			gerenciador = fabrica.createEntityManager();//cria gerenciador de entidade
			transacao = gerenciador.getTransaction();//criar controlador de transações
			
			transacao.begin();//inicia a transação
			gerenciador.persist(cliente);//salvar/inserir a entidade
			transacao.commit();//confirma transação
			
		}catch(Exception e) {
			e.printStackTrace();//imprime o erro
			transacao.rollback();//cancela a transação
		}finally {
			gerenciador.close();
		}
		return cliente;
	}
	public Cliente excluir(Cliente cliente) {
		try {
			// representa a conexão e tem metodos CRUD
			
			EntityManagerFactory fabrica = Fabrica.get(); //declaramos fabrica, ela representa a classe fábrica
			gerenciador = fabrica.createEntityManager(); //criamos o gerenciador, responsável por permitir a interação com o banco
			transacao = gerenciador.getTransaction(); //responsável por fazer operações no banco de alteração e outras modificações
			
			
			transacao.begin();
			cliente = gerenciador.find(Cliente.class, cliente.getId());
			gerenciador.remove(cliente);
			transacao.commit();
			
		} catch (Exception e) {
			e.printStackTrace();
			transacao.rollback();
		}finally {
			gerenciador.close();
		}return cliente;//retorna o estado salvo  
		
	}
	public Cliente alterar(Cliente cliente) {
		try {
			EntityManagerFactory fabrica = Fabrica.get();
			gerenciador = fabrica.createEntityManager();
			transacao = gerenciador.getTransaction();
			
			transacao.begin();
			gerenciador.merge(cliente);
			transacao.commit();
			
		}catch(Exception e){
			e.printStackTrace();
			transacao.rollback();
		}finally {
			gerenciador.close();
		}return cliente;
	}
	
	
	
	public List<Cliente> buscar() {
		try {
			EntityManagerFactory fabrica = Fabrica.get();
			gerenciador = fabrica.createEntityManager();
		
			return gerenciador.createQuery("from Cliente").getResultList();
			
		}catch(Exception e) {
			e.printStackTrace();
			transacao.rollback();
		}finally {
			gerenciador.close();
		}
		return null;

	}
	public Cliente buscarEspecifico(Cliente cliente) {
		try {
			
			EntityManagerFactory fabrica = Fabrica.get();
			gerenciador = fabrica.createEntityManager();
			cliente = gerenciador.find(Cliente.class, cliente.getNome());
			transacao.commit();
			
			
		} catch (Exception e) {
			e.printStackTrace();
			transacao.rollback();
		}finally {
			gerenciador.close();
		}
		return cliente;
	}
}
