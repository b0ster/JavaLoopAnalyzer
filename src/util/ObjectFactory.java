package util;

import java.util.ArrayList;

public final class ObjectFactory {
    public static ArrayList<Object> getArrayListOfObjects(long numOfObjects) {
        final ArrayList<Object> objects = new ArrayList<>();
        for (int i = 0; i < numOfObjects; i++) {
            objects.add(new Object());
        }
        return objects;
    }
}
