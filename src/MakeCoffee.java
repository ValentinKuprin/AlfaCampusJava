public class MakeCoffee {
    public static void main(String[] args) {
        Coffee coffee = new Coffee("Jacobs");
        CoffeeMachine coffeeMachine = new CoffeeMachine();

        System.out.println(coffeeMachine.makeCoffee(1.0, 200));
        coffeeMachine.addWater(800);
        System.out.println(coffeeMachine.makeCoffee(1.0, 200));
        coffeeMachine.addCoffee(100.0, coffee);
        System.out.println(coffeeMachine.makeCoffee(1.0, 200));
        System.out.println(coffeeMachine.getСurrentAmountWater());
        System.out.println(coffeeMachine.getСurrentAmountCoffee());






    }
}
