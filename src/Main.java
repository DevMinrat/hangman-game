import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        GameWord word = new GameWord("words.txt");

        while (startOrLeave(scanner)) {
            HangmanGame game = new HangmanGame(word.getRandomWord(), scanner);
            game.playGame();
        }

        scanner.close();
    }

    public static boolean startOrLeave(Scanner scanner) {
        System.out.println("\nНачать новую игру? Введите Да/Нет: ");
        do {
            String input = scanner.nextLine().toLowerCase();

            if (input.equals("нет")) {
                System.out.println("До встречи!");
                return false;
            } else if (input.equals("да")) {
                System.out.println("Начнем игру!");
                return true;
            } else {
                System.out.println("Введите 'Да' для начала игры или 'Нет' для завершения!");
            }
        } while (true);
    }
}