package com.nasa.rover;

import com.nasa.CompassPoint;
import com.nasa.Coordinate;
import com.nasa.Plateau;

public class RoverBuilder {
  private Coordinate currentCoordinate;
  private CompassPoint compassPoint;
  private Plateau landedPlateau;

  public RoverBuilder setCurrentCoordinate(Coordinate currentCoordinate) {
    this.currentCoordinate = currentCoordinate;
    return this;
  }

  public RoverBuilder setCompassPoint(CompassPoint compassPoint) {
    this.compassPoint = compassPoint;
    return this;
  }

  public RoverBuilder setLandedPlateau(Plateau landedPlateau) {
    this.landedPlateau = landedPlateau;
    return this;
  }

  public RoboticRover createRover() {
    return new RoboticRover(currentCoordinate, compassPoint, landedPlateau);
  }
}
