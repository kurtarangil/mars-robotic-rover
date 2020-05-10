package com.nasa.rover;

import com.nasa.CompassPoint;
import com.nasa.Coordinate;
import com.nasa.Plateau;
import com.nasa.command.RoverCommandBuilder;
import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class RoboticRoverTest {

  private Rover rover;

  @Test
  public void execute_success() {

    rover = new RoverBuilder().setCurrentCoordinate(new Coordinate(1, 2)).setCompassPoint(CompassPoint.NORTH)
        .setLandedPlateau(new Plateau(new Coordinate(5, 5))).createRover();

    rover.execute(RoverCommandBuilder.build("LMLMLMLMM"));

    assertThat(rover.getCurrentPositionInfo(), is("1 3 N"));

  }

  @Test
  public void execute_success2() {

    rover = new RoverBuilder().setCurrentCoordinate(new Coordinate(3, 3)).setCompassPoint(CompassPoint.EAST)
        .setLandedPlateau(new Plateau(new Coordinate(5, 5))).createRover();

    rover.execute(RoverCommandBuilder.build("MMRMMRMRRM"));

    assertThat(rover.getCurrentPositionInfo(), is("5 1 E"));

  }

  @Test(expected = IllegalArgumentException.class)
  public void execute_plateau_exceeded_failed() {

    rover = new RoverBuilder().setCurrentCoordinate(new Coordinate(0, 0)).setCompassPoint(CompassPoint.EAST)
        .setLandedPlateau(new Plateau(new Coordinate(2, 2))).createRover();

    rover.execute(RoverCommandBuilder.build("MMMMMMMMMMMMMMM"));

  }


  @Test(expected = IllegalArgumentException.class)
  public void execute_invalid_coordinates_failed() {

    rover = new RoverBuilder().setCurrentCoordinate(new Coordinate(-1, 0)).setCompassPoint(CompassPoint.EAST)
        .setLandedPlateau(new Plateau(new Coordinate(2, 2))).createRover();

  }


}
