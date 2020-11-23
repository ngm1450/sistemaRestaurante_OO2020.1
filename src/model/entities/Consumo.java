package model.entities;

public abstract class Consumo {
	private Integer codigo;
	private String descricao;
	private Double valor ;

	public Consumo() {}
	
	public Consumo(Integer codigo, String descricao, Double valor) {
		this.codigo = codigo;
		this.descricao = descricao;
		this.valor = valor;
	}
	public Integer getCodigo() {
		return codigo;
	}
	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public Double getValor() {
		return valor;
	}
	public void setValor(Double valor) {
		this.valor = valor;
	}
	
	
	
}
