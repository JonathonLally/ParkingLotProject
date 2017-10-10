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
		toHelpTextArea("Default Parking Lot Created" + "\n" + " 5 Moto 20 Sedan 10 SUV 2 Buses");
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
				if (myParkingLot.addMotorCycle(new Motorcycle(plate))) {
					toHelpTextArea(plate + " Parked");
				} else {
					toHelpTextArea(plate + " Not Added, Motorcycle Parking Full");
				}
			} else if (vType.equals("Sedan")) {
				if (myParkingLot.addSedan(new Sedan(plate))) {
					toHelpTextArea(plate + " Parked");
				} else {
					toHelpTextArea(plate + " Not Parked, Sedan Parking Full");
				}
			} else if (vType.equals("SUV")) {
				if (myParkingLot.addSuv(new Suv(plate))) {
					toHelpTextArea(plate + " Parked");
				} else {
					toHelpTextArea(plate + " Not Parked, SUV parking full");
				}
			} else if (vType.equals("Bus")) {
				if(myParkingLot.addBus(new Bus(plate))) {
					toHelpTextArea(plate + " Parked");
				} else {
					toHelpTextArea(plate + " Not Parked, Bus parking full");
				}
			} else if (vType.equals(null)) {
				toHelpTextArea("Please choose a Vehicle Type");
			}
			else {
				System.out.println("Park Not working");			
			}
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
	
	public void editParkingLotSize() { //Needs a new window to pop open and ask
		myParkingLot = new ParkingLot(4, 5, 6, 3); //For now just another size
		toHelpTextArea("Parking Lot Resize" + "\n" + "4 Moto 5 Sedan 6 SUV 3 Bus");
	}	
	
	public void help() {
		toHelpTextArea("Enter a License Plate # and Vehicle Type" + "\n" + 
				"Then press Park/Unpark to add/remove");
	}

}
