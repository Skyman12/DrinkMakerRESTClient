package defaultConfiguration;

import drinkManager.*;
import drinkTypes.AlcoholType;
import drinkTypes.AlcoholicDrink;
import drinkTypes.Drink;
import drinkTypes.MixerDrink;

import java.util.HashMap;
import java.util.Map;

public class DefaultDrinkInitializer {
	
	public static Map<String, Drink> buildDefaultDrinks () {
		Map<String, Drink> drinkMap = new HashMap<String, Drink>();
		drinkMap.putAll(buildDefaultAlcoholicDrinks());
		drinkMap.putAll(buildDefaultMixers());
		return drinkMap;
	}
	
	private static Map<String, Drink> buildDefaultAlcoholicDrinks() {
		Map<String, Drink> drinkMap = new HashMap<String, Drink>();
		
		drinkMap.put("Captain Morgan - " + AlcoholType.RUM, new AlcoholicDrink("Captain Morgan", 10, 70.0, AlcoholType.RUM));
		drinkMap.put("Admiral Nelson - " + AlcoholType.RUM, new AlcoholicDrink("Admiral Nelson", 15, 70.0, AlcoholType.RUM));
		drinkMap.put("Smirnoff - " + AlcoholType.VODKA, new AlcoholicDrink("Smirnoff", 10, 80.0, AlcoholType.VODKA));
		drinkMap.put("5 O'clock - " + AlcoholType.VODKA, new AlcoholicDrink("5 O'clock", 12, 80.0, AlcoholType.VODKA));
		drinkMap.put("Seagram - " + AlcoholType.GIN, new AlcoholicDrink("Seagram", 11, 80.0, AlcoholType.GIN));
		drinkMap.put("Seagram - " + AlcoholType.WHISKEY, new AlcoholicDrink("Seagram", 10, 80.0, AlcoholType.WHISKEY));
		drinkMap.put("Black Velvet - " + AlcoholType.WHISKEY, new AlcoholicDrink("Black Velvet", 10, 80.0, AlcoholType.WHISKEY));
		drinkMap.put("Jaegermister - " + AlcoholType.JAEGER, new AlcoholicDrink("Jaegermister", 10, 70.0, AlcoholType.JAEGER));
		drinkMap.put("Jose - " + AlcoholType.TEQUILLA, new AlcoholicDrink("Jose", 10, 70.0, AlcoholType.TEQUILLA));
		
		return drinkMap;
	}
	
	private static Map<String, Drink> buildDefaultMixers() {
		Map<String, Drink> drinkMap = new HashMap<String, Drink>();
		
		// Pop
		drinkMap.put("Coke", new MixerDrink("Coke", 20));
		drinkMap.put("Pepsi", new MixerDrink("Pepsi", 22));
		drinkMap.put("Sprite", new MixerDrink("Sprite", 30));
		drinkMap.put("7 Up", new MixerDrink("7 Up", 30));
		drinkMap.put("Orange Fanta", new MixerDrink("Orange Fanta", 10));
		drinkMap.put("Root Beer", new MixerDrink("Root Beer", 14));
		drinkMap.put("Mt Dew", new MixerDrink("Mt Dew", 11));
		drinkMap.put("Canadian Dry", new MixerDrink("Canadian Dry", 18));
		
		// Juices
		drinkMap.put("Orange Juice", new MixerDrink("Orange Juice", 17));
		drinkMap.put("Cranberry Juice", new MixerDrink("Cranberry Juice", 12));
		drinkMap.put("Lemonade", new MixerDrink("Lemonade", 11));
		
		// Other
		drinkMap.put("Tonic", new MixerDrink("Tonic", 25));
		drinkMap.put("Sour", new MixerDrink("Sour", 16));
				
		return drinkMap;
	}
	
