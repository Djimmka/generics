import java.io.*;
import java.nio.charset.Charset;
import java.util.*;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.UnaryOperator;

public class Main {

    public static <T> Set<T> symmetricDifference(Set<? extends T> set1, Set<? extends T> set2) {
        Set<T> result = new HashSet<>(set1);
        Set<T> remove = new HashSet<>(set1);
        remove.retainAll(set2);
        result.addAll(set2);
        result.removeAll(remove);
        return result;
    }

    public static String readAsString(InputStream inputStream, Charset charset) throws IOException {
        Reader reader = new InputStreamReader(inputStream, charset);
        BufferedReader newIn = new BufferedReader(reader);
        StringBuilder str = new StringBuilder();
        while (newIn.ready()) {
            str.append(newIn.read());
        }
        return str.toString();
    }

    public static Map<String, Long> getSalesMap(Reader reader) {
        //решить через merge
        BufferedReader newIn = new BufferedReader(reader);
        Map<String, Long> result = new HashMap<>();
        try {
            while (newIn.ready()) {
                String readed = newIn.readLine();
                String[] employe = readed.split(" ");
                result.merge(employe[0], Long.parseLong(employe[1]), Long::sum);
                if (result.containsKey(employe[0])) {
                    result.replace(employe[0], Long.sum(result.get(employe[0]), Long.parseLong(employe[1])));
                } else {
                    result.put(employe[0], Long.parseLong(employe[1]));
                }
            }
        } catch (IOException e) {
        }
        return result;
    }




    public static <T, U> Function<T, U> ternaryOperator(
            Predicate<? super T> condition,
            Function<? super T, ? extends U> ifTrue,
            Function<? super T, ? extends U> ifFalse) {
        return s -> (condition.test(s)) ? (ifTrue.apply(s)) : (ifFalse.apply(s));
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
//
//        Set<Integer> set1 = new LinkedHashSet<Integer>(3);
//        set1.add(1); set1.add(2);set1.add(3);
//        Set<Integer> set2 = new LinkedHashSet<Integer>(3);
//        set2.add(0); set2.add(1);set2.add(2);
//        Set<Integer> set3 = symmetricDifference(set1, set2);
//        System.out.println(set1);
//        System.out.println(set2);
//        System.out.println(set3);

        Scanner scanner = new Scanner(System.in);
        Deque<Integer> read = new ArrayDeque<>();
        boolean isEven = false;
        while (scanner.hasNextInt()) {
            if (isEven) {
                read.addFirst(scanner.nextInt());
            } else {
                scanner.nextInt();
            }
            isEven = !(isEven);
        }
        StringBuilder str = new StringBuilder();
        read.forEach(readed -> str.append(readed + " "));
        str.deleteCharAt(str.lastIndexOf(" "));
        System.out.println(str);
    }
}