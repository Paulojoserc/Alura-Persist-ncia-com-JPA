package br.com.alura.loja.testes;

import java.math.BigDecimal;

import javax.persistence.EntityManager;

import br.com.alura.loja.dao.ProdutoDao;
import br.com.alura.loja.modelo.Categoria;
import br.com.alura.loja.modelo.Produto;
import br.com.alura.loja.util.JPAUtil;

public class CadastroDeProduto {
	public static void main(String[] args) {
		Produto celular = new Produto("Xiaomi Redmi","Maito legal",new BigDecimal("800"),Categoria.CELULARES);
				
		EntityManager em = JPAUtil.getEntityManager();
		ProdutoDao dao = new ProdutoDao(em);
		
		//Pede para jpa pegar a transa��o
		em.getTransaction().begin();
		//O que vc quer fazer de opera��o
		dao.cadastrar(celular);
		//Faz o commit
		em.getTransaction().commit();
		em.close();
		

	}
}
