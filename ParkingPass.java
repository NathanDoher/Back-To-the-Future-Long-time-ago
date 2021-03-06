
public class ParkingPass extends Service{
	
	private double parkingFee;

	// Constructor
	public ParkingPass(String productCode, String productType, double parkingFee) {
		super(productCode, productType);
		this.parkingFee = parkingFee;
	}

	
	// setters
	public void setParkingFee(double parkingFee) {
		this.parkingFee = parkingFee;
	}

	
	// getters
	
	public double getParkingFee() {
		return this.parkingFee;
	}


	@Override
	public double getSubtotal(String currentDate) {
		return this.parkingFee*this.getUnits();
	}


	@Override
	public double getTax(String currentDate) {
		return this.parkingFee * .04 * this.getUnits();
	}
	public double getTax() {
		return this.parkingFee * .04 * this.getUnits();
	}

	@Override
	public double getTotal(String currentDate) {
		return this.getSubtotal(currentDate) + this.getTax(currentDate);
	}
	
	
	//fixed cost
	@Override
	public ParkingPass returnItself() {
		return this;
	}
	
	public double getTotal(int numberMovieTickets) {
		
		return this.getSubtotal(numberMovieTickets) + this.getTax(numberMovieTickets);
	}
	
	public double getSubtotal(int numberMovieTickets) {
		return numberMovieTickets * this.parkingFee;
	}
	public double getTax(int x) {
		return getSubtotal(x) * .04;
	}
}
