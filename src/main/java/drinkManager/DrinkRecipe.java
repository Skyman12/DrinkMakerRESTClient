package drinkManager;

import drinkTypes.Drink;
import org.json.simple.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class DrinkRecipe {
    private String drinkName;

	private Map<Drink, DrinkAmount> ingredients;
	
	public DrinkRecipe(String drinkName, Map<Drink, DrinkAmount> ingredientMap) {
		this.drinkName = drinkName;
		this.ingredients = ingredientMap;
	}

    public DrinkRecipe(JSONObject jsonObject) {
        drinkName = (String) jsonObject.get("drinkName");
        ingredients = (Map<Drink, DrinkAmount>) jsonObject.get("ingredients");
    }

	public Map<Drink, DrinkAmount> getIngredients() {
		return ingredients;
	}

    public String getDrinkName() {
        return drinkName;
    }
	
	public String toString() {
		String temp = drinkName + "\n";
		temp += "--------\n";
		for (Drink d : ingredients.keySet()) {
			temp += d.toString() + " - " + ingredients.get(d).toString() + "%\n";
		}
		return temp;
	}

	public JSONObject buildJson() {
		JSONObject jsonObject = new JSONObject();
		jsonObject.put("ingredients" , ingredients);
		jsonObject.put("drinkName", drinkName);
		return jsonObject;
	}

}
