package analyzer;

import java.util.ArrayList;

public class ForEachAnalyzer implements LoopAnalyzer {
    private ArrayList<Object> objects;

    @Override
    public Analyzes analyze() {
        final ArrayList<Long> times = new ArrayList<>();
        objects.forEach(e -> times.add(System.nanoTime()));
        return new Analyzes(this, times);
    }

    @Override
    public String analyzerName() {
        return "ForEach";
    }

    @Override
    public void setObjects(ArrayList<Object> objects) {
        this.objects = objects;
    }
}
