package analyzer;

import java.util.ArrayList;

public class ForAnalyzer implements LoopAnalyzer {
    private ArrayList<Object> objects;

    @Override
    public Analyzes analyze() {
        final ArrayList<Long> times = new ArrayList<>();
        for (Object o : objects) {
            times.add(System.nanoTime());
        }
        return new Analyzes(this, times);
    }

    @Override
    public String analyzerName() {
        return "ForLoop";
    }

    @Override
    public void setObjects(ArrayList<Object> objects) {
        this.objects = objects;
    }
}
