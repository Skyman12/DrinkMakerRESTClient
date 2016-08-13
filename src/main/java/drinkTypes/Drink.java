package drinkTypes;

public abstract class Drink {
	// The name of the drink
	protected String name;

	// Calories of the drink per 12 ounces
	protected int calories;
	
	public boolean equals(Object o) {
		
		if (o == null || o.getClass() != this.getClass()) {
			return false;
		} 
		
		Drink object = (Drink) o;
		
		if (this.name.equals(object.name)) {
			return true;
		}
		
		return false;
	}
	
	public String toString() {
		return name;
	}

	public String getName() {
		return name;
	}

	public int getCalories() {
		return calories;
	}
	
}
