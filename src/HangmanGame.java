import java.util.ArrayList;
import java.util.Scanner;

public class HangmanGame {
    private final Scanner scanner;
    private final String[] riddleWord;
    private final StringBuilder mask;
    private int mistakeCounter;
    private final ArrayList<String> mistakeLetters = new ArrayList<>();

    private static final String SINGLE_LETTER_REGEX = "^[А-Яа-я]$";
    private static final int MAX_MISTAKES = 6;

    public HangmanGame(String word) {
        this.riddleWord = word.toLowerCase().split("");
        this.scanner = new Scanner(System.in);
        this.mask = new StringBuilder("_".repeat(riddleWord.length));
    }

    public void playGame() {
        while (checkGameState()) {
            printGameState();
            String letter = playerGuess();
            openLettersOrAddMistake(letter);
        }
    }

    private String getGallows() {
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

    private void printGameState() {
        System.out.println(getGallows());
        System.out.println("Cлово: " + mask);
        System.out.printf("Ошибки (%d): \u001B[31m%s\u001B[0m%n", mistakeCounter, String.join(", ", mistakeLetters));
    }

    private String playerGuess() {
        System.out.println("Введите букву: ");
        String input;

        do {
            input = scanner.nextLine().toLowerCase();
        } while (!validateInput(input));

        return input;
    }

    private void openLettersOrAddMistake(String letter) {
        boolean successGuess = false;

        for (int i = 0; i < riddleWord.length; i++) {
            if (riddleWord[i].equals(letter)) {
                successGuess = true;
                mask.replace(i, i + 1, letter.toUpperCase());
            }
        }

        if (!successGuess) {
            mistakeCounter++;
            mistakeLetters.add(letter);
        }
    }

    private boolean validateInput(String input) {
        if (input.matches(SINGLE_LETTER_REGEX)) {
            if (mistakeLetters.contains(input) || mask.indexOf(input.toUpperCase()) != -1) {
                System.out.println("Вы уже использовали эту букву! Выберите другую: ");
                return false;
            } else
                return true;

        } else {
            System.out.println("Неверный ввод! Введите только 1 букву из кириллического алфавита: ");
            return false;
        }
    }

    private boolean checkGameState() {
        String word = String.join("", riddleWord);

        if (mistakeCounter == MAX_MISTAKES) {
            System.out.printf("Вы проиграли! Загаданное слово: %s", word);
            return false;
        } else if (!mask.toString().contains("_")) {
            System.out.printf("Поздравляем! Вы победили! Загаданное слово: %s", word);
            return false;
        } else {
            return true;
        }
    }
}
