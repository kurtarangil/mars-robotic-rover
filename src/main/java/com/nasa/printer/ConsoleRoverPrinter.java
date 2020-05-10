package com.nasa.printer;

import com.nasa.rover.Rover;

public class ConsoleRoverPrinter implements RoverPrinter {

  @Override
  public void print(Rover rover) {

    System.out.println(rover.getCurrentPositionInfo());

  }
}
