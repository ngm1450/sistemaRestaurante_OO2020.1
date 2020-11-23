package model.entities;

public class Funcionario {
	private String nome;
	private String cargo;
	private String cpf;
	private Double salario;
	
	public Funcionario() {
		
	}

	public Funcionario(String nome, String cargo, String cpf, Double salario) {
		this.nome = nome;
		this.cargo = cargo;
		this.cpf = cpf;
		this.salario = salario;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCargo() {
		return cargo;
	}

	public void setCargo(String cargo) {
		this.cargo = cargo;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public Double getSalario() {
		return salario;
	}

	public void setSalario(Double salario) {
		this.salario = salario;
	}
	
	
	
	
}