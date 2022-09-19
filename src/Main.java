import java.io.*;
import java.lang.reflect.Array;
import java.nio.*;
import java.util.*;
import java.lang.Object.*;

public class Main {
    public static void main(String[] args) {
        Pair<Integer, String> pair = Pair.of(1, "hello");
        Integer i = pair.getFirst(); // 1
        String s = pair.getSecond(); // "hello"
        Pair<Integer, String> pair2 = Pair.of(1, "hello");
        boolean mustBeTrue = pair.equals(pair2); // true!
        boolean mustAlsoBeTrue = pair.hashCode() == pair2.hashCode(); // true!
        System.out.println("Hello world!");

        DynamicArray<String> tes = new DynamicArray<String>(new String[]{"A", "B", "C"});
        tes.add("D");
        tes.remove(1);
        tes.get(1);
        //tes.get(3);

        DynamicArray<String> tes1 = new DynamicArray<String>();
        tes1.add("D");
    }
}