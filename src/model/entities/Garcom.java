package model.entities;

public class Garcom extends Funcionario {
	private Integer clientesAtendidos;

	public Garcom() {
		
	}
	
	public Garcom(String nome, String cargo, String cpf, Double salario, Integer clientesAtendidos) {
		super(nome, cargo, cpf, salario);
		this.clientesAtendidos = clientesAtendidos;
	}

	public Integer getClientesAtendidos() {
		return clientesAtendidos;
	}

	public void setClientesAtendidos(Integer clientesAtendidos) {
		this.clientesAtendidos = clientesAtendidos;
	}
	
	
}