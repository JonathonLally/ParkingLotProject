package view;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import model.Bus;
import model.Motorcycle;
import model.ParkingLot;
import model.Sedan;
import model.Suv;

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
	private TextArea helpText;
	
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
		//Creates sample parking lot with space for 5 motorcycles, 20 sedans, 10 suvs, and 2 buses
		myParkingLot = new ParkingLot(5,20,10,2);
	}
	
	public void exit() {
		Platform.exit();
	}
	
	public void toTextField(String input) {
		resultText.setText(input);
	}
	
	public void toText() {
		resultText.clear();
		resultText.setText(myParkingLot.getDisplay());
	}
	
	public void toHelpTextArea(String input) {
		helpText.setText(input);
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
	
	public void checkBlankPlate() {
		if (getPlate().equals("")) {
			toHelpTextArea("Please enter a License Plate #");
		}
	}
	
	public void park() {
		try {
			String plate = getPlate();
			String vType = getVType();
			clearChoices();
			if (vType.equals("Motorcycle")) {
				myParkingLot.addMotorCycle(new Motorcycle(plate));
			} else if (vType.equals("Sedan")) {
				myParkingLot.addSedan(new Sedan(plate));
			} else if (vType.equals("SUV")) {
				myParkingLot.addSuv(new Suv(plate));
			} else if (vType.equals("Bus")) {
				myParkingLot.addBus(new Bus(plate));
			} else if (vType.equals(null)) {
				toHelpTextArea("Please choose a Vehicle Type");
			}
			else {
				System.out.println("Park Not working");			
			}
			toHelpTextArea(plate + " Added");
			toText();
		} catch (NullPointerException e) {
			toHelpTextArea("Please choose a Vehicle Type");
		}
		
		
	}
	

	
	public void unPark() {
		String plate = getPlate();
		myParkingLot.removeVehicle(plate);
		toHelpTextArea(plate + " Removed");
		toText();
	}
	
	
	

}
