package application;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.ResourceBundle;

import gui.util.Utils;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import model.entities.Cliente;
import model.entities.Garcom;
import model.entities.Pedido;
import model.entities.Produto;
import model.services.CadastroPedidoService;

public class CadastroPedidoController implements Initializable{
	
	private Pedido entity;
	
	private CadastroPedidoService service;
	
	@FXML
	private ComboBox<String> comboBoxProdutos;
	
	private ObservableList<String> obsProdutos;
	@FXML
	private ComboBox<String> comboBoxClientes;
	
	private ObservableList<String> obsClientes;
	
	@FXML
	private ComboBox<String> comboBoxGarcons;
	
	private ObservableList<String> obsGarcons;
	
	@FXML
	private TextField txtQtd;
	
	
	@FXML
	private Button btCadastro;
	
	@FXML
	private Button btCancel;
	
	public void setPedido(Pedido entity) {
		this.entity = entity;
	}
	
	public void setCadastroPedidoService(CadastroPedidoService service) {
		this.service = service;
	}
	
	@FXML
	public void onBtCadastroAction(ActionEvent event) {
		if(entity == null) {
			throw new IllegalStateException("Exception was null");
		}
		if(service == null) {
			throw new IllegalStateException("Service was null");
		}
		entity = getFormData();		
		String path = "/home/nicolas/eclipse-workspace/ws-javafx/sistemaRestaurante/data/pedidos.txt";
		service.saveOrUpdate(path, entity);
		Utils.currentStage(event).close();
		
	}
	
	@FXML
	public void onBtCancelAction(ActionEvent event) {
		Utils.currentStage(event).close();
	}
	
	private Produto getProdutoComboBox(String opcaoProdutoComboBox) {
		Produto p = new Produto();
		String codigo = opcaoProdutoComboBox;
		String descricao;
		String valor;
		String path = "/home/nicolas/eclipse-workspace/ws-javafx/sistemaRestaurante/data/produtos.txt";
		FileReader fr = null;
		BufferedReader br = null;
		try {
			fr = new FileReader(path);
			br = new BufferedReader(fr);
			String line = br.readLine();
			int posicaoValor;
			int posicaoDescricao;
			while(line!=null) {
				if(line.indexOf(codigo)!=-1) {
					posicaoValor = line.indexOf("Valor");
					posicaoDescricao = line.indexOf("Descrição");
					valor = line.substring(posicaoValor+6,posicaoDescricao-1);
					descricao = line.substring(posicaoDescricao+10,line.length()-1);
					p.setCodigo(Integer.parseInt(codigo));
					p.setDescricao(descricao);
					p.setValor(Double.parseDouble(valor));
				}
				line = br.readLine();
			}
		}
		catch(IOException e){
			System.out.println("ERROR: " + e.getMessage());
		}
		finally {
			try {
				if(br!=null)
					br.close();
				if(fr!=null)
					fr.close();
			}
			catch(IOException e) {
				e.printStackTrace();
			}
			
		}
		return p;
	}
	
