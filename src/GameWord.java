import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class GameWord {
    private final Random random = new Random();
    private final List<String> words = new ArrayList<>();

    public GameWord(String pathName) {
        try (Scanner scanner = new Scanner(new File(pathName))) {
            while (scanner.hasNext()) {
                words.add(scanner.nextLine());
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public String getRandomWord() {
        int pos = random.nextInt(words.size());
        return words.get(pos);
    }
}
