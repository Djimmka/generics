import java.io.*;
import java.lang.reflect.Array;
import java.nio.*;
import java.util.*;
import java.lang.Object.*;

public class Main {

    public static <T> Set<T> symmetricDifference(Set<? extends T> set1, Set<? extends T> set2) {
        Set<T> result = new LinkedHashSet<>(set1);
        Iterator<? extends  T> iter = set2.iterator();
        Iterator<? extends  T> iter2 = result.iterator();
        try {
            do {
                if (!(result.add((T) iter.next()))) {
                    do {
                        if (iter.equals(iter2)) {
                            iter2.remove();
                        }
                        iter2.next();
                    }while (iter2.hasNext());
                }
                //iter.next();
            }while (iter.hasNext());
        } catch (RuntimeException e) {}

        return result;
    }
    public static void main(String[] args) {
//        Pair<Integer, String> pair = Pair.of(1, "hello");
//        Integer i = pair.getFirst(); // 1
//        String s = pair.getSecond(); // "hello"
//        Pair<Integer, String> pair2 = Pair.of(1, "hello");
//        boolean mustBeTrue = pair.equals(pair2); // true!
//        boolean mustAlsoBeTrue = pair.hashCode() == pair2.hashCode(); // true!
//        System.out.println("Hello world!");
//
//        DynamicArray<String> tes = new DynamicArray<String>(new String[]{"A", "B", "C"});
//        //tes.add("D");
//        tes.remove(1);
//        tes.get(1);
//        tes.get(3);

        Set<Integer> set1 = new LinkedHashSet<Integer>(3);
        set1.add(1); set1.add(2);set1.add(3);
        Set<Integer> set2 = new LinkedHashSet<Integer>(3);
        set2.add(0); set2.add(1);set2.add(2);
        Set<Integer> set3 = symmetricDifference(set1, set2);
        System.out.println(set1);
        System.out.println(set2);
        System.out.println(set3);

    }
}