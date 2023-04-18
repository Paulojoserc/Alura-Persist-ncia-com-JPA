package br.com.alura.loja.testes;

import java.math.BigDecimal;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.alura.loja.dao.ProdutoDao;
import br.com.alura.loja.modelo.Produto;
import br.com.alura.loja.util.JPAUtil;

public class CadastroDeProduto {
	public static void main(String[] args) {
		Produto celular = new Produto();
		celular.setNome("Xiaomi Redmi");
		celular.setDescricao("Maito legal");
		celular.setPreco(new BigDecimal("800"));
		
		
		EntityManager em = JPAUtil.getEntityManager();
		ProdutoDao dao = new ProdutoDao(em);
		
		//Pede para jpa pegar a transação
		em.getTransaction().begin();
		//O que vc quer fazer de operação
		dao.cadastrar(celular);
		//Faz o commit
		em.getTransaction().commit();
		em.close();
		

	}
}
