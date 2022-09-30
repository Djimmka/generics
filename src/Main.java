import java.io.*;
import java.lang.reflect.Array;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.*;
import java.util.function.*;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.stream.Collectors.*;

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

//    public static <T> void findMinMax(
//            Stream<? extends T> stream,
//            Comparator<? super T> order,
//            BiConsumer<? super T, ? super T> minMaxConsumer) {
//        //Твой код здесь
//        try {
//            stream.collect(
//                    Collectors.teeing(
//                            Collectors.minBy(order),
//                            Collectors.maxBy(order),
//                            (e1, e2) -> {
//                                minMaxConsumer.accept(e1.orElseGet(null), e2.orElseGet(null));
//                                return null;
//                            }
//                    )
//            );
//        } catch (NullPointerException e) {
//            minMaxConsumer.accept(null, null);
//        }
//        ;
//    }

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
        Charset charset = Charset.forName("UTF-8");
        String text = "Lorem ipsum dolor sit amet, "
                + "consectetur 32 adipiscing elit. "
                + "Sed sodales consectetur purus at faucibus."
                + " Donec mi quam, tempor vel ipsum non, faucibus suscipit massa. "
                + "Morbi lacinia velit blandit 32 tincidunt 32 efficitur. "
                + "Vestibulum eget metus imperdiet sapien laoreet faucibus. "
                + "Nunc eget vehicula mauris, ac auctor lorem. 32 Lorem ipsum dolor sit amet,"
                + " consectetur adipiscing elit. Integer vel odio 32 nec mi tempor dignissim.";
        ByteArrayInputStream textInput = new ByteArrayInputStream(text.getBytes());
        System.setIn(textInput);
        //countOfWords(System.in, charset);
        InputStream in = System.in;
//Charset charset = StandardCharsets.UTF_8;
        Stream<String> lines = null;
        //try {
            lines = new BufferedReader(new InputStreamReader(in, charset)).lines();
//        } catch (UnsupportedEncodingException e) {
//            throw new RuntimeException(e);
//        }
//        lines.forEach(System.out::println);
//        Stream<String> splited = Stream.of();
        List<String> splited = Arrays.asList(lines.flatMap(p -> Arrays.asList(p.split(" ")).stream()).map(String::toLowerCase).toArray(String[]::new));
//        splited.forEach(System.out::println);
        Map<String , Long> counted = splited.stream()
//                .peek(System.out :: println)
//                .limit(10)
                .collect(groupingBy(t -> t, counting()));
//        counting.forEach((name , count) -> System.out.println(name + " " + count));
        SortedMap<String, Long> sorted = new TreeMap<>(counted);
        sorted.entrySet().stream().limit(10).forEach((word -> System.out.println(word)));//.getKey()
//        counting.forEach(System.out::printf);


//        List<String> collection2 = Arrays.asList("1 2 0", "4 5");
//        List<String> collection1 = Arrays.asList("a1", "a2", "a3", "a1");
//        List<String> collexction3 = Arrays.asList(collection2.stream().flatMap(p -> Arrays.asList(p.split(" ")).stream()).toArray(String[]::new));
//        collexction3.stream().forEach(System.out::println);
    }
}