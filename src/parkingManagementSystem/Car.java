package parkingManagementSystem;

/**
 * @author kkeogh
 * @version 1.0
 * @created 21-Sep-2018 4:55:05 PM
 */
public class Car extends Vehicle {
	private static int nextRegistrationID = 0;

	private static final double INITREGFEE = 0.0;
	// add attribute to store this Car's unique vehicle on-road registration ID
	
	private static String[] restrictedVehicleList = {"Truck", "Van" ,"Foton Light Truck" , "Wuling Hongguang"   }; // update list of restricted vehicles

	private String assignRegistrationID;
	
	public Car(String _model, int _age){
		super(_model, _age);
		this.assignRegistrationID();
	}

	
	public double getFee(){
		return Car.INITREGFEE;
	}
	
	private void assignRegistrationID(){ // assign a unique ID for each Car
		// calculate a unique registration ID  for each Car
		String numString ="";
		int num = Car.nextRegistrationID++;  // get next available Car registration id
		//create the student ID with the 2019 and if necessary a leading 0, need to convert num to a string object
		if (num < 10) 
			numString = "000" + String.valueOf(num);  // add leading 000 if Car registration id is 0..9
		else if (num < 100)
			numString = "00" + String.valueOf(num);   // add leading 00 if Car registration id is 10..99
		else if (num < 1000)
			numString = "0" + String.valueOf(num);    // add leading 0 if Car registration id is 100..999
		else 
			numString = String.valueOf(num); 
		super.assignRegistrationID("CAR" + numString);
		System.out.println("this is car id"+this.assignRegistrationID);	
	}

	
	
	@Override 
	public boolean isValid() {    // check if the car is valid for registration - must not be in restrictedVehicleList
		String m;
		for (int i=0; i < restrictedVehicleList.length; i++)  {
				m=restrictedVehicleList[i];   // if the car model is the same as any of the models in the restricted vehicle list it is not valid to register
				if (this.getModel().equalsIgnoreCase(m))
					return false;
			}
		return true;
//loop through the restrictedVehicleList and if find this car model, then return false, otherwise return true
	}


	
	
	public String toString() {
		System.out.println("this is car id"+this.assignRegistrationID);	
		return "Car ";
	}
	
}//end Car