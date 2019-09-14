package analyzer;

import java.util.ArrayList;

public class Analyzes {
    private final LoopAnalyzer analyzer;
    private ArrayList<Long> result;
    private long numberOfObjects;
    private long objectsPerSecond;
    private long averageNanosPerObject;
    private long totalMilliseconds;
    private long totalNanoSeconds;

    public Analyzes(LoopAnalyzer analyzer, ArrayList<Long> result) {
        this.analyzer = analyzer;
        this.result = result;
        this.numberOfObjects = result.size();
        this.totalNanoSeconds = result.get(result.size() - 1) - result.get(0);
        this.totalMilliseconds = this.totalNanoSeconds / 100000;
        this.averageNanosPerObject = this.totalNanoSeconds / this.numberOfObjects;
        this.objectsPerSecond = (1000000000 / this.averageNanosPerObject);
    }

    public ArrayList<Long> getNanos() {
        return result;
    }

    public long getNumberOfObjects() {
        return numberOfObjects;
    }

    public long getObjectsPerSecond() {
        return objectsPerSecond;
    }

    public long getAverageNanosPerObject() {
        return averageNanosPerObject;
    }

    public long getTotalMilliseconds() {
        return totalMilliseconds;
    }

    public long getTotalNanoSeconds() {
        return totalNanoSeconds;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder();
        sb.append(analyzer.analyzerName()).append('\n').append('\n');
        sb.append("Number of objects").append(';').append(numberOfObjects).append('\n');
        sb.append("Total nanoseconds").append(';').append(totalNanoSeconds).append('\n');
        sb.append("Total milliseconds").append(';').append(totalMilliseconds).append('\n');
        sb.append("Average nanoseconds per object").append(';').append(averageNanosPerObject).append('\n');
        sb.append("Average objects per second").append(';').append(objectsPerSecond).append('\n');
        return sb.toString();
    }
}
