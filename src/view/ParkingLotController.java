package view;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class ParkingLotController implements Initializable{
	
	@FXML
	private ChoiceBox<String> VehicleTypeBox;
	
	@FXML
	private Button parkButton;
	
	@FXML
	private TextArea resultText;
	
	@FXML
	private TextField plateNumField;

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		VehicleTypeBox.setItems(FXCollections.observableArrayList("Motorcycle", "Sedan", "SUV", "Bus")
				);
		
	}

}
