package br.com.alura.loja.testes;

import java.math.BigDecimal;

import javax.persistence.EntityManager;

import br.com.alura.loja.dao.CategoriaDao;
import br.com.alura.loja.dao.ProdutoDao;
import br.com.alura.loja.modelo.Categoria;
import br.com.alura.loja.modelo.Produto;
import br.com.alura.loja.util.JPAUtil;

public class CadastroDeProduto {
	public static void main(String[] args) {
		Categoria celulares = new Categoria("CELULARES");
		
		
		//Produto celular = new Produto("Xiaomi Redmi","Maito legal",new BigDecimal("800"),celulares);
				
		EntityManager em = JPAUtil.getEntityManager();
		//ProdutoDao produtoDao = new ProdutoDao(em);
		//CategoriaDao categoriaDao = new CategoriaDao(em);
		
		//Pede para jpa pegar a transação
		em.getTransaction().begin();
		
		//categoriaDao.cadastrar(celulares);
		//O que vc quer fazer de operação
		//produtoDao.cadastrar(celular);
		//Faz o commit
		
		em.persist(celulares);
	    celulares.setNome("XPTO");
		
		em.getTransaction().commit();
		em.close();
		
		 celulares.setNome("1234");
		

	}
}
