package dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;

import entidade.Cliente;
import fabrica.Fabrica;

public class DAOCliente {
	private EntityManager gerenciador; //respons�vel em gerenciar entidade, possui CRUD, representa a conexao com o BD
	private EntityTransaction transacao;
	
	public Cliente inserir(Cliente cliente) {
		try {
			
			EntityManagerFactory fabrica = Fabrica.get();
			gerenciador = fabrica.createEntityManager();//cria gerenciador de entidade
			transacao = gerenciador.getTransaction();//criar controlador de transa��es
			
			transacao.begin();//inicia a transa��o
			gerenciador.persist(cliente);//salvar/inserir a entidade
			transacao.commit();//confirma transa��o
			
		}catch(Exception e) {
			e.printStackTrace();//imprime o erro
			transacao.rollback();//cancela a transa��o
		}finally {
			gerenciador.close();
		}
		return cliente;
	}
	public Cliente excluir(Cliente cliente) {
		try {
			// representa a conex�o e tem metodos CRUD
			
			EntityManagerFactory fabrica = Fabrica.get(); //declaramos fabrica, ela representa a classe f�brica
			gerenciador = fabrica.createEntityManager(); //criamos o gerenciador, respons�vel por permitir a intera��o com o banco
			transacao = gerenciador.getTransaction(); //respons�vel por fazer opera��es no banco de altera��o e outras modifica��es
			
			
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
