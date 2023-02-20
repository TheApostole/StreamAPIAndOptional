import java.awt.im.InputSubset;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import java.util. function.BiConsumer;
public class Main {
    public static void main(String[] args) {
        //Задание 1
        List<Integer> numbers = Arrays.asList(23, 432, 3, 4, 32, 4, 3232, 44, 48, 2643, 243, 25);
        Stream<Integer> numbersStream = numbers.stream();
        Comparator<Integer> numbersComparator = Comparator.comparing(Integer::intValue);
        BiConsumer<Integer, Integer> numbersBiConsumer = (min, max) -> System.out.println("Минимальное число: " + min + ", Максимальное число: " + max);
        findMinMax(numbersStream, numbersComparator, numbersBiConsumer);

        //Задание 2
        determinesTheQuantityOfEvenNumbersAndOutputsThem(numbers);

        //Доп задание
        List<Integer> numbersList = Arrays.asList(27, 43, 38, 78, 3879, 67, 323, 47097, 464, 26, 24, 2524);
        Optional<Integer> max = numbersList.stream().max(Integer::compare);
        Optional<Integer> min = numbersList.stream().min(Integer::compare);
        System.out.println("Максивальное число: " + max.get());
        System.out.println("Минимальное число: " + min.get());
    }

    /** Задание 1 */
    public static <T> void findMinMax(Stream <? extends T> stream,
                                      Comparator <? super T> order,
                                      BiConsumer <? super T, ? super T> minMaxConsumer) {
        List<T> list = stream.collect(Collectors.toList());
        if (list.isEmpty()) {
            minMaxConsumer.accept(null, null);
        }else {
            list.sort(order);
            minMaxConsumer.accept(list.get(0), list.get(list.size() - 1));
        }
    }

    /** Задание 2 */
    public static void determinesTheQuantityOfEvenNumbersAndOutputsThem(List<Integer> numbersList) {
        Stream<Integer> numbersStream  = numbersList.stream().filter(n -> n % 2 == 0);
        List<Integer> collect = numbersStream.collect(Collectors.toList());
        System.out.println("Количество четных чисел: " + collect.size());
        System.out.println(collect);
    }
}