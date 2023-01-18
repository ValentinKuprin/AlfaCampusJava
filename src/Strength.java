public enum Strength {
    MILD(0.5),
    NORMAL(0.75),
    STRONG(1.0);

    private double strength;
    Strength(double strength) {
        this.strength = strength;
    }

    public double getStrength() {
        return strength;
    }
}
