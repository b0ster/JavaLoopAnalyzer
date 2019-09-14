import analyzer.*;
import util.ObjectFactory;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    private static final String CURRENT_JAVA = "Java 8";
    private static final int SMALL_SIZE = 10000;
    private static final int MEDIUM_SIZE = 100000;
    private static final int BIG_SIZE = 10000000;
    private static final int[] SIZES = new int[]{SMALL_SIZE, MEDIUM_SIZE, BIG_SIZE};
    private static final List<? extends LoopAnalyzer> ANALYZERS =
            Arrays.asList(new ForAnalyzer(), new ForEachAnalyzer(), new ForInAnalyzer());

    public static void main(String... args) throws IOException {
        for (int size : SIZES) {
            final ArrayList<Object> objects = ObjectFactory.getArrayListOfObjects(size);
            for (LoopAnalyzer analyzer : ANALYZERS) {
                analyzer.setObjects(objects);
                saveResult(analyzer, analyzer.analyze());
            }
        }
    }

    private static void saveResult(LoopAnalyzer analyzer, Analyzes analyzes) throws IOException {
        saveAnalyzes(analyzer, analyzes);
        saveRawResult(analyzer, analyzes.getNanos());
    }

    private static void saveAnalyzes(LoopAnalyzer analyzer, Analyzes analyzes) throws IOException {
        final String name = analyzer.analyzerName();
        System.out.println(analyzes.toString());
        Files.write(Paths.get("results/" + CURRENT_JAVA + "/" + name + '/' + name +  "_" + analyzes.getNumberOfObjects() + "_analyzes.csv"), analyzes.toString().getBytes());
    }

    private static void saveRawResult(LoopAnalyzer analyzer, ArrayList<Long> nanoTimes) throws IOException {
        final String name = analyzer.analyzerName();
        final StringBuilder csv = new StringBuilder();
        csv.append("Object Number").append(';').append("Nano Time").append('\n');
        for (int i = 0; i < nanoTimes.size(); i++) {
            csv.append(i + 1).append(';').append(nanoTimes.get(i)).append('\n');
        }
        Files.write(Paths.get("results/" + CURRENT_JAVA + "/" + name + "/" + name + "_" + nanoTimes.size() + "_raw" + ".csv"), csv.toString().getBytes());
    }
}
