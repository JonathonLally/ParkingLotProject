package model;

public class ParkingSpace {
	
	private static int parkingSpaceNumberCount;
	private String parkingSpaceNumber;
	private Vehicle parkedVehicle;
	private String parkingSpaceSize;
	
	public ParkingSpace (Vehicle vehicle) {
		this.parkedVehicle = vehicle;
		//parkingSpaceNumber = getParkingSpaceNumber();
		//TODO clean this class up when its finished
	}
	
	public ParkingSpace (Vehicle vehicle, String size) {
		this.parkedVehicle = vehicle;
		//parkingSpaceNumber = getParkingSpaceNumber();
		parkingSpaceSize = size;
	}
	
	public ParkingSpace (String spaceNum, String size) {
		parkingSpaceNumber = spaceNum;
		parkingSpaceSize = size;
	}
	
	public int getParkingSpaceNumber() {
		return parkingSpaceNumberCount++;
	}

	public Vehicle getVehicle() {
		return parkedVehicle;
	}
	
	public String getSpaceNumber() {
		return parkingSpaceNumber;
	}
	
	public String getParkingSpaceSize() {
		return parkingSpaceSize;
	}

	@Override
	public String toString() {
		return "ParkingSpace [parkingSpaceNumber=" + parkingSpaceNumber + ", parkedVehicle=" + parkedVehicle
				+ ", parkingSpaceSize=" + parkingSpaceSize + "]";
	}

}
