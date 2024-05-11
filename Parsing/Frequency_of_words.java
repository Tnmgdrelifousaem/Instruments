import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class WordFrequency {
    public static void main(String[] args) {
        try {
            File file = new File("input.txt");
            Scanner scanner = new Scanner(file);
            Map<String, Integer> wordFrequency = new HashMap<>();

            while (scanner.hasNext()) {
                String word = scanner.next().toLowerCase();
                word = word.replaceAll("[^a-zA-Z]", ""); // Удаляем все знаки пунктуации
                if (!word.isEmpty()) {
                    wordFrequency.put(word, wordFrequency.getOrDefault(word, 0) + 1);
                }
            }

            for (Map.Entry<String, Integer> entry : wordFrequency.entrySet()) {
                System.out.println("Слово: " + entry.getKey() + ", Частота: " + entry.getValue());
            }

            scanner.close();
        } catch (FileNotFoundException e) {
            System.err.println("Файл не найден!");
        }
    }
}
