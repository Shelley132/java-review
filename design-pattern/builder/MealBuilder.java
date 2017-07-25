package builder;

/**
 * @author JUANJUAN
 * @version 2017年7月21日下午8:17:19
 */
public class MealBuilder {
	public Meal prepareVegMeal() {
		Meal meal = new Meal();
		Burger burger = new VegBurger();
		meal.addItem(burger);
		meal.addItem(new Coke());
		return meal;

	}

	public Meal prepareNonVegMeal() {
		Meal meal = new Meal();
		meal.addItem(new ChickenBurger());
		meal.addItem(new Pepsi());
		return meal;
	}
}
