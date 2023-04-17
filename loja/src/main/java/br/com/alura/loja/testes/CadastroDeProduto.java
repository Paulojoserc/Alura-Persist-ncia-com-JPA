package br.com.alura.loja.testes;

import java.math.BigDecimal;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.alura.loja.modelo.Produto;

public class CadastroDeProduto {
	public static void main(String[] args) {
		Produto celular = new Produto();
		celular.setNome("Xiaomi Redmi");
		celular.setDescricao("Maito legal");
		celular.setPreco(new BigDecimal("800"));
		
		
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("loja");
		//Tem um papel de gerenciar as entidades
		EntityManager em = factory.createEntityManager();
		//Pede para jpa pegar a transação
		em.getTransaction().begin();
		//O que vc quer fazer de operação
		em.persist(celular);
		//Faz o commit
		em.getTransaction().commit();
		em.close();
		

	}
}