	private Garcom getGarcomComboBox(String opcaoCarcomComboBox) {
		Garcom g = new Garcom();
		String nome = opcaoCarcomComboBox;
		Double salario = null;
		String cargo = "Garçom";
		String cpf = null;
		Integer clientesAtendidos = -1;
		String path = "/home/nicolas/eclipse-workspace/ws-javafx/sistemaRestaurante/data/funcionarios.txt";
		FileReader fr = null;
		BufferedReader br = null;
		try {
			fr = new FileReader(path);
			br = new BufferedReader(fr);
			String line = br.readLine();
			while(line!=null) {
				if(line.indexOf(nome)!=-1) {
					nome = line.substring(6, line.indexOf("CPF")-1);
					salario = Double.valueOf(line.substring(line.indexOf("Salario") + 8, line.indexOf("Clientes") -1 ));
					cpf = line.substring(line.indexOf("CPF")+4, line.indexOf("Cargo")-1);
					clientesAtendidos = Integer.valueOf(line.substring(line.lastIndexOf(":")+1,line.length()-1));
					
				}
				line = br.readLine();
			}
		}
		catch(IOException e){
			System.out.println("ERROR: " + e.getMessage());
		}
		finally {
			try {
				if(br!=null)
					br.close();
				if(fr!=null)
					fr.close();
			}
			catch(IOException e) {
				e.printStackTrace();
			}
			
		}
		g.setNome(nome);
		g.setClientesAtendidos(clientesAtendidos);
		g.setCpf(cpf);
		g.setCargo(cargo);
		g.setSalario(salario);
		return g;
	}
	
	
	private Cliente getClienteComboBox(String opcaoClienteComboBox) {
		Cliente c = new Cliente();
		String nome =  opcaoClienteComboBox;
		String cpf = null;
		String path = "/home/nicolas/eclipse-workspace/ws-javafx/sistemaRestaurante/data/clientes.txt";
		FileReader fr = null;
		BufferedReader br = null;
		try {
			fr = new FileReader(path);
			br = new BufferedReader(fr);
			String line = br.readLine();
			while(line!=null) {
				if(line.indexOf(nome)!=-1) {
					nome = line.substring(line.indexOf("Nome")+5, line.indexOf("CPF"));
					cpf = line.substring(line.indexOf("CPF") + 4, line.length()-1);	
				}
				line = br.readLine();
			}
		}
		catch(IOException e){
			System.out.println("ERROR: " + e.getMessage());
		}
		finally {
			try {
				if(br!=null)
					br.close();
				if(fr!=null)
					fr.close();
			}
			catch(IOException e) {
				e.printStackTrace();
			}
			
		}
		c.setNome(nome);
		c.setCpf(cpf);
		return c;
	}
	
	
	
	private Pedido getFormData() {
		Pedido obj = new Pedido();
		Integer codigo = 1;
		obj.addProduto(getProdutoComboBox(comboBoxProdutos.getSelectionModel().getSelectedItem()));
		obj.setGarcom(getGarcomComboBox(comboBoxGarcons.getSelectionModel().getSelectedItem()));
		obj.setCliente(getClienteComboBox(comboBoxClientes.getSelectionModel().getSelectedItem()));
		Date data = new Date();
		obj.setData(data);
		obj.setCodigo(codigo);
		

		return obj;
	}
	
	
	@Override
	public void initialize(URL uri, ResourceBundle rb) {
		
		List<String> produtos = new ArrayList<>();
		List<String> garcons = new ArrayList<>();
		List<String> clientes = new ArrayList<>();
		String path = "/home/nicolas/eclipse-workspace/ws-javafx/sistemaRestaurante/data/produtos.txt";
		FileReader fr = null;
		BufferedReader br = null;
		try {
			fr = new FileReader(path);
			br = new BufferedReader(fr);
			String line = br.readLine();
			int posicaoEspaco;
			while(line!=null) {
				posicaoEspaco = line.indexOf(" ");
				produtos.add(line.substring(8, posicaoEspaco));
				line = br.readLine();
			}
			
			path = "/home/nicolas/eclipse-workspace/ws-javafx/sistemaRestaurante/data/funcionarios.txt";
			fr = new FileReader(path);
			br = new BufferedReader(fr);
			line = br.readLine();
			while(line!=null) {
				if(line.indexOf("Garçom")!=-1)
					garcons.add(line.substring(6, line.indexOf("CPF")-1));
				line = br.readLine();
			}
			
			path = "/home/nicolas/eclipse-workspace/ws-javafx/sistemaRestaurante/data/clientes.txt";
			fr = new FileReader(path);
			br = new BufferedReader(fr);
			line = br.readLine();
			while(line!=null) {
				clientes.add(line.substring(line.indexOf("Nome")+5, line.indexOf("CPF")));
				line = br.readLine();
			}
			
			
			
		}
		catch(IOException e){
			System.out.println("ERROR: " + e.getMessage());
		}
		finally {
			try {
				if(br!=null)
					br.close();
				if(fr!=null)
					fr.close();
				
			}
			catch(IOException e) {
				e.printStackTrace();
			}
			
		}
		
		obsProdutos = FXCollections.observableArrayList(produtos);
		comboBoxProdutos.setItems(obsProdutos);
		
		obsGarcons = FXCollections.observableArrayList(garcons);
		comboBoxGarcons.setItems(obsGarcons);
		
		obsClientes = FXCollections.observableArrayList(clientes);
		comboBoxClientes.setItems(obsClientes);
		
	}

	public void updateFormData() {
		if(entity == null)
			throw new IllegalStateException("Entity was null");		

	}
	

	
	
}
