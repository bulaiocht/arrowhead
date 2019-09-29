package socket.chat;

import org.apache.commons.lang3.RandomUtils;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class NameCreator {

    private static final Path NOUNS = Paths.get("examples/src/main/resources/nouns");
    private static final Path ADJECTIVES = Paths.get("examples/src/main/resources/adjectives");

    private static List<String> adjectives;
    private static List<String> nouns;

    static  {
        try {
            nouns = new ArrayList<>(Files.readAllLines(NOUNS));
            adjectives = new ArrayList<>(Files.readAllLines(ADJECTIVES));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    public static String getRandomNickName() {
        int nounIndex = RandomUtils.nextInt(0, nouns.size());
        int adjectiveIndex = RandomUtils.nextInt(0, adjectives.size());
        return adjectives.get(adjectiveIndex) + "_" + nouns.get(nounIndex);
    }
}
