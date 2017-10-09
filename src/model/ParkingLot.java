package model;

import java.util.HashMap;
import java.util.Map;

public class ParkingLot {
	private HashMap<Integer, Vehicle> hashmap;
	private int iterator;
	private int hashSize;
	
	
	public ParkingLot(int motoSpaces, int sedanSpaces, int suvSpaces, int busSpaces) {
		int total = motoSpaces + sedanSpaces + suvSpaces + busSpaces;
		hashmap = new HashMap<Integer, Vehicle>(total);
		hashSize = total;
		iterator = 1;
	}
	
	public void display() {
		System.out.println(hashmap.toString());
	}
	
	public String getDisplay() {
		String output;
		StringBuilder tempout = new StringBuilder();
		for(Map.Entry<Integer, Vehicle> entry:hashmap.entrySet()) {
			int key = entry.getKey();
			Vehicle temp = entry.getValue();
			tempout.append(key + " " + temp.toString());
		}
		output = tempout.toString();
		return output;
	}
	
	public void create(String plate, String vehicle) {
		if (vehicle.equals("Motorcycle")) {
			hashmap.put(iterator++, new Motorcycle(plate));
		} else if (vehicle.equals("Sedan")) {
			hashmap.put(iterator++, new Sedan(plate));
		} else if (vehicle.equals("SUV")) {
			hashmap.put(iterator++, new Suv(plate));
		} else if (vehicle.equals("Bus")) {
			hashmap.put(iterator++, new Bus(plate));
		}
	}	
	
	public boolean search(String search) {
		int temp = 0;
		while (temp < hashSize) {
			Vehicle tempVehicle = hashmap.get(temp);
			if (tempVehicle.getPlate().equals(search)) {
				System.out.println("Found");
				return true;
			} else {
				temp++;
			}
		}
		return false;
	}
	
	
	public void removeByNum(int input) {
		hashmap.remove(input);
	}
	

}
