package model;

public class ParkingSpace {
	
	private String spacePlate;
	private Vehicle vType;
	
	public ParkingSpace (Vehicle vehicle, String plate) {
		this.vType = vehicle;
		this.spacePlate = plate;
		
	}

	public String getPlate() {
		return spacePlate;
	}
	
	public Vehicle getVehicle() {
		return vType;
	}

}
