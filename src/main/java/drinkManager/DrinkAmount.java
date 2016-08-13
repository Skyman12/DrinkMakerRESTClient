package drinkManager;

public class DrinkAmount {

	private Double amount;
	private Unit unit;
	
	public DrinkAmount (Double amount, Unit unit) {
		this.amount = amount;
		this.unit = unit;
	}

	public Double getAmount() {
		return amount;
	}

	public Unit getUnit() {
		return unit;
	}
	
	// Returns the amount in ounces
	public Double getStandardAmount() {
		if (unit == Unit.LITER) {
			return amount * 33.814;
		} else {
			return amount;
		}
	}
	
	public String toString() {
		return amount.toString() + " " + unit.toString();
	}

	public DrinkAmount copy() {
		return new DrinkAmount(this.getAmount(), this.getUnit());
	}

}
