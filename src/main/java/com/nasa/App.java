package com.nasa;

import com.nasa.command.RoverCommandBuilder;
import com.nasa.printer.ConsoleRoverPrinter;
import com.nasa.printer.RoverPrinter;
import com.nasa.rover.Rover;
import com.nasa.rover.RoverBuilder;

/**
 * Application main class!
 */
public class App {
  public static void main(String[] args) {

    Plateau plateau = new Plateau(new Coordinate(5, 5));

    Rover roboticRover = new RoverBuilder().setCurrentCoordinate(new Coordinate(1, 2))
        .setCompassPoint(CompassPoint.NORTH).setLandedPlateau(plateau).createRover();

    roboticRover.execute(RoverCommandBuilder.build("LMLMLMLMM"));

    Rover roboticRover2 = new RoverBuilder().setCurrentCoordinate(new Coordinate(3, 3))
        .setCompassPoint(CompassPoint.EAST).setLandedPlateau(plateau).createRover();

    roboticRover2.execute(RoverCommandBuilder.build("MMRMMRMRRM"));

    RoverPrinter printer = new ConsoleRoverPrinter();

    printer.print(roboticRover);
    printer.print(roboticRover2);

  }

}
