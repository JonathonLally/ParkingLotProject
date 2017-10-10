package model;

import java.util.HashMap;
import java.util.Map.Entry;
import java.util.Stack;

public class ParkingLot {
	private HashMap<String, ParkingSpace> hashmap;
	private Stack<Motorcycle> motorcycleStack;
	private Stack<Sedan> sedanStack;
	private Stack<Suv> suvStack;
	private Stack<Bus> busStack;
	private int motorcycleStackSize;
	private int sedanStackSize;
	private int suvStackSize;
	private int busStackSize;
	private int currentMotoStackItem;
	private int currentSedanStackItem;
	private int currentSuvStackItem;
	private int currentBusStackItem;
	
	
	
	
	public ParkingLot(int motoSpaces, int sedanSpaces, int suvSpaces, int busSpaces) {
		motorcycleStack = new Stack<Motorcycle>();
		sedanStack = new Stack<Sedan>();
		suvStack = new Stack<Suv>();
		busStack = new Stack<Bus>();
		hashmap = new HashMap<String, ParkingSpace>();
		motorcycleStackSize = motoSpaces;
		sedanStackSize = sedanSpaces;
		suvStackSize = suvSpaces;
		busStackSize = busSpaces;
		currentMotoStackItem = 0;
		currentSedanStackItem = 0;
		currentSuvStackItem = 0;
		currentBusStackItem = 0;
	}
	
	public boolean checkForOpenMotorcycleSpots() {
		if (currentMotoStackItem < motorcycleStackSize) {
			return true;
		}
		else {
			return false;
		}
	}
	
	public boolean checkForOpenSedanSpots() {
		if (currentSedanStackItem < sedanStackSize) {
			return true;
		}
		else {
			return false;
		}
	}
	
	public boolean checkForOpenSuvSpots() {
		if (currentSuvStackItem < suvStackSize) {
			return true;
		}
		else {
			return false;
		}
	}
	
	public boolean checkForOpenBusSpots() {
		if (currentBusStackItem < busStackSize) {
			return true;
		}
		else {
			return false;
		}
	}
	
	public void addMotorCycle(Motorcycle motorcycle) {
		if (checkForOpenMotorcycleSpots()) {
			motorcycleStack.push(motorcycle);
			currentMotoStackItem++; //TODO
			hashmap.put(motorcycle.getPlate(), new ParkingSpace(motorcycle)); //Fix this to find next parking space
		} else {
			System.out.println("Motorcycle Stack is full");
		}
	}
	
	public void addSedan(Sedan sedan) {
		if (checkForOpenSedanSpots()) {
			sedanStack.push(sedan);
			currentSedanStackItem++; //TODO
			hashmap.put(sedan.getPlate(), new ParkingSpace(sedan)); //Fix this to find next parking space
		} else {
			System.out.println("Sedan Stack is full");
		}
	}
	
	public void addSuv(Suv suv) {
		if (checkForOpenSuvSpots()) {
			suvStack.push(suv);
			currentSuvStackItem++; //TODO
			hashmap.put(suv.getPlate(), new ParkingSpace(suv)); //Fix this to find next parking space
		} else {
			System.out.println("Suv Stack is full");
		}
	}
	
	public void addBus(Bus bus) {
		if (checkForOpenBusSpots()) {
			busStack.push(bus);
			currentBusStackItem++; //TODO
			hashmap.put(bus.getPlate(), new ParkingSpace(bus)); //Fix this to find next parking space
		} else {
			System.out.println("Bus Stack is full");
		}
	}
	
	public void removeVehicle(String key) {
		try {
			Vehicle temp = hashmap.get(key).getVehicle();
			System.out.println("Vehicle has been found : " + temp.toString()); //Remove eventually
			removeFromStack(temp);
			hashmap.remove(key);
		} catch (NullPointerException e) {
			System.out.println("Not a valid key");
		}
	}
	
	public void removeFromStack(Vehicle vehicle) {
		Vehicle temp = vehicle;
		System.out.println("Vehicle to be removed" + vehicle.toString()); //Remove eventually
		if (temp.getType().equals("Motorcycle")) {
			motorcycleStack.pop();
			currentMotoStackItem--;
		} else if (temp.getType().equals("Sedan")) {
			sedanStack.pop();
			currentSedanStackItem--;
		} else if (temp.getType().equals("SUV")) {
			suvStack.pop();
			currentSuvStackItem--;			
		} else if (temp.getType().equals("Bus")) {
			busStack.pop();
			currentBusStackItem--;			
		}
		
		
	}
	
	public String display() { //Make this nice at some point TODO
		return hashmap.values().toString();
	}
	
	public String getDisplay() {
		String output;
		StringBuilder tempout = new StringBuilder();
		for(Entry<String, ParkingSpace> entry:hashmap.entrySet()) {
			String key = entry.getKey();
			Vehicle temp = entry.getValue().getVehicle();
			tempout.append(key + " " + temp.toString());
		}
		output = tempout.toString();
		return output;
	}
	
	public void getNextAvailableParkingSpace() { //TODO
		
	}
	

}
