package br.com.alura.loja.modelo;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "pedidos")
public class Pedido {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private BigDecimal ValorTotal;
	private LocalDate data = LocalDate.now();

	@ManyToOne
	private Cliente cliente;

	@OneToMany(mappedBy = "pedido")
	private List<ItemPedido> itens = new ArrayList<>();

	public Pedido() {
	}

	public Pedido(Cliente cliente) {
		this.cliente = cliente;
	}

	public void adicionarItem(ItemPedido item) {
		item.setPedido(this);
		this.itens.add(item);
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public BigDecimal getPreco() {
		return ValorTotal;
	}

	public void setPreco(BigDecimal ValorTotal) {
		this.ValorTotal = ValorTotal;
	}

	public LocalDate getDataCadastro() {
		return data;
	}

	public void setDataCadastro(LocalDate data) {
		this.data = data;
	}

	public Cliente getCategoria() {
		return cliente;
	}

	public void setCategoria(Cliente cliente) {
		this.cliente = cliente;
	}

}
