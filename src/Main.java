public class Main {
    public static void main(String[] args) {
        GameWord word = new GameWord("words.txt");
        HangmanGame game = new HangmanGame(word);

        game.playGame();
    }
}