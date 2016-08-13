package application;

import java.util.ArrayList;

import drinkManager.DrinkContainer;
import drinkManager.DrinkMaker;
import drinkManager.DrinkRecipe;
import org.json.simple.JSONObject;
import org.springframework.web.bind.annotation.*;

@RestController
public class ApplicationController {

    @RequestMapping(value = "/buildDrink", method = RequestMethod.POST, consumes = "application/json")
    public boolean buildDrink(@RequestBody JSONObject postPayload) {
        return DrinkMaker.getInstance().buildDrink(new DrinkRecipe(new JSONObject(postPayload)));
    }

    @RequestMapping(value = "/loadContainer", method = RequestMethod.POST, consumes = "application/json")
    public boolean loadContainer(@RequestParam(value = "containerNumber") int containerNumber, @RequestBody JSONObject postPayload) {
        return DrinkMaker.getInstance().loadDrinkContainer(new DrinkContainer(postPayload), containerNumber);
    }

    @RequestMapping(value = "/refillContainer", method = RequestMethod.POST, consumes = "application/json")
    public boolean refillContainer(@RequestParam(value="containerNumber") int containerNumber) {
        return DrinkMaker.getInstance().refillDrinkContainer(containerNumber);
    }

    @RequestMapping(value = "/currentContainerStatus", method = RequestMethod.GET)
    public ArrayList<DrinkContainer> refillContainer() {
        return DrinkMaker.getInstance().getDrinkLayout();

    }

}