public class MakeCoffee {
    public static void main(String[] args) {
        Coffee groundCoffee = new Coffee("Jacobs", CoffeeType.GROUND);
        Coffee beansCoffee = new Coffee("Jacobs", CoffeeType.BEANS);
        CoffeeMachine coffeeMachine = new CoffeeMachine(Strength.MILD.getStrength());

        System.out.println(coffeeMachine.makeCoffee(1.0, 200));
        coffeeMachine.addWater(800);
        System.out.println(coffeeMachine.makeCoffee(1.0, 200));
        coffeeMachine.addCoffee(100.0, groundCoffee);
        coffeeMachine.addCoffee(100.0, beansCoffee);
        System.out.println(coffeeMachine.makeCoffee(Strength.NORMAL.getStrength(), 200));
        System.out.println(coffeeMachine.getСurrentAmountWater());
        System.out.println(coffeeMachine.getСurrentAmountCoffee());
    }
}
