package br.com.alura.loja.modelo;

import javax.persistence.Entity;

@Entity
public class Informatica {
private String Marca;
private String Modelo;

public Informatica() {
}

public Informatica(String marca, String modelo) {
	super();
	Marca = marca;
	Modelo = modelo;
}

public String getMarca() {
	return Marca;
}

public void setMarca(String marca) {
	Marca = marca;
}

public String getModelo() {
	return Modelo;
}

public void setModelo(String modelo) {
	Modelo = modelo;
}

}
