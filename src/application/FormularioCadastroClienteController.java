package application;


import java.net.URL;
import java.util.ResourceBundle;

import gui.util.Utils;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import model.entities.Cliente;
import model.services.CadastroClienteService;

public class FormularioCadastroClienteController implements Initializable{
	
	private Cliente entity;
	
	private CadastroClienteService service;
	
	@FXML
	private TextField txtNome;
	
	@FXML
	private TextField txtCpf;
	
	@FXML
	private Label labelErrorName;
	
	@FXML
	private Button btCadastro;
	
	@FXML
	private Button btCancel;
	
	
	public void setCliente(Cliente entity) {
		this.entity = entity;
	}
	
	public void setCadastroClienteService(CadastroClienteService service) {
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
		String path = "/home/nicolas/eclipse-workspace/ws-javafx/sistemaRestaurante/data/clientes.txt";
		service.saveOrUpdate(path, entity);
		Utils.currentStage(event).close();
		
	}
	
	private Cliente getFormData() {
		Cliente obj = new Cliente();
		obj.setNome(txtNome.getText());
		obj.setCpf(txtCpf.getText());
		
		return obj;
	}

	@FXML
	public void onBtCancelAction(ActionEvent event) {
		Utils.currentStage(event).close();
	}
		
	@Override
	public void initialize(URL url, ResourceBundle rb) {
		initializeNodes();
	}
	
	private void initializeNodes() {

	}
	
	public void updateFormData() {
		if(entity == null)
			throw new IllegalStateException("Entity was null");
		txtNome.setText(String.valueOf(entity.getNome()));
		txtCpf.setText(String.valueOf(entity.getCpf()));

	}
	

}
