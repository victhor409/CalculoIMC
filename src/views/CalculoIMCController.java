package views;

import java.io.IOException;

import Utils.Alerts;
import entities.IMC;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;

public class CalculoIMCController {
	
	@FXML
	private TextField txNome;
	
	@FXML
	private TextField txIdade;
	
	@FXML
	private TextField txAltura;
	
	@FXML
	private TextField txPeso;
	
	
	@FXML
	private Button calcular;
	
	@FXML
	private Text txResultado;
	
	//Metodo que calcula o IMC
	
	public void onBtCalcular(ActionEvent event) {
		
		
		Double IMC;//variavel para guardat o resultado
		Double peso = Double.parseDouble(txPeso.getText());//converte o valor double para String
		Double altura = Double.parseDouble(txAltura.getText());
		
		
		
		 IMC = peso / (altura * altura);
		
		txResultado.setText(String.valueOf(IMC));// comando para guardar o resultado
		
	
		
	}
	
	
	

}
