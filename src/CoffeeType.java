public enum CoffeeType {
    GROUND("Молотый"),
    BEANS("в зернах");

    private String typeCoffee;

   CoffeeType(String typeCoffee) {
        this.typeCoffee = typeCoffee;
    }
    public String getDescriptionCoffee() {
        return typeCoffee;
    }

}
