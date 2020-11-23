package application;

import java.net.URL;
import java.util.ResourceBundle;

import gui.util.Utils;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

import model.entities.Produto;
import model.services.CadastroProdutoService;

public class CadastroProdutoController implements Initializable {

	private Produto entity;
	
	private CadastroProdutoService service;
	
	@FXML
	private TextField txtId;
	
	@FXML
	private TextField txtDescricao;
	
	@FXML
	private TextField txtPreco;
	
	
	@FXML
	private Button btCadastro;
	
	@FXML
	private Button btCancel;
	
	
	public void setProduto(Produto entity) {
		this.entity = entity;
	}
	
	public void setCadastroProdutoService(CadastroProdutoService service) {
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
		//System.out.println(entity.getNome() + " " + " " + entity.getCargo() + " " +entity.getCpf() + " " + entity.getSalario());
		String path = "/home/nicolas/eclipse-workspace/ws-javafx/sistemaRestaurante/data/produtos.txt";
		service.saveOrUpdate(path, entity);
		Utils.currentStage(event).close();
		
	}
	
	private Produto getFormData() {
		Produto obj = new Produto();
		obj.setCodigo(Integer.parseInt(txtId.getText()));
		obj.setDescricao(txtDescricao.getText());
		obj.setValor(Double.parseDouble(txtPreco.getText()));
		return obj;
	}

	@FXML
	public void onBtCancelAction(ActionEvent event) {
		Utils.currentStage(event).close();
	}
	

	public void updateFormData() {
		if(entity == null)
			throw new IllegalStateException("Entity was null");
		txtId.setText(String.valueOf(entity.getCodigo()));
		txtDescricao.setText(String.valueOf(entity.getDescricao()));
		txtPreco.setText(String.valueOf(entity.getValor()));

	}
	
	@Override
	public void initialize(URL url, ResourceBundle rb) {
		initializeNodes();
	}
	
	private void initializeNodes() {

	}


}
