package application;

import java.net.URL;
import java.util.ArrayList;
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
import model.entities.Funcionario;
import model.entities.Garcom;
import model.services.CadastroFuncionarioService;

public class CadastroFuncionarioController implements Initializable{
	
	private Funcionario entity;
	
	private CadastroFuncionarioService service;
	
	@FXML
	private ComboBox<String> comboBoxOpcoes;
	
	
	private ObservableList<String> obsOpcoes;
	
	@FXML
	private TextField txtNome;
	
	@FXML
	private TextField txtCpf;
	
	@FXML
	private TextField txtSalario;
	
	
	@FXML
	private Button btCadastro;
	
	@FXML
	private Button btCancel;
	
	
	public void setFuncionario(Funcionario entity) {
		this.entity = entity;
	}
	
	public void setCadastroFuncionarioService(CadastroFuncionarioService service) {
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
		System.out.println(entity.getNome() + " " + " " + entity.getCargo() + " " +entity.getCpf() + " " + entity.getSalario());
		String path = "/home/nicolas/eclipse-workspace/ws-javafx/sistemaRestaurante/data/funcionarios.txt";
		
		String cargo = comboBoxOpcoes.getSelectionModel().getSelectedItem();
		if(cargo=="Garçom") 
			service.saveOrUpdateGarcom(path, (Garcom)entity);
		else
			service.saveOrUpdateFuncionario(path, entity);
	
		Utils.currentStage(event).close();
		
	}
	
	private Funcionario getFormData() {
		Funcionario obj;
		String cargo = comboBoxOpcoes.getSelectionModel().getSelectedItem();
		if(cargo=="Garçom") 
			obj = new Garcom(txtNome.getText(), cargo, txtCpf.getText(), Double.parseDouble(txtSalario.getText()), 0);
		
		else
			obj = new Funcionario(txtNome.getText(), cargo, txtCpf.getText(), Double.parseDouble(txtSalario.getText()));
		
		return obj;
	}

	@FXML
	public void onBtCancelAction(ActionEvent event) {
		Utils.currentStage(event).close();
	}
		
	@Override
	public void initialize(URL uri, ResourceBundle rb) {
		List<String> opcoes = new ArrayList<>();
		opcoes.add("Garçom");
		opcoes.add("Gerente");
		opcoes.add("Cozinheiro");
		obsOpcoes = FXCollections.observableArrayList(opcoes);
		comboBoxOpcoes.setItems(obsOpcoes);
		
	}
	
	

	
	public void updateFormData() {
		if(entity == null)
			throw new IllegalStateException("Entity was null");
		txtNome.setText(String.valueOf(entity.getNome()));
		txtCpf.setText(String.valueOf(entity.getCpf()));
		txtSalario.setText(String.valueOf(entity.getSalario()));

	}

}