	public static Map<String, DrinkRecipe> buildDefaultRecipes (Map<String, Drink> drinkMap) {
		Map<String, DrinkRecipe> recipeMap = new HashMap<String, DrinkRecipe>();
		
		// Captain Coke
		String drinkName = "Captain Coke";
		Map<Drink, DrinkAmount> ingredientMap = new HashMap<Drink, DrinkAmount>();
		ingredientMap.put(drinkMap.get("Captain Morgan - RUM"), new DrinkAmount(70.0, Unit.PERCENT));
		ingredientMap.put(drinkMap.get("Coke"), new DrinkAmount(30.0, Unit.PERCENT));
		
		recipeMap.put(drinkName, new DrinkRecipe(drinkName, ingredientMap));
		
		// Smirnoff 7's
		drinkName = "Smirnoff 7";
		ingredientMap = new HashMap<Drink, DrinkAmount>();
		ingredientMap.put(drinkMap.get("Smirnoff - VODKA"), new DrinkAmount(30.0, Unit.PERCENT));
		ingredientMap.put(drinkMap.get("7 Up"), new DrinkAmount(70.0, Unit.PERCENT));
		
		recipeMap.put(drinkName, new DrinkRecipe(drinkName, ingredientMap));
		
		// Blakes Special
		drinkName = "Blakes Special";
		ingredientMap = new HashMap<Drink, DrinkAmount>();
		ingredientMap.put(drinkMap.get("Smirnoff - VODKA"), new DrinkAmount(40.0, Unit.PERCENT));
		ingredientMap.put(drinkMap.get("7 Up"), new DrinkAmount(10.0, Unit.PERCENT));
		ingredientMap.put(drinkMap.get("Orange Fanta"), new DrinkAmount(10.0, Unit.PERCENT));
		ingredientMap.put(drinkMap.get("Lemonade"), new DrinkAmount(40.0, Unit.PERCENT));
		
		recipeMap.put(drinkName, new DrinkRecipe(drinkName, ingredientMap));
		
		// Black Velvet 7 Up
		drinkName = "Black Velvet 7 Up";
		ingredientMap = new HashMap<Drink, DrinkAmount>();
		ingredientMap.put(drinkMap.get("Black Velvet - WHISKEY"), new DrinkAmount(30.0, Unit.PERCENT));
		ingredientMap.put(drinkMap.get("7 Up"), new DrinkAmount(70.0, Unit.PERCENT));
		
		recipeMap.put(drinkName, new DrinkRecipe(drinkName, ingredientMap));
		
		return recipeMap;
	}

	public static void buildDefaultContainers(Map<String, Drink> drinkMap, DrinkMaker drinkMaker) {
		// Load Lemonade
		Drink drink = drinkMap.get("Lemonade");
		drinkMaker.loadDrinkContainer(new DrinkContainer(drink, new DrinkAmount(2.0, Unit.LITER)), 1);
		
		// Load Coke
		drink = drinkMap.get("Coke");
		drinkMaker.loadDrinkContainer(new DrinkContainer(drink, new DrinkAmount(2.0, Unit.LITER)), 2);
		
		// Load Captain Morgan - RUM
		drink = drinkMap.get("Captain Morgan - RUM");
		drinkMaker.loadDrinkContainer(new DrinkContainer(drink, new DrinkAmount(1.0, Unit.LITER)), 3);
		
		// Load Smirnoff - VODKA
		drink = drinkMap.get("Smirnoff - VODKA");
		drinkMaker.loadDrinkContainer(new DrinkContainer(drink, new DrinkAmount(1.75, Unit.LITER)), 4);
		
		// Load 7 Up 
		drink = drinkMap.get("7 Up");
		drinkMaker.loadDrinkContainer(new DrinkContainer(drink, new DrinkAmount(2.0, Unit.LITER)), 5);
		
		// Load Orange Fanta
		drink = drinkMap.get("Orange Fanta");
		drinkMaker.loadDrinkContainer(new DrinkContainer(drink, new DrinkAmount(2.0, Unit.LITER)), 6);
	}
}
