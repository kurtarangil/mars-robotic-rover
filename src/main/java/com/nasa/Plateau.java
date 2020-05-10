package com.nasa;

public class Plateau {
  private final Coordinate borderCoordinate;

  public Plateau(Coordinate borderCoordinate) {
    this.borderCoordinate = borderCoordinate;
  }

  public boolean isValidCoordinate(Coordinate newCoordinate) {
    return newCoordinate.getX() <= borderCoordinate.getX() && newCoordinate.getY() <= borderCoordinate.getY();
  }
}
