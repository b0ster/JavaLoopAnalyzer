package analyzer;

import java.util.ArrayList;

public interface LoopAnalyzer {
    String analyzerName();

    Analyzes analyze();

    void setObjects(ArrayList<Object> objects);
}
