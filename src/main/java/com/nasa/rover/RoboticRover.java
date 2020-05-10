package com.nasa.rover;

import com.nasa.CompassPoint;
import com.nasa.Coordinate;
import com.nasa.Plateau;
import com.nasa.command.RoverCommand;

import java.util.List;

public class RoboticRover implements Rover{

  private final Plateau landedPlateau;

  private Coordinate currentCoordinate;
  private CompassPoint compassPoint;

  public RoboticRover(Coordinate currentCoordinate, CompassPoint compassPoint,
      Plateau landedPlateau) {
    this.currentCoordinate = currentCoordinate;
    this.compassPoint = compassPoint;
    this.landedPlateau = landedPlateau;
  }


  @Override
  public void execute(List<RoverCommand> commandList) {
    commandList.stream().forEachOrdered(this::executeCommand);
  }

  @Override
  public String getCurrentPositionInfo() {
    return currentCoordinate.toString() + " "+ compassPoint.toString();
  }

  private void executeCommand(RoverCommand command) {

    if (RoverCommand.LEFT.equals(command)) {
      compassPoint = compassPoint.left();

    } else if (RoverCommand.RIGHT.equals(command)) {
      compassPoint = compassPoint.right();

    } else if (RoverCommand.MOVE.equals(command)) {
      move();
    }

  }

  private void move() {

    updateCurrentCoordinate( calculateNewCoordinate());

  }

  private Coordinate calculateNewCoordinate(){
    int x = currentCoordinate.getX();
    int y = currentCoordinate.getY();

    switch (this.compassPoint) {
      case NORTH:
        y += 1;
        break;
      case SOUTH:
        y -= 1;
        break;
      case EAST:
        x += 1;
        break;
      case WEST:
        x -= 1;
        break;
      default:
        throw new IllegalArgumentException("Invalid compass point type");
    }

    return new Coordinate(x, y);

  }


  private void updateCurrentCoordinate(Coordinate newCoordinate) {
    if (landedPlateau.isValidCoordinate(newCoordinate)) {
      this.currentCoordinate = newCoordinate;
    }else {
      throw new IllegalArgumentException("Plataue borders has been exceeded.");
    }
  }




}
