package model;

public class ParkingSpace {
	
	private static int parkingSpaceNumberCount;
	private int parkingSpaceNumber;
	private Vehicle parkedVehicle;
	
	public ParkingSpace (Vehicle vehicle) {
		this.parkedVehicle = vehicle;
		parkingSpaceNumber = getParkingSpaceNumber();
		
	}
	
	public int getParkingSpaceNumber() {
		return parkingSpaceNumberCount++;
	}

	public Vehicle getVehicle() {
		return parkedVehicle;
	}
	
	public int getSpaceNumber() {
		return parkingSpaceNumber;
	}

}
