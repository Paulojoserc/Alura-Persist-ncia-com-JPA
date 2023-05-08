package br.com.alura.loja.testes;

import java.math.BigDecimal;

import javax.persistence.EntityManager;

import br.com.alura.loja.modelo.Categoria;
import br.com.alura.loja.modelo.Pedido;
import br.com.alura.loja.modelo.Produto;
import br.com.alura.loja.util.JPAUtil;

public class PerformanceConsultas {
public static void main(String[] args) {
	popularBancoDeDados();
	EntityManager em = JPAUtil.getEntityManager();
	Pedido pedido = em.find(Pedido.class, 1l);
	System.out.println(pedido.getItens().size());
}
private static void popularBancoDeDados() {
	Categoria celulares = new Categoria("CELULARES");
	Categoria videogames = new Categoria("VIDEOGAMES");
	Categoria informatica = new Categoria("INFORMATICA");
	
	Produto celular = new Produto("Xiaomi Redmi", "Muito legal", new BigDecimal("800"), celulares);
	Produto videogame = new Produto("PS5", "Playstation 5", new BigDecimal("8000"), videogames);
	Produto macbook = new Produto("Macbook", "Macboo pro retina", new BigDecimal("14000"), informatica);
	
	
}
}
