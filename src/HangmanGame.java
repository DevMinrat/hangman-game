import java.util.Objects;
import java.util.Scanner;

public class HangmanGame {
    private Scanner scanner;
    private String riddleWord;
    private int mistakeCounter;

    public HangmanGame(GameWord word) {
        this.riddleWord = word.getWord().toLowerCase();
        this.scanner = new Scanner(System.in);
    }

    public void playGame() {
        if (!startOrLeave())
            return;

        StringBuilder mask = new StringBuilder("_".repeat(riddleWord.length()));
        printGameState(mask);

        System.out.println(riddleWord);
    }

    private boolean startOrLeave() {
        System.out.println("Начать новую игру? Введите Y/N: ");

        do {
            String input = scanner.nextLine().toLowerCase();

            if (Objects.equals(input, "n")) {
                System.out.println("До встречи!");
                return false;
            } else if (Objects.equals(input, "y")) {
                System.out.println("Начнем игру!");
                return true;
            } else {
                System.out.println("Введите 'Y' для начала игры или 'N' для завершения!");
            }
        } while (true);

    }

    private String getGallows(int mistakeCounter) {
        switch (mistakeCounter) {
            case 0 -> {
                return Gallows.ZERO.getGallows();
            }
            case 1 -> {
                return Gallows.ONE.getGallows();
            }
            case 2 -> {
                return Gallows.TWO.getGallows();
            }
            case 3 -> {
                return Gallows.THREE.getGallows();
            }
            case 4 -> {
                return Gallows.FOUR.getGallows();
            }
            case 5 -> {
                return Gallows.FIVE.getGallows();
            }
            case 6 -> {
                return Gallows.SIX.getGallows();
            }
            default -> throw new IllegalArgumentException("Неправильный счетчик ошибки");
        }
    }

    private void printGameState(StringBuilder mask) {
        System.out.println(getGallows(mistakeCounter));
        System.out.println("Cлово: " + mask);
        System.out.println("Ошибки (" + mistakeCounter + "): " + "ф");

    }

    private void playerTurn() {
        System.out.println("Введите букву: ");
        String input = scanner.nextLine();
        validateInput(input);
        System.out.println(input);
    }

    private boolean validateInput(String input) {
        // regex - check only russian single word
        return true;
    }
}
