package drinkTypes;


public class AlcoholicDrink extends Drink {
	private double proof;
	private AlcoholType alcoholType;
	
	public AlcoholicDrink(String drinkName, int calories, double proof, AlcoholType alcoholType) {
		super.name = drinkName;
		super.calories = calories;
		this.alcoholType = alcoholType;
		this.proof = proof;
	}
	
	public boolean equals(Object o) {
		if (o == null || o.getClass() != this.getClass()) {
			return false;
		} 
		
		AlcoholicDrink object = (AlcoholicDrink) o;
		
		if (this.name.equals(object.name) || this.alcoholType == object.alcoholType) {
			return true;
		}
		
		return false;
	}
	
	public String toString() {
		return name + " - " + alcoholType.toString();
	}
	
	public double getProof() {
		return proof;
	}

	public AlcoholType getAlcoholType() {
		return alcoholType;
	}
}
