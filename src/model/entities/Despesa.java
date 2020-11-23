package model.entities;

import java.util.Date;

public class Despesa extends Consumo{

	private Date data;
	
	public Despesa(Integer codigo, String descricao, Double valor, Date data) {

		super(codigo,descricao,valor);
		this.data = data;
	}
	
	public Date getData() {
		return data;
	}
	public void setData(Date data) {
		this.data = data;
	}
	
	
}