package model;

public class ParkingSpace {
	
	private static int parkingSpaceNumberCount;
	private int parkingSpaceNumber;
	private Vehicle parkedVehicle;
	
	public ParkingSpace (Vehicle vehicle) {
		this.parkedVehicle = vehicle;
		
	}

	public Vehicle getVehicle() {
		return parkedVehicle;
	}

}
