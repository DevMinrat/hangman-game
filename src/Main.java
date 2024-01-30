import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        GameWord word = new GameWord("words.txt");

        while (startOrLeave()) {
            HangmanGame game = new HangmanGame(word.getRandomWord());
            game.playGame();
        }
    }

    public static boolean startOrLeave() {
        System.out.println("\nНачать новую игру? Введите Y/N: ");
        Scanner scanner = new Scanner(System.in);

        do {
            String input = scanner.nextLine().toLowerCase();

            if (input.equals("n")) {
                System.out.println("До встречи!");
                return false;
            } else if (input.equals("y")) {
                System.out.println("Начнем игру!");
                return true;
            } else {
                System.out.println("Введите 'Y' для начала игры или 'N' для завершения!");
            }
        } while (true);
    }
}