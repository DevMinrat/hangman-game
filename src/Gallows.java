public enum Gallows {
    ZERO("   +-----+\n   |     |\n         |\n         |\n         |\n         |\n=========|"),
    ONE("   +-----+\n   |     |\n   O     |\n         |\n         |\n         |\n=========|"),
    TWO("   +-----+\n   |     |\n   O     |\n   |     |\n         |\n         |\n=========|"),
    THREE("   +-----+\n   |     |\n   O     |\n  /|     |\n         |\n         |\n=========|"),
    FOUR("   +-----+\n   |     |\n   O     |\n  /|\\    |\n         |\n         |\n=========|"),
    FIVE("   +-----+\n   |     |\n   O     |\n  /|\\    |\n  /      |\n         |\n=========|"),
    SIX("   +-----+\n   |     |\n   O     |\n  /|\\    |\n  / \\    |\n         |\n=========|");

    private final String gallowsStep;

    public String getGallows() {
        return gallowsStep;
    }

    Gallows(String gallowsStep) {
        this.gallowsStep = gallowsStep;
    }
}
