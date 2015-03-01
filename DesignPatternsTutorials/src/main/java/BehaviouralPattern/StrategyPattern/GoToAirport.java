package BehaviouralPattern.StrategyPattern;

import java.util.Scanner;

import lombok.Cleanup;

public class GoToAirport {

  public static void main(String[] args) {

    @Cleanup
    Scanner scanner = new Scanner(System.in);
    String type = scanner.next();

    if (args.length > 1)
      type = args[0];

    TravelStrategyContext strategy = new TravelStrategyContext();

    switch (type) {
      case "Car": {
        strategy.setIride(new Car());
        strategy.ridetoAirport();

      }
      case "Bus": {
        strategy.setIride(new Bus());
        strategy.ridetoAirport();

      }

    }

  }

}
