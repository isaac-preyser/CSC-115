public class AutomaticCar implements Vehicle {
	private String model;
	private int distanceTraveled;
	private boolean seatbeltsOn;

	public AutomaticCar(String model, int distanceTraveled){
		this.model = model;
		this.distanceTraveled = distanceTraveled;
		seatbeltsOn = false;
	}

	// What is missing?
	public void drive(int d){
		if (safetyCheck()){	
			this.distanceTraveled += d;
			System.out.println("Driving: "+ d + " kms.");
		} else{
			//PUT YOUR FRICKING SEAT BELT ON 
			System.out.println("No seatbelt. womp womp :(");
		}
		
		
		return;
		
	}

	public boolean safetyCheck(){
		return seatbeltsOn; //ternary operator? 
	}

	public void putOnSeatbelt(){
		seatbeltsOn = true; 
		return;
	}

	public void takeOffSeatbelt(){
		seatbeltsOn = false; 
		return; 
	}

	public int getKMs() {
		return distanceTraveled;
	}

}
