package br.com.alura.loja.testes;

import javax.persistence.EntityManager;

import br.com.alura.loja.modelo.Categoria;
import br.com.alura.loja.util.JPAUtil;

public class CadastroDeProduto {
	public static void main(String[] args) {
		Categoria celulares = new Categoria("CELULARES");

		// Produto celular = new Produto("Xiaomi Redmi","Maito legal",new
		// BigDecimal("800"),celulares);

		EntityManager em = JPAUtil.getEntityManager();
		// ProdutoDao produtoDao = new ProdutoDao(em);
		// CategoriaDao categoriaDao = new CategoriaDao(em);

		// Pede para jpa pegar a transação
		em.getTransaction().begin();

		// categoriaDao.cadastrar(celulares);
		// O que vc quer fazer de operação
		// produtoDao.cadastrar(celular);
		// Faz o commit
		em.persist(celulares);
		celulares.setNome("XPTO");
		//Dispara um update no banco do em.persist
		em.flush();
		em.clear();
		//Margem faz um select no banco
		celulares = em.merge(celulares);
		celulares.setNome("1234");
		em.flush();
	//	em.clear();
		//Deletar no banco a entidade
		em.remove(celulares);
		em.flush();

	}
}
