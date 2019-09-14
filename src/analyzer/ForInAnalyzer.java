package analyzer;

import java.util.ArrayList;

public class ForInAnalyzer  implements LoopAnalyzer{
    private ArrayList<Object> objects;

    @Override
    public Analyzes analyze() {
        final ArrayList<Long> times = new ArrayList<>();
        for (int i = 0; i < objects.size(); i++) {
            times.add(System.nanoTime());
        }
        return new Analyzes(this, times);
    }

    @Override
    public String analyzerName() {
        return "ForIn";
    }

    @Override
    public void setObjects(ArrayList<Object> objects) {
        this.objects = objects;
    }
}
