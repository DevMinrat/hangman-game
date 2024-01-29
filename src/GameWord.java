import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class GameWord {
    private static Scanner scanner;
    private static final Random random = new Random();
    private static final List<String> words = new ArrayList<>();
    private String word;

    public GameWord(String pathName) {
        try {
            scanner = new Scanner(new File(pathName));

            while (scanner.hasNext()) {
                words.add(scanner.nextLine());
            }

            String randomWord = getRandomWord();
            setWord(randomWord);

            scanner.close();
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public String getRandomWord() {
        int pos = random.nextInt(words.size());
        return words.get(pos);
    }

    private void setWord(String word) {
        this.word = word;
    }

    public String getWord() {
        return word;
    }
}
