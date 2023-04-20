package br.com.alura.loja.testes;

import java.math.BigDecimal;
import java.util.List;

import javax.persistence.EntityManager;

import br.com.alura.loja.dao.CategoriaDao;
import br.com.alura.loja.dao.ProdutoDao;
import br.com.alura.loja.modelo.Categoria;
import br.com.alura.loja.modelo.Produto;
import br.com.alura.loja.util.JPAUtil;

public class CadastroDeProduto {
	public static void main(String[] args) {
		cadastrarProduto();
				
		EntityManager em = JPAUtil.getEntityManager();
		ProdutoDao produtoDao = new ProdutoDao(em);
		
		Produto p = produtoDao.buscarPorId(1l);
		/*System.out.println(p.getPreco());
		*/
		List<Produto> todos = produtoDao.buscarTodos();
		todos.forEach(p2 -> System.out.println(p.getNome()));

	}

	private static void cadastrarProduto() {
		Categoria celulares = new Categoria("CELULARES");

		Produto celular = new Produto("Xiaomi Redmi", "Maito legal", new BigDecimal("800"), celulares);

		EntityManager em = JPAUtil.getEntityManager();
		ProdutoDao produtoDao = new ProdutoDao(em);
		CategoriaDao categoriaDao = new CategoriaDao(em);

		// Pede para jpa pegar a transação
		em.getTransaction().begin();

		categoriaDao.cadastrar(celulares);
		// O que vc quer fazer de operação
		produtoDao.cadastrar(celular);
		// Faz o commit
		em.persist(celulares);
		celulares.setNome("XPTO");
		// Dispara um update no banco do em.persist
		em.flush();
		em.clear();
		// Margem faz um select no banco
		celulares = em.merge(celulares);
		celulares.setNome("1234");
		em.flush();
		// em.clear();
		// Deletar no banco a entidade
		em.remove(celulares);
		em.flush();
	}
}
