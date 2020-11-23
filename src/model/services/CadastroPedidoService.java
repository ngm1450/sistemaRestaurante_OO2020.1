package model.services;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import model.entities.Pedido;
import model.entities.Produto;

public class CadastroPedidoService {
	SimpleDateFormat sdf1 = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
	public void saveOrUpdate(String path, Pedido obj) {
		List<Produto> produtos = new ArrayList<>();
		produtos = obj.getProdutos();
		Integer codigoProduto = -1;
		for(Produto p: produtos)
			codigoProduto = p.getCodigo();
		try (BufferedWriter bw = new BufferedWriter(new FileWriter(path, true))) {
				bw.write("[Cliente:" + 
						obj.getCliente().getNome() + 
						" Data:" + sdf1.format(obj.getData()) + 
						" Produto" + codigoProduto +
						" Garçom"  + obj.getGarcom().getNome()+ 
						" Valor" + obj.getValor() +
 						"]" );
				bw.newLine();
			
		} catch (IOException e) {
			e.printStackTrace();
		}		
			
	}
}
