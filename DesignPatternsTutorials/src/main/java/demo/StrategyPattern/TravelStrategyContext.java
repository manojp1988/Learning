package demo.StrategyPattern;

import lombok.Data;

@Data
public class TravelStrategyContext {


  private IRide iride;

  public void ridetoAirport() {

    System.out.println("Cost " + iride.cost() + " Time to travel " + iride.timeToTravel());

  }

}
