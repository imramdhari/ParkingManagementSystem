package parkingManagementSystem;



/**
 * @author kkeogh
 * @version 1.0
 * @created 21-Sep-2018 4:55:33 PM
 */
public class Motorbike extends Vehicle {
	private static int nextRegistrationID=0;
	private static final double INITREGFEE = 175.0;

	public Motorbike(String _model, int _age){
		super(_model, _age);
	}

	public double getFee(){
		return Motorbike.INITREGFEE;
	}
	
	private void assignRegistrationID(){
		String numString ="";
		int num = Motorbike.nextRegistrationID++;  // get next available motorbike registration id
		if (num < 10) 
			numString = "000" + String.valueOf(num);  // add leading 000 if Motorbike registration id is 0..9
		else if (num < 100)
			numString = "00" + String.valueOf(num);   // add leading 00 if Motorbike registration id is 10..99
		else if (num < 1000)
			numString = "0" + String.valueOf(num);    // add leading 0 if Motorbike registration id is 100..999
		else 
			numString = String.valueOf(num); 
		super.assignRegistrationID("MB" + numString);
	}

	public double calcRegistrationFee(){
		return 0;
	}

	@Override
	public boolean isValid() {
		// TODO complete the code here
		boolean result = false;
		return result;
	}
}//end Motorbike