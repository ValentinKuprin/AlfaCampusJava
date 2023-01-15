package CoffeeMachine;

public class MakeCoffee {
    public static void main(String[] args) {
        Coffee coffee = new Coffee("Jacobs");
        CoffeeMachine coffeeMachine = new CoffeeMachine();

        System.out.println(coffeeMachine.makeCoffee(0.8, 200));
        coffeeMachine.addWater(2000);
        System.out.println(coffeeMachine.makeCoffee(0.8, 200));
        coffeeMachine.addCoffee(500.0, coffee);
        System.out.println(coffeeMachine.makeCoffee(0.8, 200));
        System.out.println(coffeeMachine.getСurrentAmountWater());
        System.out.println(coffeeMachine.getСurrentAmountCoffee());
    }
}