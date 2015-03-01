package demo.collections.Aggregators;

import java.util.Arrays;
import java.util.List;
import java.util.OptionalDouble;

public class Aggregators {

  public static void main(String[] args) {

    List<Integer> integers = Arrays.asList(1, 2, 3, 4, 5);

    integers.stream().forEach(System.out::print);
    System.out.println();
    long i = integers.stream().filter(x -> x % 2 == 0).count();

    System.out.println("Even numbers = " + i);

    System.out.println("Sum is "
        + integers.parallelStream().filter(x -> x % 2 == 0).mapToInt(x -> x).sum());

    OptionalDouble avg =
        integers.parallelStream().filter(x -> x % 2 == 0).mapToInt(x->x).average();

    System.out.println(avg.isPresent() ? avg.getAsDouble() : "No value");



  }
}
