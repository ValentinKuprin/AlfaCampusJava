public class CoffeeMachine {
    private final int MAX_AVAILABLE_AMOUNT_WATER = 1000;
    private final int MAX_AVAILABLE_AMOUNT_COFFEE = 700;
    private final double AMOUNT_COFFEE_MAX_STRENGTH = 29.5;
    private int currentAmountWater;
    private double currentAmountCoffee;
    private Coffee coffee;

    public String getСurrentAmountCoffee() {
        return "Кофе осталось " + currentAmountCoffee + " г";
    }

    public String getСurrentAmountWater() {
        return "Воды осталось " + currentAmountWater + " мл";
    }

    public void addWater(int amountWater) {
        if (amountWater >= 0) {
            if (currentAmountWater + amountWater > MAX_AVAILABLE_AMOUNT_WATER) {
                int excessWaterVolume = currentAmountWater + amountWater;
                currentAmountWater = MAX_AVAILABLE_AMOUNT_WATER;

                System.out.println("Превышено максимально допустимое количество воды на "
                        + (excessWaterVolume - MAX_AVAILABLE_AMOUNT_WATER) + " мл"
                        + " Кофе машина наполнена до " + currentAmountWater + " мл");
            } else {
                currentAmountWater = currentAmountWater + amountWater;

                System.out.println("Кофе машина наполнена до " + (currentAmountWater) + " мл");
            }
        } else {
            System.out.println("Передан неверный параметр, обратитесь в сервисный центр");
        }
    }

    public void addCoffee(double amountCoffee, Coffee coffee) {
        this.coffee = coffee;
        if (amountCoffee >= 0) {
            if (currentAmountCoffee + amountCoffee > MAX_AVAILABLE_AMOUNT_COFFEE) {
                double excessCoffeeVolume = currentAmountCoffee + amountCoffee;
                currentAmountCoffee = MAX_AVAILABLE_AMOUNT_COFFEE;

                System.out.println("Превышено максимально допустимое количество кофе на "
                        + (excessCoffeeVolume - MAX_AVAILABLE_AMOUNT_COFFEE) + " г"
                        + " Кофе машина наполнена до " + currentAmountCoffee + " г");
            } else {
                currentAmountCoffee = currentAmountCoffee + amountCoffee;

                System.out.println("Кофе машина заполнена до " + currentAmountCoffee + " г кофе "
                        + coffee.getFullNameOfCoffee(CoffeeType.BEANS));
            }
        } else {
            System.out.println("Передан неверный параметр, обратитесь в сервисный центр");
        }
    }

    public String makeCoffee(double strength, int cupVolume) {
        if (strength >= 0 && strength <= 1) {
            if (cupVolume >= 0) {
                if (cupVolume > currentAmountWater) {

                    return "Долейте воды";
                } else if (AMOUNT_COFFEE_MAX_STRENGTH * strength > currentAmountCoffee) {

                    return "Досыпьте кофе";
                } else {
                    currentAmountWater = currentAmountWater - cupVolume;
                    currentAmountCoffee = currentAmountCoffee - (AMOUNT_COFFEE_MAX_STRENGTH * strength);

                    return "Готовлю " + coffee.getFullNameOfCoffee(CoffeeType.BEANS) + " объемом " + cupVolume + " крепость " + strength;
                }
            }

            return "Передан неверный параметр, обратитесь в сервисный центр";
        }

        return "Передан неверный параметр, обратитесь в сервисный центр";
    }
}
