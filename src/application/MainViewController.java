package application;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import gui.util.Alerts;
import gui.util.Utils;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.layout.Pane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import model.entities.Cliente;
import model.entities.Funcionario;
import model.entities.Pedido;
import model.entities.Produto;
import model.services.CadastroClienteService;
import model.services.CadastroFuncionarioService;
import model.services.CadastroPedidoService;
import model.services.CadastroProdutoService;

public class MainViewController implements Initializable{

	@FXML
	private ComboBox<String> comboBoxOpcoes;
	
	
	private ObservableList<String> obsOpcoes;
	
	@FXML
	private Button opcaoButton;
	
	@FXML
	public void onOpcaoButtonAction(ActionEvent event) {
		
		String opcao = comboBoxOpcoes.getSelectionModel().getSelectedItem();
		System.out.println(opcao);
		Stage parentStage = Utils.currentStage(event);
		Cliente obj = new Cliente();
		Funcionario fcr = new Funcionario();
		Produto prdt = new Produto();
		Pedido pdo = new Pedido();
		if(opcao=="Cadastrar cliente") 
			createDialogFormCadastroCliente(obj, "/gui/FormularioCadastro.fxml", parentStage);
		else if(opcao=="Cadastrar funcionário") 
			createDialogFormCadastroFuncionario(fcr, "/gui/CadastroFuncionario.fxml", parentStage);
		else if(opcao=="Cadastrar produto")
			createDialogFormCadastroProduto(prdt, "/gui/CadastroProduto.fxml", parentStage);
		else if(opcao=="Fazer pedido")
			createDialogFormPedido(pdo, "/gui/CadastroPedido.fxml", parentStage);
	}
	
	@Override
	public void initialize(URL uri, ResourceBundle rb) {
		List<String> opcoes = new ArrayList<>();
		opcoes.add("Cadastrar cliente");
		opcoes.add("Cadastrar funcionário");
		opcoes.add("Cadastrar produto");
		opcoes.add("Cadastrar despesa");
		opcoes.add("Fazer pedido");
		obsOpcoes = FXCollections.observableArrayList(opcoes);
		comboBoxOpcoes.setItems(obsOpcoes);
	}
	
	private void createDialogFormCadastroCliente(Cliente obj, String absoluteName, Stage parentStage) {
		try {
			FXMLLoader loader = new FXMLLoader(getClass().getResource(absoluteName));
			Pane pane  = loader.load();
			
			FormularioCadastroClienteController controller = loader.getController();
			controller.setCliente(obj);
			controller.setCadastroClienteService(new CadastroClienteService());
			controller.updateFormData();
				
			Stage dialogStage = new Stage();
			dialogStage.setTitle("Cadastro de Cliente");
			dialogStage.setScene(new Scene(pane));
			dialogStage.setResizable(false);
			dialogStage.initOwner(parentStage);
			dialogStage.initModality(Modality.WINDOW_MODAL);
			dialogStage.showAndWait();
			
			
		}
		catch(IOException e){
			Alerts.showAlert("IO Exception", "Error loading view", e.getMessage() , AlertType.ERROR);

		}
	}
	
	private void createDialogFormCadastroFuncionario(Funcionario obj, String absoluteName, Stage parentStage) {
		try {
			FXMLLoader loader = new FXMLLoader(getClass().getResource(absoluteName));
			Pane pane  = loader.load();
			
			CadastroFuncionarioController controller = loader.getController();
			controller.setFuncionario(obj);
			controller.setCadastroFuncionarioService(new CadastroFuncionarioService());
			controller.updateFormData();
				
			Stage dialogStage = new Stage();
			dialogStage.setTitle("Cadastro de Funcionario");
			dialogStage.setScene(new Scene(pane));
			dialogStage.setResizable(false);
			dialogStage.initOwner(parentStage);
			dialogStage.initModality(Modality.WINDOW_MODAL);
			dialogStage.showAndWait();
			
			
		}
		
		catch(IOException e){
			Alerts.showAlert("IO Exception", "Error loading view", e.getMessage() , AlertType.ERROR);

		}
	}
	
	private void createDialogFormCadastroProduto(Produto obj, String absoluteName, Stage parentStage) {
		try {
			
			FXMLLoader loader = new FXMLLoader(getClass().getResource(absoluteName));
			Pane pane  = loader.load();
			
			CadastroProdutoController controller = loader.getController();
			controller.setProduto(obj);
			controller.setCadastroProdutoService(new CadastroProdutoService());
			controller.updateFormData();
				
			Stage dialogStage = new Stage();
			dialogStage.setTitle("Cadastro de Produto");
			dialogStage.setScene(new Scene(pane));
			dialogStage.setResizable(false);
			dialogStage.initOwner(parentStage);
			dialogStage.initModality(Modality.WINDOW_MODAL);
			dialogStage.showAndWait();
			
			
		}
		
		catch(IOException e){
			Alerts.showAlert("IO Exception", "Error loading view", e.getMessage() , AlertType.ERROR);

		}
	}
	
	private void createDialogFormPedido(Pedido obj, String absoluteName, Stage parentStage) {
		try {
			
			FXMLLoader loader = new FXMLLoader(getClass().getResource(absoluteName));
			Pane pane  = loader.load();
			
			CadastroPedidoController controller = loader.getController();
			controller.setPedido(obj);
			controller.setCadastroPedidoService(new CadastroPedidoService());
			controller.updateFormData();
				
			Stage dialogStage = new Stage();
			dialogStage.setTitle("Relizar Pedido");
			dialogStage.setScene(new Scene(pane));
			dialogStage.setResizable(false);
			dialogStage.initOwner(parentStage);
			dialogStage.initModality(Modality.WINDOW_MODAL);
			dialogStage.showAndWait();
			
			
		}
		
		catch(IOException e){
			Alerts.showAlert("IO Exception", "Error loading view", e.getMessage() , AlertType.ERROR);
		}
	}

}
