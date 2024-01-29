public class Main {
    public static void main(String[] args) {
        String word = new GameWord("words.txt").getWord();
        System.out.println(word);
        HangmanGame game = new HangmanGame(word);

//        game.playGame();
    }

    public static void gameLoop() {
        //askStartOrLeave
        //startGame
    }

    public static void startGame(){
        //getRandomWord
    }

}