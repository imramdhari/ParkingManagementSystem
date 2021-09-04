package parkingManagementSystem;

/**
 * @author kkeogh
 * @version 1.0
 * @created 21-Sep-2018 4:55:46 PM
 */
public class Student  {

	private String name;  // name of person
	private String address; // address of person
	private String postcode; // postcode of person's address
	private String studentID; // unique student ID
	private Course courseEnrolledIn; // course this student is enrolled in
	private Vehicle myVehicle;  // vehicle owned by this student
	private static int nextstudentNum = 0;  // static variable on class that will be used to generate unique student number for each student instance 
	private int yearNo;   // how many years has myVehicle been registered prior to now?
	/**
	 * 
	 * @param _name
	 * @param _address
	 * @param _postcode
	 * @param _courseEnrolledIn
	 * @param _phoneNo
	 * @param _myRatePayer
	 * @param _yearNo
	 */	
	public Student(String _name, String _address, String _postcode, Course _courseEnrolledIn, Vehicle _myVehicle , int _yearNo ){
		this.setName(_name);
		this.setAddress(_address);
		this.setPostcode(_postcode);
		this.enrolInCourse(_courseEnrolledIn);
		this.myVehicle = _myVehicle;
		this.setStudentID();
		this.yearNo = _yearNo;
	}

	/**
	 * 
	 * @param _name
	 * @param _address
	 * @param _postcode
	 * @param _phoneNo
	 * @param _myRatePayer
	 * @param _myVehicle
	 * @param _yearNo
	 */
	public Student(String _name, String _address, String _postcode, String _phoneNo, Vehicle _myVehicle , int _yearNo){
		this.setName(_name);
		this.setAddress(_address);
		this.setPostcode(_postcode);
		this.courseEnrolledIn = null;
		this.myVehicle = _myVehicle;
		this.setStudentID();
		this.yearNo = _yearNo;

	}
	
	/**
	 * 
	 * @param _name
	 * @param _address
	 * @param _postcode
	 * @param _phoneNo
	 * @param _myRatePayer
	 * @param _yearNo
	 */
	public Student(String _name, String _address, String _postcode, String _phoneNo , int _yearNo){
		this.setName(_name);
		this.setAddress(_address);
		this.setPostcode(_postcode);
		this.courseEnrolledIn = null;
		this.myVehicle = null;
		this.setStudentID();
		this.yearNo = 0 ;
	}
	

	private void setStudentID() { 
		// generate next valid unique student ID based on format 2018nn where nn is 0 for first student and increments for subsequent students
		// get next student number available, num for unique ID
		
		//create the student ID with the 2019 and if necessary a leading 0, need to convert num to a string object numString
		// calculate a unique registration ID  for each bicycle
		String numString="";
		int num = Student.nextstudentNum++;  // get next student number
		//create the student ID with the 2018 and if necessary a leading 0, need to convert num to a string object
		if (num < 10) 
			numString = "0" + String.valueOf(num);  // add leading 0 if student num is 0..9
		else
			numString = String.valueOf(num); 
		
		this.studentID = "2018" + numString;    // "2019" + numString;
		System.out.println("this is student id"+this.studentID);
		
	}



	private void setPostcode(String _postcode) {
		// save _postcode to the postcode attribute on this Student
		this.postcode = _postcode;
	}


	private void setAddress(String _address) {
		// save _address to the address attribute on this Student
		this.address = _address;
	}


	private void setName(String _name) {
		// save _name to the name attribute on this Student
		this.name = _name;
	}

	public String getName() {
		// get the name of this student
		return this.name;
	}
	
	public void enrolInCourse(Course _aCourse){
		boolean ok = _aCourse.enrolInCourse(this); 	// enrol this student in the given course: _aCourse
		// tell the course object to add this student to the student list
		if (ok) 	// if all was fine with enrolment in the course,
		// save the course object in this student's courseEnrolledIn attribute
			this.courseEnrolledIn = _aCourse; 
	}

	public String generateCourseInvoice(){
		return "";
	}

	
	private boolean hasRegisteredVehicle() {
		return (this.myVehicle!=null);
	}
	
	boolean registerVehicle(Vehicle _vehicle) {
		if (_vehicle.isValid()) { // validate if this vehicle is permitted to be registered
			this.myVehicle = _vehicle;
			return true;
			}
		else return false;
	
	}
	
	private Vehicle getMyVehicle() {
		return this.myVehicle;
	}




	public String generateRegistrationInvoice() {
		if (this.hasRegisteredVehicle())
			return " Invoice for parking registration :  " + this.getMyVehicle().calcRegistrationFee(this.yearNo);
		else
			return " No vehicle registered ";
	// TODO complete this method - calculate the fees and create an invoice as a string
		
	}

	public String toString() {
		String details = "Student " + this.name + " of " + this.address + ", " + this.postcode+ " "+this.studentID;
		if (this.courseEnrolledIn != null) 
			details = details + " is enrolled in " + this.courseEnrolledIn.getName();
		if (this.hasRegisteredVehicle()) 
			details = details + " has registered the following vehicle for parking " + this.myVehicle.toString();
		return details;
	}


	
	
	
}//end Student