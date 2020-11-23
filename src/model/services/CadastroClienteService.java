package model.services;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

import model.entities.Cliente;

public class CadastroClienteService {
	
	public void saveOrUpdate(String path, Cliente obj) {
		try (BufferedWriter bw = new BufferedWriter(new FileWriter(path, true))) {
				bw.write("[Nome:" + obj.getNome() + " CPF:" + obj.getCpf() + "]");
				bw.newLine();
			
		} catch (IOException e) {
			e.printStackTrace();
		}		
			
	}
}
