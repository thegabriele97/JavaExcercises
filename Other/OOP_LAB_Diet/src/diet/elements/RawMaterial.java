package diet.elements;

import diet.Element;

public class RawMaterial extends Element {

    public RawMaterial(String name, double calories, double proteins, double carbs, double fat) {
        super(name, calories, proteins, carbs, fat);
    }

    @Override
    public boolean per100g() {
        return true;
    }
}