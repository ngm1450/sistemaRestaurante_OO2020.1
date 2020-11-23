package model.services;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

import model.entities.Funcionario;
import model.entities.Garcom;

public class CadastroFuncionarioService {
	public void saveOrUpdateFuncionario(String path, Funcionario obj) {
		try (BufferedWriter bw = new BufferedWriter(new FileWriter(path, true))) {
				bw.write("[Nome:" + obj.getNome() + " CPF:" + obj.getCpf() +  " Cargo:" + obj.getCargo() + " Salario:" + obj.getSalario() + "]");
				bw.newLine();
			
		} catch (IOException e) {
			e.printStackTrace();
		}		
			
	}
	
	public void saveOrUpdateGarcom(String path, Garcom obj) {
		try (BufferedWriter bw = new BufferedWriter(new FileWriter(path, true))) {
				bw.write("[Nome:" + obj.getNome() + " CPF:" + obj.getCpf() +  " Cargo:" + obj.getCargo() + " Salario:" + obj.getSalario() + " Clientes atendidos:" + obj.getClientesAtendidos() + "]");
				bw.newLine();
			
		} catch (IOException e) {
			e.printStackTrace();
		}		
			
	}
}
