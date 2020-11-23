package model.entities;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Pedido {
	//Atributos base:
	private Integer codigo;
	private Date data;
	private Double valor = 0.0;
	
	//Associações:
	private Cliente cliente;
	private Garcom garcom;
	
	List<Produto> produtos = new ArrayList<>();
	
	public Pedido() {
		
	}
	public Pedido(Integer codigo, Date data, Cliente cliente) {
		this.codigo = codigo;
		this.data = data;
		this.cliente = cliente;
	}

	public Integer getCodigo() {
		return codigo;
	}

	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}
	
	public Date getData() {
		return data;
	}
	public Cliente getCliente() {
		return cliente;
	}
	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	
	public Garcom getGarcom() {
		return garcom;
	}
	public void setGarcom(Garcom garcom) {
		this.garcom = garcom;
	}
	
	public void setData(Date data) {
		this.data = data;
	}

	public Double getValor() {
		for(Produto p : produtos)
			this.valor += p.getValor();
		return valor;
	}
	
	public void addProduto(Produto produto) {
		produtos.add(produto);
	}
	
	public void removeProduto(Produto produto) {
		produtos.remove(produto);
	}
	
	public List<Produto> getProdutos(){
		return produtos;
	}
}