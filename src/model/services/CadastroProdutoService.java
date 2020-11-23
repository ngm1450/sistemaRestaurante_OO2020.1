package model.services;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

import model.entities.Produto;

public class CadastroProdutoService {
	
	public void saveOrUpdate(String path, Produto obj) {
		try (BufferedWriter bw = new BufferedWriter(new FileWriter(path, true))) {
				bw.write("[Código:" + obj.getCodigo() + " Valor:" + String.format("%.3f", obj.getValor())+ 
						" Descrição:" + obj.getDescricao() +"]");
				bw.newLine();
			
		} catch (IOException e) {
			e.printStackTrace();
		}		
			
	}
}
