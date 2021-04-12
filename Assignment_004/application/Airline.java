package application;

public class Airline {

	// declaration of variables
	private String airline ;
	private String airlineNo;
	private String depAirport;
	private String arrAirport;
	
	//constructor for the Airline class
	public Airline(String airline, String airlineNo, String depAirport, String arrAirport) {
		this.airline = airline;
		this.airlineNo = airlineNo;
		this.depAirport = depAirport;
		this.arrAirport = arrAirport;
	}

	//getter and setter for the Airline
	public String getAirline() {
		return airline;
	}


	public void setAirline(String airline) {
		this.airline = airline;
	}

	// getter and setter for the Airline No
	public String getAirlineNo() {
		return airlineNo;
	}


	public void setAirlineNo(String airlineNo) {
		this.airlineNo = airlineNo;
	}

	// getter and setter for the depAirport
	public String getDepAirport() {
		return depAirport;
	}


	public void setDepAirport(String depAirport) {
		this.depAirport = depAirport;
	}

	// getter and setter for the arrAirport
	public String getArrAirport() {
		return arrAirport;
	}


	public void setArrAirport(String arrAirport) {
		this.arrAirport = arrAirport;
	}
	
	
	
	
}

