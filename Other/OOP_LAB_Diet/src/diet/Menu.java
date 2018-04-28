package diet;

import java.util.Optional;

/**
 * Represents a complete menu.
 * 
 * It can be made up of both packaged products and servings of given recipes.
 *
 */
public class Menu extends Element {

	private Food food;

	/**
	 * Menu constructor.
	 * The reference {@code food} of type {@link Food} must be used to
	 * retrieve the information about recipes and products 
	 * 
	 * @param nome unique name of the menu
	 * @param food object containing the information about products and recipes
	 */
	public Menu(String name, Food food) {
		super(name, 0.0, 0.0, 0.0, 0.0);
		this.food = food;
	}
	
	/**
	 * Adds a given serving size of a recipe.
	 * The recipe is a name of a recipe defined in the {@code food}
	 * argument of the constructor.
	 * 
	 * @param recipe the name of the recipe to be used as ingredient
	 * @param quantity the amount in grams of the recipe to be used
	 */
	public void addRecipe(String recipe, double quantity) {
		
		Optional<NutritionalElement> element = Optional.of(food.getRecipe(recipe));

		if (!element.isPresent()) {
			throw new IllegalArgumentException(String.format("Unable to retrieve '%s' from '%s'.", recipe, food.getClass()));
		}

		quantity /= (element.get().per100g()) ? 100 : 1;

		calories += element.get().getCalories() * quantity;
		proteins += element.get().getProteins() * quantity;
		carbs += element.get().getCarbs() * quantity;
		fat += element.get().getFat() * quantity;
	}

	/**
	 * Adds a unit of a packaged product.
	 * The product is a name of a product defined in the {@code food}
	 * argument of the constructor.
	 * 
	 * @param product the name of the product to be used as ingredient
	 */
	public void addProduct(String product) {

		Optional<NutritionalElement> element = Optional.of(food.getProduct(product));

		if (!element.isPresent()) {
			throw new IllegalArgumentException(String.format("Unable to retrieve '%s' from '%s'.", product, food.getClass()));
		}

		calories += element.get().getCalories();
		proteins += element.get().getProteins();
		carbs += element.get().getCarbs();
		fat += element.get().getFat();
	}

	/**
	 * Indicates whether the nutritional values returned by the other methods
	 * refer to a conventional 100g quantity of nutritional element,
	 * or to a unit of element.
	 * 
	 * For the {@link Menu} class it must always return {@code false}:
	 * nutritional values are provided for the whole menu.
	 * 
	 * @return boolean indicator
	 */
	@Override
	public boolean per100g() {
		// nutritional values are provided for the whole menu.
		return false;
	}

	@Override
	public String toString() {
		return "Nutritional value for menu " + getName() + 
						   "\n\tCalories : " + getCalories() +
						   "\n\tCarbs    : " + getCarbs() +
						   "\n\tFat      : " + getFat() +
						   "\n\tProteins : " + getProteins() +
						   ".";
	}
}
