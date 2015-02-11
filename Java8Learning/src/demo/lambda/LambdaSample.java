package demo.lambda;

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



  }

  public static boolean isGtThan(int xxValue) {
    return xxValue > 10;
  }



  public static boolean checkIfGreaterInLamdaWay(Predicate<Integer> func, int x) {
    return func.test(x);
  }



  public static boolean checkIfGreaterInOlderWay(ICompare s, int x) {
    return s.isGtThan(x);
  }


}



interface ICompare {
  boolean isGtThan(int x);
}
