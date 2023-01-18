public class Coffee {
    private String nameOfCoffee;
    CoffeeType coffeeType;

    public Coffee(String nameOfCoffee, CoffeeType coffeeType) {
        this.nameOfCoffee = nameOfCoffee;
        this.coffeeType = coffeeType;
    }

    public String getFullNameOfCoffee(CoffeeType coffeeType) {
        return nameOfCoffee.concat(" ").concat(coffeeType.getDescriptionCoffee());
    }
}