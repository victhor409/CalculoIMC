package views;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.function.Consumer;

import Utils.Alerts;
import Utils.Util;
import application.Main;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;

public class LoginController implements Initializable{
	
	@FXML
	private TextField txUsuario;
	
	@FXML
	private PasswordField pfSenha;
	
	@FXML
	private Button btLogin;
	
	@FXML
	private Button btSair;
	
	
	@FXML
	public void onButtonLogin() {
		
		if (txUsuario.getText().equals("root") && pfSenha.getText().equals("master") ) {
			
			loadView("/views/CalculoIMC.fxml");
		
		}
		
		else {
			Alert alert = new Alert(AlertType.ERROR);
			
			alert.setTitle("Error");
			alert.setHeaderText("Login ou senha incorretos");
			alert.setContentText("Por favor verifique o login e senha");
			alert.show();
		}
		
	}
	
	@FXML
	public void onButtonSair(ActionEvent event) {
		Util.currentStage(event).close();
	}
	
	private void loadView(String absoluteName) {
		try {
			FXMLLoader loader = new FXMLLoader (getClass().getResource(absoluteName));
			VBox mainVBox = loader.load();
			
			Scene mainScene = Main.getMainScene();
			
			VBox newVBox = (VBox)((ScrollPane)mainScene.getRoot()).getContent();
			
			Node mainMenu = mainVBox.getChildren().get(0);
			
			newVBox.getChildren().clear();
			newVBox.getChildren().addAll(mainVBox.getChildren());
			
			
		}
		catch(IOException e) {
			Alerts.showAlert("Erro ao abrir Janela", "Error", e.getMessage(), AlertType.ERROR);
		}
	}
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		
	}

}
