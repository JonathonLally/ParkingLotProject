package view;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Modality;
import javafx.stage.Stage;
import model.ParkingLot;

public class ParkingLotController implements Initializable{
	
	@FXML
	private ChoiceBox<String> VehicleTypeBox;
	
	@FXML
	private Button parkButton;
	
	@FXML
	private Button unParkButton;
	
	@FXML
	private TextArea resultText;
	
	@FXML
	private TextField plateNumField;
	
	private ParkingLot myParkingLot;

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		createParkingLot();
		VehicleTypeBox.setItems(FXCollections.observableArrayList("Motorcycle", "Sedan", "SUV", "Bus")
				);		
	}
	
	public void createParkingLot() {
		myParkingLot = new ParkingLot(5,20,10,2);
	}
	
	public void exit() {
		Platform.exit();
	}
	
	public void toTextField(String input) {
		resultText.setText(input);
	}
	
	public void testTextField() {
		myParkingLot.display();
	}
	
	public void toText() {
		String temp = myParkingLot.getDisplay();
		resultText.clear();
		resultText.setText(temp.toString());
	}
	
	public String getPlate() {
		return plateNumField.getText();
	}
	
	public String getVType() {
		return VehicleTypeBox.getValue();
	}
	
	public void clearChoices() {
		plateNumField.clear();
		VehicleTypeBox.setValue(null);
	}
	
	public void Park() {
		String tempPlate = getPlate();
		String tempVehicle = getVType();
		toTextField(tempPlate + "\n" + tempVehicle);
		myParkingLot.create(tempPlate, tempVehicle);
		clearChoices();
	}
	
	public void unParkPop() {
		try {
			Parent root = FXMLLoader.load(getClass().getResource("UnParkPop.fxml"));
			Scene scene = new Scene(root);
			Stage stage = new Stage();
			stage.setScene(scene);
			stage.showAndWait();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}

}
