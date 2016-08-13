package drinkManager;

import drinkTypes.Drink;
import drinkTypes.EmptyDrink;

import java.util.ArrayList;

public class DrinkMaker {

	private static DrinkMaker instance = null;

	private ArrayList<DrinkContainer> drinkLayout;
	
	private DrinkMaker () {
		buildDefaultDrinkContainers(8);
	}

    public synchronized static DrinkMaker getInstance() {
        if (instance == null) {
            return new DrinkMaker();
        }

        return instance;
    }

    public ArrayList<DrinkContainer> getDrinkLayout() {
        return drinkLayout;
    }
	
	public void buildDefaultDrinkContainers(int numberOfContainers) {
		drinkLayout = new ArrayList<DrinkContainer>();
		
		for (int i = 0; i < numberOfContainers; i++) {
			drinkLayout.add(new DrinkContainer(new EmptyDrink(i), new DrinkAmount(0.0, Unit.LITER)));
		}
	}
	
	public boolean buildDrink(DrinkRecipe recipe) {
		mixDrink();
        return true;
	}
	
	private void mixDrink() {
		// TODO Tell the PI to mix

	}

	public boolean loadDrinkContainer(DrinkContainer drinkToLoad, int containerNumber) {
        if (containerNumber < 1 || containerNumber > drinkLayout.size()) {
            return false;
        }

        drinkLayout.set(containerNumber - 1, drinkToLoad);
        return true;
	}

	public boolean refillDrinkContainer(int containerNumber) {
        if (containerNumber < 1 || containerNumber > drinkLayout.size()) {
            return false;
        }

		drinkLayout.get(containerNumber - 1).setCurrentAmount(drinkLayout.get(containerNumber - 1).getSize());

        return true;
	}
	
	public boolean containsDrink(Drink drink) {
		for (DrinkContainer dc : drinkLayout) {
			if (drink.equals(dc.getDrink())) {
				return true;
			}
		}
		return false;
	}

	public boolean hasRequiredAmount(Drink d, Double amount) {
		//TODO need scaling
		return true;
	}

}
