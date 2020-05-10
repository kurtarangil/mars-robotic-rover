package com.nasa;

public class Coordinate {

  private int x;
  private int y;

  public Coordinate(int x, int y) {

    if (x < 0 || y < 0) {
      throw new IllegalArgumentException("X and Y coordinates cannot be smaller than 0");
    }
    this.x = x;
    this.y = y;
  }

  public int getX() {
    return x;
  }

  public int getY() {
    return y;
  }

  @Override
  public String toString() {
    return x + " " + y;

  }
}
