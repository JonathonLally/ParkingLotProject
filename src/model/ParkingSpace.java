package model;

public class ParkingSpace {
	
	private Vehicle parkedVehicle;
	private String parkingSpaceSize;
	private String parkingSpaceNumber;
	
	public ParkingSpace (Vehicle vehicle) {
		this.parkedVehicle = vehicle;
	}
	
	public ParkingSpace (Vehicle vehicle, String size) {
		this.parkedVehicle = vehicle;
		parkingSpaceSize = size;
	}
	
	public ParkingSpace (String spaceNum, String size) {
		parkingSpaceNumber = spaceNum;
		parkingSpaceSize = size;
	}

	public Vehicle getVehicle() {
		return parkedVehicle;
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
