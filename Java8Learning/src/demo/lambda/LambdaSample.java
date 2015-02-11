package demo.lambda;
import java.util.function.Function;
import java.util.function.Predicate;

public class LambdaSample {

  public static void main(String[] args) {

    System.out.println(checkIfGreaterInOlderWay(new ICompare() {

      @Override
      public boolean isGtThan(int x) {
        return x > 10;
      }
    }, 2));

    System.out.println(checkIfGreaterInLamdaWay(x -> x > 10, 2));

    System.out.println(checkIfGreaterInLamdaWay(LambdaSample::isGtThan, 2));

    System.out.println(getSquareOfX(x -> x * x, 2));

    System.out.println(getSquareOfX(LambdaSample::sqOfX, 2));

    System.out.println(LambdaSample.sqOfX(2));

    System.out.println(submit(x -> "Jo"));

  }

  public static boolean isGtThan(int xxValue) {
    return xxValue > 10;
  }

  public static int sqOfX(int x) {
    return x * x;
  }

  public static boolean checkIfGreaterInLamdaWay(Predicate<Integer> func, int x) {
    return func.test(x);
  }

  public static int getSquareOfX(Function<Integer, Integer> func, int x) {
    return func.apply(x);
  }

  public static boolean checkIfGreaterInOlderWay(ICompare s, int x) {
    return s.isGtThan(x);
  }

  public static void submit(A a) {
    a.display();
  }

  public static String submit(B b) {

    return "H";
  }

}

interface A {
  void display();
}

interface B {
  String sayHello(String a);
}

interface ICompare {
  boolean isGtThan(int x);
}
