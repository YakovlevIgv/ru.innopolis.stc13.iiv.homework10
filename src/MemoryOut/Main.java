/**
 * Необходимо создать программу, которая продемонстрирует утечку памяти в Java.
 * При этом объекты должны не только создаваться, но и периодически частично удаляться,
 * чтобы GC имел возможность очищать часть памяти
 */
package MemoryOut;


import java.util.ArrayList;
import java.util.Random;

public class Main {
    private static ArrayList<ArrayList<Integer>> objects = new ArrayList<ArrayList<Integer>>();
    private static ArrayList inner_objects = new ArrayList();
    private static String str_objects = new String();

    public static void main(String[] args) throws Exception {
        long i=0;
        while (true) {

            inner_objects.add(i^i);
            inner_objects.add(1);
            inner_objects.add(i^i);
            inner_objects.add(1);
            str_objects=inner_objects.toString();
            objects.add(inner_objects);
            objects.add(inner_objects);

            objects.get(0).add((int) (i+1+i+1));

            System.out.println(objects+" "+ i+str_objects);
            if (i % 3 == 0)inner_objects.clear();
            i=i*100000+1000;
        }
    }
}
