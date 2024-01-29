public enum Gallows {
    ONE(1),
    TWO(2),
    THREE(3),
    FOUR(4),
    FIVE(5),
    SIX(6);

    private String gallowsStep;

    private String ONE() {
        return "2";
    }

    Gallows(int i) {
        this.gallowsStep = ONE();
    }
}
